package com.boss.xtrain.common.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PojoUtils {
    private PojoUtils() {
    }

    /**
     * 查找当前子类，以及父类的所有字段
     *
     * @param object
     * @return
     */
    private static Field[] getAllFields(Object object) {
        Class<?> clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

    /**
     * 用于dto和vo之间的转换，同类型同名转换，
     * 不同类型同名的情况下，只有Long和String能相互转换
     *
     * @param source 源对象，不可为空
     * @param target 目标对象，不可为空
     * @throws Exception
     */
    public static void copyProperties(Object source, Object target) {

        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");

        // 获取target类和类的所有字段
        Class<?> targetClass = target.getClass();
        Field[] targetField = getAllFields(target);

        Class<?> sourceClass = source.getClass();

        for (Field field : targetField) {
            String name = field.getName();
            // 通过target字段名获取描述符
            PropertyDescriptor targetDescriptor = BeanUtils.getPropertyDescriptor(targetClass, name);
            Method writeMethod = null;
            if ((targetDescriptor != null && (writeMethod = targetDescriptor.getWriteMethod()) != null)) {
                // 获取该target字段的类型，用于后面判断
                String targetType = targetDescriptor.getPropertyType().toString();
                // 通过source字段名获取描述符
                PropertyDescriptor sourceDescriptor = BeanUtils.getPropertyDescriptor(sourceClass, name);
                // 获取source字段的读方法
                Method readMethod = null;
                if (sourceDescriptor != null && (readMethod = sourceDescriptor.getReadMethod()) != null) {
                    // 获取source字段名的类型，用于后面判断
                    String sourceType = sourceDescriptor.getPropertyType().toString();
                    try {
                        // 判断读方法是否是public的
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        // 通过读方法获取字段值
                        Object value = readMethod.invoke(source);
                        // 判断写方法是否是public的
                        if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                            writeMethod.setAccessible(true);
                        }
                        if (value == null) {
                            continue;
                        }
                        if (targetType.equals(sourceType)) {
                            // 字段类型相同，直接赋值
                            writeMethod.invoke(target, value);
                        } else {
                            if (targetType.contains("Long")) {
                                // target的字段类型：Long，source的字段类型：String
                                // 一般出现在id和version转换
                                writeMethod.invoke(target, Long.valueOf(value.toString()));
                            } else if (sourceType.contains("Long")) {
                                // target的字段类型：String，source的字段类型：Long
                                // 一般出现在id和version转换
                                writeMethod.invoke(target, value.toString());
                            }
                        }
                    } catch (Exception ex) {
                        throw new FatalBeanException("无法拷贝属性 '" + name + "'", ex);
                    }
                }
            }
        }
    }

    /**
     * 将source列表中的对象拷贝到target列表中的对象上，
     * 用于vo和dto列表的拷贝
     *
     * @param sourceList 源对象列表
     * @param targetList 目标对象列表
     * @param clazz      目标对象class，用于目标对象生成实例temp
     * @param <T>
     * @param <Q>
     * @throws Exception
     */
    public static <T, Q> void copyList(List<T> sourceList, List<Q> targetList, Class<Q> clazz) {
        Assert.notNull(sourceList, "Source must not be null");

        try {
            for (T source : sourceList) {
                // 通过反射获取泛型对象，临时存储数据
                Q target = clazz.getDeclaredConstructor().newInstance();
                copyProperties(source, target);
                targetList.add(target);
            }
        } catch (Exception e) {
            throw new FatalBeanException("拷贝列表失败", e);
        }
    }

}

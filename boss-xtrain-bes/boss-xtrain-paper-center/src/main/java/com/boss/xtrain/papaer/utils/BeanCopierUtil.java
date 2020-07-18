package com.boss.xtrain.papaer.utils;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public final class BeanCopierUtil {

    private BeanCopierUtil() {
    }

    private static final ConcurrentHashMap<String, BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<>();

    private static final Map<String, ConstructorAccess> CONSTRUCTOR_ACCESS_CACHE = new ConcurrentHashMap<>();

    /**
     * 拷贝
     * @param srcObj 来源对象
     * @param destObj 目标对象
     */
    public static void copy(Object srcObj, Object destObj) {
        if (srcObj != null && destObj != null) {
            BeanCopier copier = getBeanCopier(srcObj.getClass(), destObj.getClass(), false);
            copier.copy(srcObj, destObj, null);
        }
    }

    /**
     * 拷贝
     * @param srcObj 来源对象
     * @param destObj 目标对象
     * @param converter 转换器
     */
    public static void copy(Object srcObj, Object destObj, Object converter) {
        if (srcObj != null && destObj != null) {
            BeanCopier copier = getBeanCopier(srcObj.getClass(), destObj.getClass(), true);
            copier.copy(srcObj, destObj, (Converter) converter);
        }
    }

    /**
     * 拷贝集合
     * @param sourceList 来源集合
     * @param targetClass 目标集合的元素类
     * @param <T>
     * @return
     */
    public static <T> List<T> copyPropertiesOfList(List<?> sourceList, Class<T> targetClass) {
        if (sourceList == null || sourceList.isEmpty()) {
            return Collections.emptyList();
        }
        ConstructorAccess<T> constructorAccess = getConstructorAccess(targetClass);
        List<T> resultList = new ArrayList<>(sourceList.size());
        sourceList.forEach(item -> {
            T t = null;
            t = constructorAccess.newInstance();
            copy(item, t);
            resultList.add(t);
        });
        return resultList;
    }

    /**
     * 拷贝集合
     * @param sourceList 来源对象集合
     * @param targetClass 目标集合的元素类
     * @param converter 转换器
     * @param <T>
     * @return
     */
    public static <T> List<T> copyPropertiesOfList(List<?> sourceList, Class<T> targetClass, Object converter) {
        if (sourceList == null || sourceList.isEmpty()) {
            return Collections.emptyList();
        }
        ConstructorAccess<T> constructorAccess = getConstructorAccess(targetClass);
        List<T> resultList = new ArrayList<>(sourceList.size());
        sourceList.forEach(item -> {
            T t = null;
            t = constructorAccess.newInstance();
            copy(item, t, converter);
            resultList.add(t);
        });
        return resultList;
    }


    private static <T> ConstructorAccess<T> getConstructorAccess(Class<T> targetClass) {
        ConstructorAccess<T> constructorAccess = CONSTRUCTOR_ACCESS_CACHE.get(targetClass.getName());
        if (constructorAccess != null) {
            return constructorAccess;
        }
        constructorAccess = ConstructorAccess.get(targetClass);
        constructorAccess.newInstance();
        CONSTRUCTOR_ACCESS_CACHE.put(targetClass.toString(), constructorAccess);

        return constructorAccess;
    }

    private static String genKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + destClazz.getName();
    }

    private static BeanCopier getBeanCopier(Class sourceClass, Class targetClass, boolean ifConverter) {
        String beanKey = genKey(sourceClass, targetClass);
        BeanCopier copier = null;
        if (!BEAN_COPIERS.containsKey(beanKey)) {
            if(ifConverter){
                copier = BeanCopier.create(sourceClass, targetClass, true);
            }else{
                copier = BeanCopier.create(sourceClass, targetClass, false);
            }
            BEAN_COPIERS.put(beanKey, copier);
        } else {
            copier = BEAN_COPIERS.get(beanKey);
        }
        return copier;
    }
}


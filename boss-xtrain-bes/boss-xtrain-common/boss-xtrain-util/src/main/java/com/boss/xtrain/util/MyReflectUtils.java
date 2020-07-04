package com.boss.xtrain.util;

import com.boss.xtrain.annotation.ExcelColumn;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class MyReflectUtils {
    private MyReflectUtils(){

    }
    public static Object getFieldValue(Object object,Field field)  {
        String fieldName = field.getName();
        String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+
                fieldName.substring(1);
        Object fieldValue=null;
        try {
            Method method = object.getClass().getMethod(getMethodName);
            fieldValue = method.invoke(object);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        //根据值属性不同，分别使用setxxx()函数注入值
        return fieldValue;
    }
    public static void setFieldValue(Object object,Field field,Object value)  {
        String fieldName = field.getName();
        String getMethodName = "set"+fieldName.substring(0,1).toUpperCase()+
                fieldName.substring(1);
        try {
            Method method = object.getClass().getMethod(getMethodName,String.class);
            method.invoke(object,value);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        //根据值属性不同，分别使用setxxx()函数注入值
    }
    public static Deque<Field> getAllField(Object model){
        Class<?> clazz = model.getClass();
        Deque<Field> fields = new LinkedList<>();
        Deque<Field> stack = new LinkedList<>();

        while (clazz!=null){
            Field[] fields1 = clazz.getDeclaredFields();
            for (Field field:
            fields1) {
                stack.push(field);
            }
            while (!stack.isEmpty()){
                Field field =stack.pop();
                fields.addFirst(field);
            }
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
    public static List<String> getFieldOneAnnotation(Object model){
        Class<?> clazz = model.getClass();
        Deque<String> result = new LinkedList<>();
        Deque<String> stack = new LinkedList<>();

        while (clazz!=null){
            Field[] fields1 = clazz.getDeclaredFields();
            for (Field field:
                    fields1) {
                stack.push(field.getAnnotation(ExcelColumn.class).value());
            }
            while (!stack.isEmpty()){
                String string =stack.pop();
                result.addFirst(string);
            }
            clazz = clazz.getSuperclass();
        }

        return new ArrayList<>(result);
    }
}

package com.boss.xtrain.papaer.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Converter;

@Slf4j
public class BasicConverter implements Converter {
    static final Byte RIGHT_SIGN = 1;
    static final Byte FALSE_SIGN = 2;
    /**
     * Description: value:源属性对象，target:目标属性对象，context:目标属性对象的set方法
     * @author zjh
     * @date 21:02 2020/4/1
     * @param value, target, context
     * @return java.lang.Object
     */
    @Override
    public Object convert(Object value, Class target, Object context) {
        //如果源属性对象为Long，目标属性对象为String，则将Long转成String
        if(value instanceof Long && String.class == target){
            return value.toString();
        }
        if (value instanceof String && Long.class == target){
            Long result = null;
            try {
                result= Long.valueOf(value+"");
            }catch (Exception e){
                return null;
            }
            return result;
        }
        if (value instanceof Byte && Boolean.class == target){
            return ((Byte) value).byteValue() == RIGHT_SIGN;
        }
        if (value instanceof Boolean && Byte.class == target){
            if ((boolean) value){
                return RIGHT_SIGN;
            }
            return FALSE_SIGN;
        }
        return value;
    }
}


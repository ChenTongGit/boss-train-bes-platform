package com.boss.xtrain.authentication.filter;

import com.boss.xtrain.common.core.aspect.EntityFields;

public class UserContext {
    private static ThreadLocal<EntityFields> threadLocal = new ThreadLocal<>();

    public static EntityFields current() {
        return threadLocal.get();
    }

    public static EntityFields currentEntityFields() {
        EntityFields entityFields = threadLocal.get();
        if (entityFields != null) {
            return entityFields;
        }
        return null;
    }
    public static void setUserInfo(EntityFields entityFields) {
        threadLocal.set(entityFields);
    }
}
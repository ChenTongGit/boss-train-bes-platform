package com.boss.xtrain.annotation;

import java.lang.annotation.*;

/**
 * @author lenovo
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ExcelColumn {
    String value();
}

package com.boss.xtrain.paper.annotation;

import java.lang.annotation.*;

/**try catch注解，捕获异常抛出BussinessException
 * @author lenovo
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented

public @interface TryCatch {
}

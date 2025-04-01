package com.atguigu.spring.aop.annotation;

import java.lang.annotation.*;

/**
 * @author thebigpotato
 * @create 2025-03-30-16:08
 */

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAn {
    String value() default "";

}

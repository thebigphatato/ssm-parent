package com.atguigu.practice.annotation;

import com.atguigu.practice.validator.GenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ClassName: Gender
 * Package: com.atguigu.practice.annotation
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/14 17:53
 * @Version 19
 */

// 校验注解 绑定校验器
@Documented
@Constraint(validatedBy = {GenderValidator.class}) //校验器去真正完成校验注解
@Target({ FIELD })
@Retention(RUNTIME)
public @interface Gender {

    String message() default "{jakarta.validation.constraints.NotNull.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };






}

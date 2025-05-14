package com.atguigu.practice.validator;

import com.atguigu.practice.annotation.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * ClassName: GenderValidator
 * Package: com.atguigu.practice.validator
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/14 17:58
 * @Version 19
 */
public class GenderValidator implements ConstraintValidator<Gender, String> {

    /**
     *
     * @param value 前端提交来的准备让我们进行校验的属性值
     * @param constraintValidatorContext 校验上下文
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {


        return "男".equals(value) || "女".equals(value) ;
    }
}

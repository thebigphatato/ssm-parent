package com.atguigu.spring.ioc.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * ClassName: MacCondition
 * Package: com.atguigu.spring.ioc.condition
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/18 11:23
 * @Version 19
 */
public class MacCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //判断环境变量中的OS包含windows，就是windows系统
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("OS");
        if(property != null && property.toLowerCase().contains("Mac".toLowerCase())){//将property中的值和Mac都转换成小写比较
            return true;
        }
        return false;
    }
}

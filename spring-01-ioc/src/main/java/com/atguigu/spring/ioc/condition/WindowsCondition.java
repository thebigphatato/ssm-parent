package com.atguigu.spring.ioc.condition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * ClassName: WindowsCondition
 * Package: com.atguigu.spring.ioc.condition
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/18 11:14
 * @Version 19
 */

// ctrl+ i可以快速重写接口的方法
public class WindowsCondition implements Condition{

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("OS");
        if(property != null && property.toLowerCase().contains("Windows".toLowerCase())){
            return true;
        }
        return false;
    }
}

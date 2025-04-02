package com.atguigu.spring.ioc.processor;

import com.atguigu.spring.ioc.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyTestBeanPostProcessor
 * Package: com.atguigu.spring.ioc.processor
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/28 10:28
 * @Version 19
 */

@Component //拦截所有Bean的后置处理器
public class MyTestBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【postProcessAfterInitialization】:" + beanName);
        if(bean instanceof User hello) {
            hello.setPassword("123456");
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【postProcessBeforeInitialization】:" + beanName);

        if(bean instanceof User hello) {
            hello.setUsername("张三测试");
        }

        return bean;
    }
}

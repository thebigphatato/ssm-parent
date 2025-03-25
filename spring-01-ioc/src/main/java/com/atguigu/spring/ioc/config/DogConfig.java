package com.atguigu.spring.ioc.config;

import ch.qos.logback.core.CoreConstants;
import com.atguigu.spring.ioc.bean.Dog;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

/**
 * ClassName: DogConfig
 * Package: com.atguigu.spring.ioc.config
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/13 21:00
 * @Version 19
 *
 * 第三方组件想要导入容器中，没办法快速标注分层注解
 * 左边有小绿豆就代表这个组件进入了容器
 * 1、@Bean:自己new,注册给容器
 * 2
 *
 */

//说明属性来源：把指定的文件导入容器中，供我们取值使用
@PropertySource("classpath:dog.properties")
@Configuration
public class DogConfig {


    @ConditionalOnMissingBean(name = "bill")
    @Lazy //单例模式，可以继续调整为懒加载
    @Bean
    public Dog dog() {
        return new Dog();
    }

//    @Bean
//    public CoreConstants coreConstants() {
//        return new CoreConstants();
//    }


}

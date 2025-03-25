package com.atguigu.spring.ioc.config;

import ch.qos.logback.core.CoreConstants;
import com.atguigu.spring.ioc.bean.Car;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * ClassName: AppConfig
 * Package: com.atguigu.spring.ioc.config
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/14 14:44
 * @Version 19
 */


@Import({CoreConstants.class, Car.class})
@ComponentScan(basePackages = "com.atguigu.spring")//组件批量扫描:只扫利用Spring相关注解注册到容器中的组件
@Configuration
public class AppConfig {
}

package com.atguigu.spring.ioc.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

// BeanPostProcessor : 外挂修改器

/**
 * ClassName: User
 * Package: com.atguigu.spring.ioc.bean
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/26 16:36
 * @Version 19
 */

@Data
public class User implements InitializingBean, DisposableBean {//InitializingBean里有一个抽象方法afterPropertiesSet()
    private String username;
    private String password;

    private Car car;

    @Autowired
    public void setCar(Car car) {
        System.out.println("自动注入：属性值：" + car);
        this.car = car;
    }

    public User() {
        System.out.println("User 构造器...");
    }

    @PostConstruct //构造器之后
    public void postConstruct() {
        System.out.println("postConstruct....");
    }

    @PreDestroy //销毁之前
    public void preDestroy() {
        System.out.println("preDestroy....");
    }

    public void initUser() {
        System.out.println("@Bean 初始化：initUser");
    }

    public void destroyUser() {
        System.out.println("@Bean 销毁：destoryUser");
    }

    /**
     * 属性设置之后进行调用：set赋值完成了
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[InitializingBean] === afterPropertiesSet......");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[InitializingBean] === destroy......");

    }
}

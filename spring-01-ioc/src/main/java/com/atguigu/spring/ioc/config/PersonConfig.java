package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.condition.MacCondition;
import com.atguigu.spring.ioc.condition.WindowsCondition;
import org.springframework.context.annotation.*;

import javax.swing.*;

/**
 * ClassName: PersonConfig
 * Package: com.atguigu.spring.ioc.config
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/13 20:58
 * @Version 19
 */

@Configuration //这个注解告诉Spring容器，这是一个配置类
public class PersonConfig {

    // 场景：判断当前电脑的操作系统是windows还是mac
    // windows 系统，容器中有bill
    // mac 系统,容器中有jo

    // 乔布斯
    @Conditional(MacCondition.class)
    @Bean("joseph")
    public Person joseph() {
        Person person = new Person();
        person.setName("乔布斯");
        person.setAge(20);
        person.setGender("男");
        return person;
    }

    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person bill() {
        Person person = new Person();
        person.setName("比尔盖茨");
        person.setAge(20);
        person.setGender("男");
        return person;
    }

    //3.给容器中注册一个自己的组件；容器的每个组件都有自己的名字，方法名就是组件的名字
    // 也可以在@Bean后面加括号，括号里面的内容是组件的名字
    // @Bean的意思是把这个组件放在容器中


    @Primary //主组件：默认组件
    @Scope("prototype")
    @Bean("zhangsan")
    //@Bean("zhangsan")：此注解表明该方法会返回一个 Bean 实例并注册到 Spring 容器里。括号内的 "zhangsan" 明确了这个 Bean 的名称。
    // 要是没有指定名称，Spring 会把方法名当作 Bean 的名称。
    //public Person zhangsan()：zhangsan 是方法名。通常情况下，若 @Bean 注解未指定名称，
   // Spring 会把这个方法名当作 Bean 的名称。不过在你给出的代码里，
    // 因为 @Bean 注解指定了名称 "zhangsan"，所以方法名 zhangsan 就不再充当 Bean 的名称了。
    public Person zhangsan() {
        Person person = new Person();
        person.setName("张三");
        person.setAge(20);
        person.setGender("男");
        return person;

    }



    @Bean("lisi") // Person 后面的是组件名称
    public Person lisi() {
        Person person = new Person();
        person.setName("李四");
        person.setAge(20);
        person.setGender("男");
        return person;

    }

}

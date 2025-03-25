package com.atguigu.spring.ioc.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
/**
 * ClassName: Dog
 * Package: com.atguigu.spring.ioc.bean
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/13 17:20
 * @Version 19
 */

@ToString
@Data
@Component
public class Dog {

//    @Autowired // 自动注入是针对于组件的。基本类型的话，自己搞。

    /**
     * 1.@Value("字面值")：直接赋值
     * 2.@Value("${key}"):动态从配置文件中取出某一项的值
     * resources文件的application.properties就是配置本应用程序的信息的
     * 3.@Value("#{SpEL}"):SpEL的意思是：Spring Expression Language ;Spring表达式语言
     *      SpEl更多写法：https//docs.spring.io/spring-framework/reference/core/expressions.html
     */
    @Value("旺财")
    private String name;
    @Value("${dog.age}")//resources文件的application.properties取出dog.age放在key的位置
    private Integer age;

    @Value("#{10*20}")
    private String color;

    @Value("#{T(java.util.UUID).randomUUID().toString()}")
    private String id;

    @Value("#{\"Hello World!\".substring(0,5)}")
    private String msg;

    public Dog() {
        System.out.println("Dog constructor");
    }
}

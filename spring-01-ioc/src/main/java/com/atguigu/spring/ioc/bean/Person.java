package com.atguigu.spring.ioc.bean;

import lombok.Data;

/**
 * ClassName: Person
 * Package: com.atguigu.spring.ioc.bean
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/13 16:42
 * @Version 19
 */
@Data
public class Person {
    private String name;
    private int age;
    private String gender;

    public Person() {
        System.out.println("Person()构造器执行了。。。。。。");
    }
}

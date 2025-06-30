package com.atguigu.mybatis.bean;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Emp implements Serializable {

    //开启驼峰命名自动映射封装,将Bean中的对象的驼峰名自动映射到数据库中对应的字段名
    //在配置文件中加mybatis.configuration.map-underscore-to-camel-case=true


    private Integer id;
    private String empName; // emp_name；  驼峰命名规则
    private Integer age;
    private Double empSalary; // emp_salary


}

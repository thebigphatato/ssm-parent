package com.atguigu.mybatis.bean;

import lombok.Data;

/**
 * @author thebigpotato
 * @create 2025-05-21-14:37
 */
@Data
public class Emp {

    // 开启驼峰命名在自动映射封装

    private Integer id;
    private String empName;// emp_name；驼峰命名规则
    private Integer age;
    private double empSalary;// emp_salary


}

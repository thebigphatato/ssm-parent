package com.atguigu.rest.crud.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName: Employee
 * Package: com.atguigu.rest.crud.bean
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/6 15:50
 * @Version 19
 */
@Data
public class Employee {
    private long id;
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;



}

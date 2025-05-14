package com.atguigu.practice.bean;

import com.atguigu.practice.annotation.Gender;
import jakarta.validation.constraints.*;
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

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Max(value = 150,message = "年龄不能超过150岁")
    @Min(value = 0,message = "年龄不能小于0岁")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;

    // 性别：男，女；可以使用正则完成比较复杂的校验逻辑
//    @Pattern(regexp =  "^男|女$",message = "性别只能为：男,女")
    @Gender()
    private String gender;


    private String address;
    private BigDecimal salary;



}

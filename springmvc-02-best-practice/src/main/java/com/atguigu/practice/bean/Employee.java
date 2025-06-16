package com.atguigu.practice.bean;

import com.atguigu.practice.annotation.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

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
    // message里面的内容给前端和客户端看的
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
    private Date birth;


//    //给前端返回数据要脱敏(脱去敏感信息)
//    private String password;
//    private String idcard; // 610************7298
//    private String phone;// 137****8396



    // 性别：男，女；可以使用正则完成比较复杂的校验逻辑
//    @Pattern(regexp =  "^男|女$",message = "性别只能为：男,女")

    // 国际化(Internationalization) i18n  国家化的简称：i + 18个字母+n
    // 类似的简称还有 ：  Kubernetes: k8s
    // 中文网站：性别只能为：男，女
    // 英文网站：Gender must be one of:  Male,Female






}

package com.atguigu.practice.vo.req;

import com.atguigu.practice.annotation.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author thebigpotato
 * @create 2025-05-17-16:02
 */
@Data
public class  EmployeeAddVo {


    // message里面的内容给前端和客户端看的
    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Max(value = 150,message = "年龄不能超过150岁")
    @Min(value = 0,message = "年龄不能小于0岁")
    private Integer age;



    @Email(message = "邮箱格式不正确")
    private String email;


    @Gender(message = "{gender.message}") // message = "{}" 占位符
    private String gender;

    private String address;

    private BigDecimal salary;

    //只要是日期：标注统一注解： @JsonFormat(pattern = "yyyy-MM-dd" HH:mm:ss, timezone = "GMT+8")
    //默认的日期格式： 2024-09-05T08:47:85.000+00:00
    //反序列化：前端提交日期字符串 ===> 日期对象
    //序列化：日期对象 ===> 日期字符串
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone =  "GMT+8")
    private Date birth;




}

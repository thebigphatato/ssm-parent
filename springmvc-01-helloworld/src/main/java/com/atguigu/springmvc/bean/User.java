package com.atguigu.springmvc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: User
 * Package: com.atguigu.springmvc.bean
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/6 11:47
 * @Version 19
 */



@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;

    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.getName());
    }

}

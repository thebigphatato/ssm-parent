package com.atguigu.spring.tx.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author thebigpotato
 * @create 2025-04-03-22:47
 */


@Data
public class Account {
    private Integer id;
    private String username;
    private Integer age;
    private BigDecimal balance;// BigDecimal比double、float好的原因是没有精度问题。


}

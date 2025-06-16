package com.atguigu.practice.vo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author thebigpotato
 * @create 2025-05-17-16:34
 */
@Data
public class EmployRespVo {

    private long id;
    private String name;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birth;

}

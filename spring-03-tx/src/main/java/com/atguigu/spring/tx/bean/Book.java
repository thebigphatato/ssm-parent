package com.atguigu.spring.tx.bean;

/**
 * @author thebigpotato
 * @create 2025-04-03-22:52
 */
import lombok.Data;

import java.math.BigDecimal;
@Data
public class Book {
    private Integer id;
    private String bookName;
    private BigDecimal price;
    private Integer stock;
}

package com.atguigu.spring.tx;

import com.atguigu.spring.tx.bean.Book;
import com.atguigu.spring.tx.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author thebigpotato
 * @create 2025-04-11-15:51
 */
@SpringBootTest
public class BookDaoTest {

    @Autowired
    BookDao bookDao;

    @Test
    void testQuery() {
        BigDecimal bookPrice = bookDao.getBookPrice(1);
        System.out.println("bookPrice =  " + bookPrice);
        BigDecimal bookPrice1 = bookDao.getBookPrice(1);
        System.out.println("bookPrice1 =  " + bookPrice1);
        BigDecimal bookPrice2 = bookDao.getBookPrice(1);
        System.out.println("bookPrice2 =  " + bookPrice2);

    }
}

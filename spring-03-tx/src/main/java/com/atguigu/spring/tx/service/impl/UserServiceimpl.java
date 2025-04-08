package com.atguigu.spring.tx.service.impl;

import com.atguigu.spring.tx.bean.Book;
import com.atguigu.spring.tx.dao.AccountDao;
import com.atguigu.spring.tx.dao.BookDao;
import com.atguigu.spring.tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * ClassName: UserServiceimpl
 * Package: com.atguigu.spring.tx.service.impl
 * Description:
 *
 * @Author the big potato
 * @Create 2025/4/8 16:36
 * @Version 19
 */

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AccountDao accountDao;

    @Transactional //给下面这个方法加事务的特性
    @Override
    public void checkout(String username, Integer bookId, Integer buyNum) {
        //1、查询图书信息
        Book book = bookDao.getBookById(bookId);

        //2、扣减余额
        BigDecimal delta = book.getPrice().multiply(new BigDecimal(buyNum));
        accountDao.updateBalanceByUsername(username,delta);

        //3、扣减库存
        bookDao.updateBookStock(bookId,buyNum);


    }






}

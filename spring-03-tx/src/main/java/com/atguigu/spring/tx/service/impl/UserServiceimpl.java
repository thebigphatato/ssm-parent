package com.atguigu.spring.tx.service.impl;

import com.atguigu.spring.tx.bean.Book;
import com.atguigu.spring.tx.dao.AccountDao;
import com.atguigu.spring.tx.dao.BookDao;
import com.atguigu.spring.tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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




@Transactional(timeout = 3)
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AccountDao accountDao;



    /**
     * 事务细节：
     * 1、transactionManager：事务管理器；控制事务的获取、提交、回滚
     *      底层默认使用哪个事务管理器？默认使用 JdbcTransactionManager;
     *      原理：
     *      1、事务管理器：TransactionManager;控制提交和回滚
     *      2、事务拦截器：TransactionInterceptor：控制何时提交和回滚
     *              completeTransactionAfterThrowing(txInfo, ex);   在这个时候回滚
     *              commitTransactionAfterReturning(txInfo);    在这个时候提交
     *
     * 2、propagation：传播行为
     * 3、isolation：隔离级别
     * 4、timeout(同timeoutSpring)：超时时间：事务超时以秒为单位
     *      一旦超过约定时间，事务就会回滚
     *      超时时间是指：从方法开始，到最后一次数据库操作结束的时间
     *
     * 5、readOnly：默认为false，只读优化
     * 6、rollbackFor(同rollbackForClassName)：指明哪些异常需要回滚，不是所有异常都一定引起事务回滚
     *      异常：运行时异常（unchecked exception【非受检异常】）、
     *          编译时异常 (checked exception【受检异常】)
     *      回滚的默认机制：
     *          运行时异常：回滚
     *          编译时异常：不回滚
     *      【可以指定哪些异常需要回滚】
     *      【回滚 = 运行时异常 + 指定回滚异常】
     * 7、noRollbackFor(同noRollbackForClassName)：指明哪些异常不需要回滚。
     *      【不回滚 = 编译时异常 +指定不回滚异常】
     *
     *
     * 用户结账
     * @param username 用户名
     * @param bookId   图书id
     * @param buyNum   购买数量
     */
    @Transactional(timeout = 3,readOnly = false,
            rollbackFor = {IOException.class,FileNotFoundException.class},
            rollbackForClassName = "java.lang.Exception",
            noRollbackFor = {ArithmeticException.class}) // 这个任务限时3秒完成，超过3秒，事务回滚,其次是写timeoutSpring一样的
    //给下面这个方法加事务的特性
    @Override
    public void checkout(String username, Integer bookId, Integer buyNum) throws InterruptedException, IOException {
        //1、查询图书信息
        Book book = bookDao.getBookById(bookId);

        //2、扣减余额
        BigDecimal delta = book.getPrice().multiply(new BigDecimal(buyNum));
        accountDao.updateBalanceByUsername(username,delta);

//        //模拟超时 两个位置的效果不同
//        Thread.sleep(3000);

        //3、扣减库存
        bookDao.updateBookStock(bookId,buyNum);

//        //模拟超时
//        Thread.sleep(3000);

        // 模拟异常
//        FileInputStream stream = new FileInputStream("D:\\123.txt");
//        System.out.println("stream.available() = " + stream.available());
//        int i = 10/0;


    }






}

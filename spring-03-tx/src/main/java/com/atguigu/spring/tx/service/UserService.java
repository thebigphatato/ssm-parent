package com.atguigu.spring.tx.service;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ClassName: UserService
 * Package: com.atguigu.spring.tx.service
 * Description:
 *
 * @Author the big potato
 * @Create 2025/4/8 16:35
 * @Version 19
 */
public interface UserService {
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
     * 6、rollbackFor：指明哪些异常需要回滚，不是所有异常都一定引起事务回滚
     *      异常：运行时异常（unchecked exception【非受检异常】）、
     *          编译时异常 (checked exception【受检异常】)
     *      回滚的默认机制：
     *          运行时异常：回滚
     *          编译时异常：不回滚
     *      可以指定哪些异常需要回滚；
     *
     *
     * 用户结账
     * @param username 用户名
     * @param bookId   图书id
     * @param buyNum   购买数量
     */
    void checkout(String username,Integer bookId,Integer buyNum) throws InterruptedException, IOException;
}

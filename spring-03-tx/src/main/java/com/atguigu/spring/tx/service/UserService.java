package com.atguigu.spring.tx.service;

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
     * 2、
     *
     * 用户结账
     * @param username 用户名
     * @param bookId   图书id
     * @param buyNum   购买数量
     */
    void checkout(String username,Integer bookId,Integer buyNum);
}

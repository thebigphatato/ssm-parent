package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Customer;
import com.atguigu.mybatis.bean.Order;
import com.atguigu.mybatis.mapper.CustomerMapper;
import com.atguigu.mybatis.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: JoinQueryTest
 * Package: com.atguigu.mybatis
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/17 15:59
 * @Version 19
 */
@SpringBootTest
public class JoinQueryTest {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    CustomerMapper customerMapper;

    @Test
    void test01() {
        Order order = orderMapper.getOrderByIdWithCustomer(1l);
        System.out.println("order = " + order);
    }

    @Test
    void test02() {
        Customer customer = customerMapper.getCustomerByIdWithOrders(1l);
        System.out.println("customer = " + customer.toString());
    }




}

package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Customer;
import com.atguigu.mybatis.bean.Order;
import com.atguigu.mybatis.mapper.OrderCustomerStepMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.DefaultEditorKit;
import java.util.List;

/**
 * ClassName: StepTest
 * Package: com.atguigu.mybatis
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/17 17:26
 * @Version 19
 */

@SpringBootTest
public class StepTest {

    @Autowired
    OrderCustomerStepMapper orderCustomerStepMapper;

    @Test
    void testStep03() {
        Order order = orderCustomerStepMapper.getOrderByIdAndCustomerStep(1L);
        System.out.println("order = " + order);
    }



    //MyBatis 自动分布查询机制：自动调用
    @Test
    void testStep02() {
        Customer customer = orderCustomerStepMapper.getCustomerByIdAndOrdersStep(1L);
        System.out.println(customer);
    }



    // 原生分布，需要我们手动调用两次方法
    @Test
    void testStep01() {
        //1、按照id查询客户
        Customer customer = orderCustomerStepMapper.getCustomerById(1L);

        //2、他下的所有订单
        List<Order> orders = orderCustomerStepMapper.getOrdersByCustomerId(1L);

        //3、组合封装
        customer.setOrders(orders);
        System.out.println("customer = " + customer);
    }

}

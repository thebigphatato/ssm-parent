package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Customer;
import com.atguigu.mybatis.bean.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: OrderCustomerStepMapper
 * Package: com.atguigu.mybatis.mapper
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/17 17:16
 * @Version 19
 */

@Mapper
public interface OrderCustomerStepMapper {
    // 需求：按照id查询客户 以及 他&她下的所有订单
    // 1、查询客户
    Customer getCustomerById(Long id);

    // 2、查询订单
    List<Order> getOrdersByCustomerId(Long cId);

    // 3、封装客户和订单



    // 分步查询
    //1、分步查询，查询客户 + 查询客户下的订单
    /**
     *
     * @param id 客户id
     * @return
     */
    Customer getCustomerByIdAndOrdersStep(Long id);

    /**
     *
     * @param id 订单id
     * @return
     */
    //2、分步查询：自动做两步 = 按照id查询订单 + 查询下单的客户
    Order getOrderByIdAndCustomerStep(Long id);




}

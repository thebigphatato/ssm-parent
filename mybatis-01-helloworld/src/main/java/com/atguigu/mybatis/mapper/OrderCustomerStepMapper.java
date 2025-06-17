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

    //1、分布查询，查询客户 + 查询客户下的订单
    Customer getCustomerByIdAndOrdersStep(Long id);






}

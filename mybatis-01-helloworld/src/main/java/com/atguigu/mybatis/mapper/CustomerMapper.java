package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: CustomerMapper
 * Package: com.atguigu.mybatis.mapper
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/17 15:16
 * @Version 19
 */

/**
 * <!--
 * collection：说明 一对N 的封装规则    collection中写那个“多”所对应的表
 * ofType: 集合中元素的类型
 *
 * 而一对一的封装是 association javaType
 * 多对多的封装也是用collection ,ofType
 * 多对多其实就是一对多的变形
 *
 *
 * 唯一字段用id封装，哪怕不是主键，普通字段用result封装
 *
 *
 * -->
 */
@Mapper
public interface CustomerMapper {

    Customer getCustomerByIdWithOrders(Long id);

    // 查询所有客户所有订单
    List<Customer> getAllCustomersWithOrders();


}

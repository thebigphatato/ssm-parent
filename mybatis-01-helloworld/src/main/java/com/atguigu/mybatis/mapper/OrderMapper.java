package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Order;
import org.apache.ibatis.annotations.Mapper;
/**
 * <!--
 * collection：说明 一对N 的封装规则    collection中写那个“多”所对应的表
 * ofType: 集合中元素的类型
 *
 * 而一对一的封装是 association javaType
 * 多对多的封装也是用collection ,ofType
 *
 * 唯一字段用id封装，哪怕不是主键，普通字段用result封装
 *
 *
 * -->
 */

@Mapper
public interface OrderMapper {

    //按照id查询订单以及下单的客户信息
    Order getOrderByIdWithCustomer(Long id);

}

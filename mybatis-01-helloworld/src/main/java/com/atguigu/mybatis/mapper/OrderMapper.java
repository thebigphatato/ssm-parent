package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: OrderMapper
 * Package: com.atguigu.mybatis.mapper
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/17 15:17
 * @Version 19
 */

@Mapper
public interface OrderMapper {

    //按照id查询订单以及下单的客户信息
    Order getOrderByIdWithCustomer(Long id);

}

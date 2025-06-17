package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: CustomerMapper
 * Package: com.atguigu.mybatis.mapper
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/17 15:16
 * @Version 19
 */
@Mapper
public interface CustomerMapper {

    Customer getCustomerByIdWithOrders(Long id);
}

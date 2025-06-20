package com.atguigu.mybatis.controller;

import com.atguigu.mybatis.mapper.OrderCustomerStepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.atguigu.mybatis.bean.Order;
/**
 * ClassName: OrderRestController
 * Package: com.atguigu.mybatis.controller
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/18 10:01
 * @Version 19
 */

@ResponseBody
@Controller
public class OrderRestController {

    @Autowired
    OrderCustomerStepMapper orderCustomerStepMapper;

    @GetMapping(value = "/order/{id}" )
    public Order getOrder(@PathVariable("id") Long id) {
        Order order = orderCustomerStepMapper.getOrderByIdAndCustomerAndOtherOrdersStep(id);
        return order;
    }
}

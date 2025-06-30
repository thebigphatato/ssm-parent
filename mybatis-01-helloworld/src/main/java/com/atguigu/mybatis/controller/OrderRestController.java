package com.atguigu.mybatis.controller;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.mapper.OrderCustomerStepMapper;
import com.atguigu.mybatis.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.atguigu.mybatis.bean.Order;

import java.util.List;

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

    @Autowired
    EmpService empService;


    @GetMapping("/emp/page")
    public PageInfo getPage(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Emp> all = empService.getAll();
        return new PageInfo(all);

    }

    @GetMapping(value = "/order/{id}" )
    public Order getOrder(@PathVariable("id") Long id) {
        Order order = orderCustomerStepMapper.getOrderByIdAndCustomerAndOtherOrdersStep(id);
        return order;
    }
}

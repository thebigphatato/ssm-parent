package com.atguigu.spring.ioc.dao;

import com.atguigu.spring.ioc.datasource.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * ClassName: DeliveryDao
 * Package: com.atguigu.spring.ioc.dao
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/26 14:58
 * @Version 19
 */

@Component
public class DeliveryDao {
    /**
     * 问题1:数据源组件有三个。
     *      1.@Primary:dev
     * 效果：能不能自动？
     *      1.告诉Spring.哪个数据源哪种情况下才生效。这个时候你是不是想到了条件注解。
     *
     */

    @Autowired
    MyDataSource myDataSource;

    public void saveDelivery() {
        System.out.println("数据源：保存数据"+myDataSource);
    }
}

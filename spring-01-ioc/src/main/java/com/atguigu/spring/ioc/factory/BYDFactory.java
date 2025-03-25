package com.atguigu.spring.ioc.factory;

import com.atguigu.spring.ioc.bean.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * ClassName: BYD
 * Package: com.atguigu.spring.ioc.factory
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/18 10:07
 * @Version 19
 */


// 场景：如果制造某些对象比较复杂的时候，利用工厂方法进行创建


public class BYDFactory implements FactoryBean<Car> {
//泛型里面的类型说明我这个工厂生产的物品的类型

    /**
     * 调用此方法给容器中制造对象
     */

    @Override
    public Car getObject() throws Exception {
        System.out.println("BYDFactory 正在制造Car对象......");
        Car car = new Car();
        return car;
    }

    /**
     * 下面的方法说明造的东西的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     * 是单例？
     *      true:默认是单例的
     *      false:不是单例的
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}

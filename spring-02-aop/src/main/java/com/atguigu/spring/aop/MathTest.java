package com.atguigu.spring.aop;

import com.atguigu.spring.aop.calculator.MathCalculator;
import com.atguigu.spring.aop.calculator.impl.MathCalculatorImpl;
import com.atguigu.spring.aop.proxy.statics.CalculatorStaticProxy;
import org.junit.Test;


/**
 * ClassName: MathTest
 * Package: com.atguigu.spring.aop
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/28 17:25
 * @Version 19
 */
public class MathTest {
    @Test
    public void test01() {

        //真正有用的人，目标对象
        MathCalculator target = new MathCalculatorImpl();
        target.add(1,2);
        System.out.println("=====================================");

        // 1、创建静态代理对象
        MathCalculator proxy = new CalculatorStaticProxy(target);
        int add = proxy.add(1,2);
        System.out.println(add);

    }
}

package com.atguigu.spring.aop.calculator.impl;

import com.atguigu.spring.aop.calculator.MathCalculator;
import org.springframework.stereotype.Component;

/**
 * ClassName: MathCalculatorImpl
 * Package: com.atguigu.spring.aop.calculator.impl
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/28 17:02
 * @Version 19
 */

/**
 * 日志：
 * 1、硬编码：不推荐 耦合：（通用逻辑 + 专用逻辑） 希望不要耦合；耦合太多就是维护地狱
 * 2.静态代理：
 *      定义：定义一个代理对象，包装这个组件。包装这个组件。以后业务的执行，从代理开始，不直接调用组件；
 *      特点：定义期间就制定好了互相代理关系
 */
@Component
public class MathCalculatorImpl implements MathCalculator {

    @Override
    public int add(int a, int b) {
//        System.out.println("【日志】add 开始：参数：" + a + "," + b);
        int result = a + b;
//        System.out.println("【日志】add 返回：结果：" + result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }

    @Override
    public int mul(int a, int b) {
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        try {
            if(b != 0) {
                return a/b;
            }
        }
        catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

package com.atguigu.spring.aop.calculator.impl;

import com.atguigu.spring.aop.calculator.MathCalculator;
import org.springframework.stereotype.Component;

/**
 * @author thebigpotato
 * @create 2025-03-29-20:57
 */


/**
 * 日志：
 * 1、硬编码：不推荐； 耦合； (通用逻辑 + 专用逻辑) 耦合太多就是维护低于
 * 2、静态代理：
 *      定义：定义一个代理对象，包装这个组件。以后业务的执行，从代理开始，不直接调用组件
 *      特点：从定义期间就指定好了互相关系
 */



@Component
public class MathCalculatorImpl implements MathCalculator {
    @Override
    public int add(int a, int b) {
        //System.out.println("【日志】add开始：参数："+a+","+b);
        int result = a + b;
        System.out.println("结果："+result);
        //System.out.println("【日志】add返回：结果："+result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a - b;
        return result;
    }

    @Override
    public int mul(int a, int b) {
        int result = a * b;
        return result;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("目标方法执行.......");
        int result = a / b;
        return result;
    }
}

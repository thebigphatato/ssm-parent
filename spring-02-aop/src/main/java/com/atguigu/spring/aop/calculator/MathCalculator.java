package com.atguigu.spring.aop.calculator;

/**
 * @author thebigpotato
 * @create 2025-03-2920:55
 */
public interface MathCalculator {

    //定义四则运算
    int add(int a, int b);
    int sub(int a, int b);
    int mul(int a, int b);
    int div(int a, int b);

}

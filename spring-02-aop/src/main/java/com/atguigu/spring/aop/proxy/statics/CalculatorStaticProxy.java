package com.atguigu.spring.aop.proxy.statics;

import com.atguigu.spring.aop.calculator.MathCalculator;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author thebigpotato
 * @create 2025-03-29$-{TIME}
 */

/**
 * 静态代理：
 *      定义：代理对象，是目标对象的接口的子类型，代理对象本身并不是目标对象，而是将目标对象作为自己的属性。定义期间就决定好了代理的关系。
 *      优点: 同一种类型的所有对象都能代理
 *      缺点： 范围太小，只能负责部分接口代理功能。
 *
 * 动态代理：    运行期间才决定好了代理关系(拦截器：拦截所有)
 *      定义：目标对象在执行期间会被动态拦截：插入指定逻辑
 *      优点：可以代理世间万物
 *      缺点：不好写 去查看DynamicProxy文件和test包下的MathTest类中的test02,test03方法
 */




//@Component
@Data
public class CalculatorStaticProxy implements MathCalculator{

    private MathCalculator target;// 目标对象

    public CalculatorStaticProxy(MathCalculator mc) {
        this.target = mc;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("【日志】add开始：参数："+a+","+b);
        int result = target.add(a, b);
        System.out.println("【日志】add返回：结果："+result);
        return 0;
    }

    @Override
    public int sub(int a, int b) {
        int result = target.sub(a, b);
        return 0;
    }

    @Override
    public int mul(int a, int b) {
        int result = target.mul(a, b);
        return 0;
    }

    @Override
    public int div(int a, int b) {
        int result = target.div(a, b);
        return 0;
    }
}

package com.atguigu.spring.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ClassName: AuthAspect
 * Package: com.atguigu.spring.aop.aspect
 * Description:
 *
 * @Author the big potato
 * @Create 2025/4/1 16:44
 * @Version 19
 *
 *
 * 为什么AuthAspect这个切面是套在LogAspect切面的外面的，这是因为
 * 多切面执行顺序的顺序是按照切面的首字母的排序顺序来定的。AuthAspect的首字母是A在L之前。
 * 还可以用一个专门的注解annotation来定义优先级：@Order(里面填数字)
 * 数字越小，优先级越高;数字越大，优先级越低
 */


@Order(100)
@Component
@Aspect //告诉Spring这个组件是个切面
public class AuthAspect {

    @Pointcut("execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before() {
        System.out.println("【切面 - 权限】前置");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("【切面 - 权限】后置");

    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("【切面 - 权限】返回");

    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("【切面 - 权限】异常");

    }


}

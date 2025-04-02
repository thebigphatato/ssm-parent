package com.atguigu.spring.aop.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author thebigpotato
 * @create 2025-03-30-14:44
 */




@Order(10000) //数字越小，优先级越高，数字越大，优先级越低；数字越小，越先执行。
@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))")
    public void pointCut() {

    }

    /**
     * 告诉Spring,以下通知何时何地运行？
     * 何时？
     *      @Before:方法执行之前运行。
     *      @AfterReturning：方法执行正常返回结果运行
     *      @AfterThrowing:方法抛出异常运行
     *      @After:方法执行之后运行
     *      @Around：环绕通知：可以控制目标方法是否执行，修改目标方法参数、执行结果等
     *
     * 何地？
     *      切入表达式：
     *          execution(方法的全签名);  // 下面一行就是方法的全签名，有的方法还要抛出异常，所以你也要带上
     *              // 加?表示可以不写
     *              // 加[]表示可以不写
     *              全写法：public? int [com.atguigu.spring.aop.calculator.MathCalculator].add(int i,int j) [throws ArithmeticException]
     *              省略写法：int add(int i,int j)
     *              通配符：
     *                  *：表示任意字符
     *                  ..：
     *                      1、参数位置：表示多个参数，任意类型
     *                      2、类型位置(类型就是你所属于的包的完整路径)：代表多个层级
     *              最省略：* *(..)
     *
     * 通知方法的执行顺序：
     * 1、正常链路：前置通知->目标方法->返回通知->后置通知
     * 2、异常链路：前置通知->目标方法->异常通知->后置通知
     *
     * JoinPoint：包装了当前方法的所有信息
     *
     * @AfterReturning和@AfterThrowing只会执行一个，方法执行正常的时候会返回返回值，有异常的时候返回异常信息
     *
     */

    @Before("pointCut()") //切入表达式一写，你会在左边看见你一个红色小圈圈表示方法，一点就到了真正执行的方法
    public void logStart(JoinPoint joinPoint) {
        // 拿下方法全签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取方法名
        String name = signature.getName();
        //目标方法传来的参数值
        Object[] args = joinPoint.getArgs();


        System.out.println("【切面 - 日志】【" + name + "】开始：【" + Arrays.toString(args) + "】");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【切面 - 日志】【" + name + "】结束...");
    }

    @AfterReturning(value = "pointCut()",
                    returning = "result") // returning="result" 获取方法返回值
    public void logReturn(JoinPoint joinPoint,Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        System.out.println(signature);
        String name = signature.getName();
        System.out.println("【切面 - 日志】【" + name + "】返回：值：" + result);
    }

    @AfterThrowing(
            value = "pointCut()",
            throwing = "e" //throwing="e" 获取目标方法抛出的异常
    )
    public void logException(JoinPoint joinPoint,Throwable e) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【切面 - 日志】【" + name + "】异常：错误信息：【" + e.getMessage() + "】");
    }

    //参数带什么就切，只要参数符合特征，就切
//    @Before("args(int,int)")
    public void haha() {
        System.out.println("【切面 - 日志】哈哈哈...");
    }

    //参数带这个注解的就切,判定参数上有没有标注注解
    @Before("@args(com.atguigu.spring.aop.annotation.MyAn) && within(com.atguigu.spring.aop.service.UserService+)")
    public void hehe() {
        System.out.println("【切面 - 日志】呵呵呵...");
    }

    // 方法上带注解
    @Before("@annotation(com.atguigu.spring.aop.annotation.MyAn)")
    public void test() {
        System.out.println("【切面 - 日志】MyAn测试...");

    }

}

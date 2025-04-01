package com.atguigu.spring.aop.aspect;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author thebigpotato
 * @create 2025-03-30-14:44
 */





@Component
@Aspect
public class LogAspect {

    /**
     * 告诉Spring,以下通知何时何地运行？
     * 何时？
     *      @Before:方法执行之前运行。
     *      @AfterReturning：方法执行正常返回结果运行
     *      @AfterThrowing:方法抛出异常运行
     *      @After:方法执行之后运行
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
     *
     */

    @Before("execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))") //切入表达式一写，你会在左边看见你一个红色小圈圈表示方法，一点就到了真正执行的方法
    public void logStart() {
        System.out.println("【切面 - 日志】开始...");
    }

    @After("execution(int *(int,int))")
    public void logEnd() {
        System.out.println("【切面 - 日志】结束...");
    }

    @AfterReturning("execution(int *(int,int))")
    public void logReturn() {
        System.out.println("【切面 - 日志】返回...");
    }

    @AfterThrowing("execution(int *(int,int))")
    public void logException() {
        System.out.println("【切面 - 日志】异常...");
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

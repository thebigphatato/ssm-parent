package com.atguigu.spring.aop;

import com.atguigu.spring.aop.annotation.MyAn;
import com.atguigu.spring.aop.calculator.MathCalculator;
import com.atguigu.spring.aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

/**
 * @author thebigpotato
 * @create 2025-03-30-14:26
 */


/**
 * 面向切面编程：AOP
 *      步骤：
 *          1、导入AOP依赖
 *          2、编写切面Aspect
 *          3、编写通知方法
 *          4、指定切入点表达式
 *          5、测试AOP动态织入
 */

@MyAn
@SpringBootTest

public class AopTest {


    @Autowired // 容器中是它的代理对象
    MathCalculator mathCalculator;

    @Autowired
    UserService userService;

    @Test
    void test02() {
        mathCalculator.div(10,0);
    }




    @Test
    void tesst01() {
//        System.out.println(mathCalculator.getClass());//实现类
////        System.out.println(mathCalculator);
//        mathCalculator.add(10,20);
        // 增强器链：切面中的所有通知方法其实就是增强器。他们被组织成一个链路放到集合中，目标方法真正执行前后，
        // 会去增强器链中频繁执行那些需要提权执行的方法。
        // AOP的底层原理
        // 1、Spring会为每个被切面切入的组件创建代理对象
        // 2、代理对象中保存了切面类(在这里是LogAspect.java)中里面所有通知方法构成的增强器链
        // 3、目标方法执行时，会先去执行增强器链中拿到需要提前执行的通知方法去执行


        userService.getUserHaha(1,2);

        System.out.println("=======================================");

        userService.updateUser();
    }


}

package com.atguigu.practice.controller;

/**
 * ClassName: HelloController
 * Package: com.atguigu.practice.controller
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/9 9:46
 * @Version 19
 */

import com.atguigu.practice.common.R;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 测试声明式异常处理
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public R hello(@RequestParam(value = "i",defaultValue = "0") Integer i) throws FileNotFoundException {
        int  j = 10 / i;
//        FileInputStream fis = new FileInputStream("D:\\1243213123.txt");
        String s = null;
        s.length();
        return R.ok(j);
    }

    /**
     * 1、如果Controller本类出现异常，会自动在本类中找有没有@ExceptionHandle标注的方法，
     *      如果有，会执行这个方法，它的返回值，就是客户端收到的结果
     *
     *   如果发生异常，多个都能处理，就精确优先。
     * @return
     */
    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public R handleArithmeticException(ArithmeticException ex) {
        System.out.println("【本类】 - ArithmeticException 异常处理");
        return R.error(100,"执行异常" + ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public R handleArithmeticException(Throwable ex) {
        System.out.println("【本类】 - Throwable 异常处理");
        return R.error(500,"" + ex.getMessage());
    }
}

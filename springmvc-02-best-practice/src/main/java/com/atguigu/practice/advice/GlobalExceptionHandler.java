package com.atguigu.practice.advice;

import com.atguigu.practice.common.R;
import com.atguigu.practice.exception.BizException;
import org.springframework.data.relational.core.sql.In;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.atguigu.practice.advice
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/9 10:48
 * @Version 19
 */

// 全局异常处理器
//@ResponseBody
@RestControllerAdvice // 告诉SpringMVC,这个组件是专门负责进行全局处理的
public class GlobalExceptionHandler {

    /**
     * 如果出现了异常：本类和全局都不能处理
     *      SpringBoot底层对SpringMVC有兜底处理机制；自适应处理(浏览器响应页面、移动端会响应json)
     *   最佳实践：我们编写全局异常处理器，处理所有异常
     *
     * 前端关心异常状态，后端正确业务流程。
     * 推荐：后端只编写正确的业务逻辑，如果出现业务问题，后端通过抛异常的方式提前中断业务逻辑。前端感知异常；
     *
     *
     * 异常处理：
     *      1、
     *      2、
     *
     *
     * @param e
     * @return
     */

//    @ExceptionHandler(Exception.class)
//    public R error(Exception e) {
//        System.out.println("【全局】 - Exception处理");
//        return R.error(500,e.getMessage());
//    }


    @ExceptionHandler(ArithmeticException.class)
    public R error(ArithmeticException e) {
        System.out.println("【全局】 - ArithmeticException处理");
        return R.error(500,e.getMessage());
    }

    @ExceptionHandler(BizException.class)
    public R handleBizException(BizException e) {
        Integer code = e.getCode();
        String msg = e.getMsg();
        return R.error(code,msg);

    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> errors = result.getFieldErrors();
        Map<String,String> errorMap = new HashMap<>();
        for(FieldError fieldError : errors) {
            // 1、获取属性名
            String field = fieldError.getField();
            // 2、获取到错误信息
            String message = fieldError.getDefaultMessage();
            errorMap.put(field, message);
        }
        return R.error(500,"参数错误",errorMap);
    }

    // 最终的兜底
    @ExceptionHandler(Throwable.class)
    public R error(Throwable e) {
        System.out.println("【全局】 - Throwable处理" + e.getClass());

        return R.error(500,e.getMessage());
    }

}

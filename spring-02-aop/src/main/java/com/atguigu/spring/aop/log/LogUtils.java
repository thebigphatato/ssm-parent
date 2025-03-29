package com.atguigu.spring.aop.log;

import java.util.Arrays;

/**
 * @author thebigpotato
 * @create 2025-03-29-23:11
 */
public class LogUtils {

    public static void logStart(String name,Object... args) {
        System.out.println("【日志】：【"+name+"】开始;参数："+ Arrays.toString(args));

    }

    public static void logEnd(String name,Object... args) {
        System.out.println("【日志】：【"+name+"】结束。");

    }

    public static void logException(String name,Throwable e) {
        System.out.println("【日志】：【"+name+"】发生错误;异常信息："+ e.getCause());
    }

    public static void logReturn(String name,Object result) {
        System.out.println("【日志】：【"+name+"】返回;返回结果："+ result);

    }

}

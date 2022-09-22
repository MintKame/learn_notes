package com.yz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class _1_test_interceptor_ex {

    /*
    ! 配置拦截器
          1. 定义java类 interceptor（源码分析见：FirstInterceptor
          2. springMVC.xml
     测试：
        http://localhost:8080/interceptor_exception/
        查看cmd（应有3个interceptor）

        点击test interceptor
        查看cmd（应有2个interceptor）
     */

    @RequestMapping("/testInterceptor")
    String testInterceptor(){
        return "success";
    }


    /*
    ! 异常处理器
        出现ex时，提供新的model和view，跳转到指定页面显示异常信息
        SpringMVC提供1个接口：HandlerExceptionResolver
        实现类：DefaultHandlerExceptionResolver（默认使用）
               SimpleMappingExceptionResolver（需自定义）
    两种方式：
        注解（ExceptionController.java
        配置文件（springMVC.xml
    测试：
        http://localhost:8080/interceptor_exception/
        点击 test exception
     */
    @RequestMapping("/testArithmeticException")
    String testArithmeticException(){
        int a = 1/0; // ArithmeticException (方式1：注解
        return "success";
    }

    @RequestMapping("/testNullPointerException")
    String testNullPointerException(){
        final List list = null;
        int b = list.size(); // NullPointerException（方式2：配置文件
        return "success";
    }
}

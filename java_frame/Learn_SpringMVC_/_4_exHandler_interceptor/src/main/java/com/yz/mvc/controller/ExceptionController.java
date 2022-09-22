package com.yz.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

// 类 标识为 异常处理组件（Component）
@ControllerAdvice
public class ExceptionController {
    // 设置被处理的异常
    @ExceptionHandler(ArithmeticException.class)
    // 参数 exception：出现的异常对象
    public String handleArithmeticException(Exception exception, Model model){
        model.addAttribute("ex", exception); // 新的model：给请求域共享信息
        return "exception"; // 新的view
    }
}


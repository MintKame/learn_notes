package com.yz.sb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController: 本类all方法，返回值都为responseBody，而不是跳转到的视图名
@RestController
public class HelloController {
    /* 测试：
        http://localhost:8888/hello
     */
    @RequestMapping("/hello")
    String hello(){
        return "hello, SpringBoot 2";
    }
}

package com.yz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*  前端控制器（1个servlet） 处理 all请求 ，但不同请求有不同的处理

因此：需创建处理具体请求的类（请求控制器，controller，handler）
     controller的方法：对应不同请求
*/
@Controller // 交给Spring的IoC容器管理
public class HelloController {

    // RequestMapping：哪个请求路径 映射到 该方法
    @RequestMapping("/") // 注解中，只为 属性value 赋值，则可省略
    public String index(){  // 方法名随意
        return "index";
    }

    @RequestMapping("/world")
    public String HelloWorld() {
        return "target";
    }
}

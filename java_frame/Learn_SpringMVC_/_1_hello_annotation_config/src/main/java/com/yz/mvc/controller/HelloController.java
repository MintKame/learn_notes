package com.yz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){  // 方法名随意
        return "index";
    }

    @RequestMapping("/testEx")
    public String testEx(){
        int a = 1/0;
        return "index";
    }

}

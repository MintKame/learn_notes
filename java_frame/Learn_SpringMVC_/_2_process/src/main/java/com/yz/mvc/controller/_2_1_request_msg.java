package com.yz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/*
获取：请求的信息（请求参数，请求头，cookie值）
! 注解可用的参数类型，见 javadoc 文档
问：如何实现 传递参数？
答：DispatcherServlet 调用controller的方法。根据方法的形参，从request获取信息，来传值

测试方式
    http://localhost:8080/process/request/
    点击链接，发送请求
    cmd是否输出正确信息 (来自浏览器)
*/
@Controller
@RequestMapping("request")
public class _2_1_request_msg {
    @RequestMapping("/")
    String index(){
        return "_2_request";
    }

    /* servlet API
        HttpServletRequest 封装 请求的请求报文的对象
        尽量不用，因SpringMVC封装了从request获取信息的过程，可直接使用这些信息
    */
    @RequestMapping("servlet")
    String servlet(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("====================================");
        System.out.println("name: " + name);
        System.out.println("password: " + password);
        // request.getParameterValues
        // 获取多个同名参数，返回String[] （比如 复选框，都是同名参数
        return "success";
    }

    /* 将请求参数 赋给形参（需同名）
        若多个同名的请求参数:
            形参为字符串数组，数组 包含 每个请求参数的值
            形参为字符串，用逗号拼接
     */
    @RequestMapping("func_para")
    String func_para(String name, String password){
        System.out.println("====================================");
        System.out.println("name: " + name);
        System.out.println("password: " + password);
        return "success";
    }

    /* 将请求参数 赋给pojo形参 (需要同名：请求参数名 和 pojo属性名)
        when：传来的请求参数，用于db创建一条数据，对应一个pojo
        注：只要是满足条件的形参，都会被请求参数赋值（eg.形参有2个User pojo，都会被赋值）
     */
    @RequestMapping("func_para_pojo")
    String func_para_pojo(User user){
        System.out.println("====================================");
        System.out.println(user);
        return "success";
    }

    /* 下面3种注解（形参上的）都有三个属性：
        value：为形参赋值的 请求参数名/请求头名/cookie名
        required：是否必须传输此请求参数，
            默认true
            设为false，若没传输，则形参赋值为null
            类比spring的@Autowired，也有required属性
        defaultValue：不管required属性值为t或f，
            若 为形参赋值的内容 没传输 或 值为""，则使用默认值为形参赋值
        错误：若没传输，且没设置defaultValue，400：Required String parameter 'xxx' is not present
     */
    @RequestMapping("anno")
    String anno_requestParam(
            // 请求参数 设置为 形参
            @RequestParam("name") String userName,
            @RequestParam("password") String userPwd,
            // 请求头 设置为 形参
            @RequestHeader("Host") String host,
            // cookie 设置为 形参
            @CookieValue(value = "xxx", required = false, defaultValue = "not-set") String xxx
    ){
        System.out.println("====================================");
        System.out.println("name: " + userName);
        System.out.println("password: " + userName);
        System.out.println("host: " + host);
        System.out.println("xxx: " + xxx);
        return "success";
    }
}

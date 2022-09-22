package com.yz.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*   响应体为数据，浏览器显示 数据

测试方式
    http://localhost:8080/process/response/
    点击链接，发送请求
    查看浏览器页面      */
@Controller
@RequestMapping("response")
public class _4_2_response_body {
    @RequestMapping("/")
    String index(){
        return "_4_response";
    }

    //! 用 servletAPI 设置 response
    // （类似 _2_1_request_msg 的法1，但不用返回值.或者 返回 null 字符串
    @RequestMapping("servlet")
    void testServlet(HttpServletResponse response) throws IOException {
        final PrintWriter writer = response.getWriter();
        writer.println("123");
    }

    //! ResponseEntity：方法返回类型 为 响应，用于实现 文件下载（见_2_upload_download）

    //! @ResponseBody：方法返回值 为 响应体
    /*  @RestController注解 (标识类)
        复合注解：类加@Controller，每个方法加@ResponseBody   */
    @ResponseBody
    @RequestMapping("response_body")
    String testResponseBody(){
        return "456";
    }

    /* @ResponseBody 处理json（java对象 转换为 json对象
      步骤：maven：jackson依赖
           SpringMVC.xml：开启mvc注解驱动
           @ResponseBody 标识的方法，返回值为java对象
      原理：在HandlerAdaptor中会自动装配一个消息转换器：MappingJackson2HttpMessageConverter，
           将响应到浏览器的Java对象转换为Json格式的字符串
      应用：微服务间 数据交互，使用 http + json    */
    @ResponseBody
    @RequestMapping("response_obj")
    User testResponseUser(){
        return new User("yz", "123");
    }

    /* json 相关概念
        json，xml都是数据交互格式
        但xml常用于配置文件，因json更简单，解析更容易
        类型
            java对象，map -> json对象 {}中
            java的list -> json数组 []中       */
}

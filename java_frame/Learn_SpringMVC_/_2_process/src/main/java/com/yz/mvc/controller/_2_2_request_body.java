package com.yz.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/*
获取：请求体，请求

测试方式
    http://localhost:8080/process/request/
    点击链接，发送请求
    cmd是否输出正确信息 (来自浏览器)
*/
@Controller
@RequestMapping("request")
public class _2_2_request_body {

    // 请求体 赋值给 @RequestBody 标识的形参
    @RequestMapping("request_body")
    String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody =======================");
        System.out.println(requestBody); // name=abc&password=123
        return "success";
    }

    // 请求报文 赋值给 RequestEntity类型 的形参（封装 整个请求报文）
    @RequestMapping("request_entity")
    String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("requestEntity =======================");
        final HttpHeaders headers = requestEntity.getHeaders();
        final String body = requestEntity.getBody();
        System.out.println(headers);
        System.out.println(body);
        return "success";
    }

}

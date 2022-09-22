package com.yz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
RequestMapping 注解的属性，用于匹配请求

测试方式
    http://localhost:8080/process/map/
    点击链接，发送请求
    是否跳转到success页面
*/
@Controller
@RequestMapping("/map") // 类的RequestMapping 拼接 方法的 ==> 方法对应的请求路径
public class _1_RequestMap {

    @RequestMapping("/")
    String index(){
        return "_1_request_map";
    }

    /*
    ! value属性（必设置，其他属性可无
        字符串数组：匹配 多个请求路径
        错误：404
        注意：对于同一个请求地址，只有1个方法和它映射
     */
    @RequestMapping(value = {"/v1", "/v2", })
    String testValue(){
        return "success";
    }

    /* 路径中的占位符
       如果地址中无占位符，404
       测试：
            http://localhost:8080/process/map/rest/hahaha
       常用于RESTful风格：路径表示要操作的资源，请求方式表示操作方式
    */
    @RequestMapping("/rest/{text}") // 占位符 {xxx} 表示从浏览器传来的数据
    String testRest(@PathVariable("text") String text){ // 占位符所表示的数据，赋值给形参
        System.out.println(text);
        return "success";
    }

    /*  支持 ant 风格 (value的值)
        ？：单个字符 （不包含/和？）
        *：0个或多个字符
        \**：0层或多层目录
        注意：/a**b/，不表示多层目录， 被当做两个*
     */
    @RequestMapping(value = {"/v*a", "/v?b" , "/v/**"})
    String testAnt(){
        return "success";
    }

    /*
     ! method属性
        RequestMethod数组：匹配 多种请求方式
        默认：任何method都匹配
        错误：405：Request method 'POST' not supported
            （当满足value，不满足method）

        注： 派生注解：eg.处理get-->@GetMapping
            常用方式：get，post，put，delete（对相同资源，执行不同操作）
            表单只支持：get和post (设为其他，则发送get请求
                若要发put和delete，需通过 spring 提供的过滤器 HiddenHttpMethodFilter（见RESTful
     */
    @RequestMapping(value = "/method" , method = {RequestMethod.POST, }) // 只能发post请求
    String testMethod1(){
        return "success";
    }

    @PostMapping(value = "/method" ) // 只能发post请求
    String testMethod2(){
        return "success";
    }

    /*
    ! params属性
        字符串数组：需 请求参数满足 all表达式
            （value和method只需满足数组之一
        错误：400：Parameter conditions not met for actual request parameters
            （当满足 value和method属性，不满足params）

        四种 表达式：
        "param"：请求必须携带param参数
        "!param"：请求不能携带param请求参数
        "param=value"：请求必须携带param参数，且param=value
        "param!=value"：请求必须携带param参数，但param!=value
     */
    @RequestMapping(value = "/para", params = {"name!=root", "password"}) // 必有name和password，name不可为root
    String testPara(){
        return "success";
    }

    /*
    ! headers属性
        字符串数组：需 请求头同时满足  all表达
        错误：404 （当满足value和method属性，不满足headers）
        四种 表达式，同params
     */
}

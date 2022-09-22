package com.yz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* 响应体为 视图

测试方式
    http://localhost:8080/process/view/
    点击链接，发送请求
    是否跳转到success页面，注意url是否为 浏览器最初请求的url
*/
@Controller
@RequestMapping("view")
public class _4_1_View {

    @RequestMapping("/")
    String index(){
        return "_4_response";
    }

    //! 视图控制器 view-controller: 见springMVC.xml

    //! 三种视图
    /* SpringMVC配置文件的视图解析器(thymeleaf)
        视图名无前缀
        步骤(thymeleaf)：
            视图名 拼接 前后缀（见配置文件） ==> 最终路径
            通过转发的方式实现跳转（因为浏览器url不变）
     */
    @RequestMapping("thymeleaf")
    String thymeleaf(){
        return "success";
    }

    /* 转发 （少用）
        视图名以"forward:"为前缀，创建InternalResourceView视图（默认）
        步骤：
             去掉前缀"forward:"
             判断剩余部分是否以/开头，若是则拼接上下文路径
             最终路径，通过转发的方式实现跳转
                    （转发到其他请求，因此forward后面为其他请求名，而非文件名
     */
    @RequestMapping("forward")
    String forward(){
        return "forward:thymeleaf";
    }

    /* 重定向
        视图名以"redirect:"为前缀，创建RedirectView视图（默认）
        步骤：
            去掉前缀"redirect:"
            判断剩余部分是否以/开头，若是则拼接上下文路径
            最终路径，通过重定向的方式实现跳转
        如：某操作成功后，跳转到下一功能（不同的url），和之前的请求无关
     */
    @RequestMapping("redirect")
    String redirect(){
        return "redirect:thymeleaf";
    }
}

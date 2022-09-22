package com.yz.mvc.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/* 向域（scope）对象 共享数据

    测试方式
        http://localhost:8080/process/scope/
        点击链接，发送请求
        跳转页面显示：从服务器 传到浏览器的数据（通过 向域对象 共享数据）
 */
@Controller
@RequestMapping("scope")
public class _3_2_Scope {

    @RequestMapping("/")
    String index(){
        return "_3_scope";
    }


    /* servlet API 传 request，session，servletContext
        其中：ServletContext (也称作 Application，因为该域对象的范围为整个应用)
            多种方法获取 ServletContext: 从request，session，servletConfig
     */
    @RequestMapping("/servletAPI")
    String testServletAPI(HttpServletRequest request, HttpSession session){
        request.setAttribute("request_msg", "hello, request!");

        session.setAttribute("session_msg", "hello, session!");

        session.getServletContext().setAttribute("application_msg", "hello, application!");
        // 也可：request.getServletContext().setAttribute();

        return "_3_success";
    }

    //! 以下：都为 向request共享数据
    /* ModelAndView
        Model：向域对象共享数据
      	View：设置视图，实现页面跳转

       推荐：因为向request共享数据，都会封装为 ModelAndView
       注意：要返回 ModelAndView 对象
     */
    @RequestMapping("/mav")
    ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("request_msg", "hello, modelAndView");
        modelAndView.setViewName("_3_success");

        return modelAndView;
    }

    //! 以下三种方式，实际类型 都为 BindingAwareModelMap （继承图 见 _3_）
    @RequestMapping("/model")
    String testModel(Model model){
        model.addAttribute("request_msg", "hello, model");
        return "_3_success";
    }

    @RequestMapping("/map")
    String testMap(Map map){
        map.put("request_msg", "hello, map");
        return "_3_success";
    }

    @RequestMapping("/model_map")
    String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("request_msg", "hello, modelMap");
        return "_3_success";
    }
}

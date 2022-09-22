package com.yz.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

// 代替web.xml（类名随意）
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 以下方法都返回数组，因此可以配置多个
    // 指定spring的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    // 指定springMVC的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    // 指定DispatcherServlet的映射规则，即url-pattern
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 添加过滤器(此处为处理请求参数乱码的过滤器)
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceResponseEncoding(true);

        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        // 注意：返回顺序
        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};
    }
}

/* 原理：
服务器启动时自动加载
1. Servlet3.0环境中，容器会在类路径中查找实现javax.servlet.ServletContainerInitializer接口的类，
    找到就用它来配置Servlet容器。
2. Spring提供了这个接口的实现 SpringServletContainerInitializer，
    这个类会查找实现WebApplicationInitializer的类，并将配置的任务交给它们来完成。
3. Spring3.2引入了一个便利的WebApplicationInitializer基础实现，AbstractAnnotationConfigDispatcherServletInitializer，
    当我们的类扩展了AbstractAnnotationConfigDispatcherServletInitializer并将其部署到Servlet3.0容器的时候，
    容器会自动发现它，并用它来配置Servlet上下文。
 */
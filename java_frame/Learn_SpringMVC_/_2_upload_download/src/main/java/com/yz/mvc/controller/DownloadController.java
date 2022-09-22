package com.yz.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class DownloadController {

    // 实现下载文件（服务器 -> 浏览器）

    @RequestMapping("download")
    // 返回类型ResponseEntity，返回值 就是响应到浏览器的响应报文
    ResponseEntity<byte[]> download(HttpSession session) throws IOException {
        //! 响应体
        // webapp下文件的路径 -> 服务器中文件的真实路径
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/static/img/img_server.png");
        // 将文件 读到 字节数组
        InputStream is = new FileInputStream(realPath);
        byte[] bytes = new byte[is.available()];  // size为文件的字节数
        is.read(bytes);
        //! 响应头 (HttpHeaders)
        MultiValueMap<String, String> headers = new HttpHeaders();
        // 设置下载方式（attachment为附件 ）及文件名（1.png外，都是固定的
        headers.add("Content-Disposition", "attachment;filename=1.png");
        //! 状态码
        HttpStatus statusCode = HttpStatus.OK;
        //! 创建ResponseEntity（响应体，相应头，状态码）
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }
}

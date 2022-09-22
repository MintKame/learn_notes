package com.yz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {

    /* 文件上传（浏览器 -> 服务器）
        ! 前置需要：
            html的form表单        （见file.html）
            依赖commons-fileupload（见pom.xml）
            配置：文件上传解析器    （见springMVC.xml）  */
    @RequestMapping("upload")
    //  SpringMVC 中将上传的文件封装到MultipartFile 对象中，包含文件信息
    String upload(MultipartFile photo, HttpSession session)throws IOException {
        //! 上传文件的文件名
        String fileName = photo.getOriginalFilename();
        // 处理重名（防止旧文件的内容被覆盖，因为写文件默认不追加而是覆盖文件内容
        String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 文件名后缀
        fileName = UUID.randomUUID().toString() + suffixName;
        //! 服务器中，photo目录 的路径
        ServletContext servletContext = session.getServletContext();
        String dirPath = servletContext.getRealPath("photo");// webapp下文件的路径 -> 服务器的文件的真实路径
        File file = new File(dirPath);
        if(!file.exists()){
            file.mkdir();
        }
        //! 资源转移到服务器 (封装了 读写文件)
        // 最终 文件上传到 target文件夹下（服务器，而非源代码）
        String finalPath = dirPath + File.separator + fileName;
        photo.transferTo(new File(finalPath));
        return "success";
    }
}

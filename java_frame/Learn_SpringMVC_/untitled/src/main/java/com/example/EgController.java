package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EgController {
    @RequestMapping("eg")
    String eg(){
        return "haha";
    }
}

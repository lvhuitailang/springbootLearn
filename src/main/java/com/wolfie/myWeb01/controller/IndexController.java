package com.wolfie.myWeb01.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/index/body/frame")
    public String index_main_body_frame(){
        return "index_main_body_frame";

    }
}

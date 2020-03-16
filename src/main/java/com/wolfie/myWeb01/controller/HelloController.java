package com.wolfie.myWeb01.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @RequestMapping("/sayHello")
    public String sayHello(HttpServletRequest request){
        return "hello world!";

    }

}

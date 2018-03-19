package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class securityController {
    @RequestMapping(value = {"/","/index"})
    public String index(){
        System.out.println("主页面");
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("登录页面");
        return "login";
    }
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello页面");
        return "hello";
    }
}

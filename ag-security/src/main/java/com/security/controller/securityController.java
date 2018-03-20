package com.security.controller;

import org.springframework.security.access.prepost.PostAuthorize;
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

// 使用@PostAuthorize，从方法(用户对象)返回的值将是使用 returnObject 对象访问在Spring表达式语言中
// @PostAuthorize("returnObject.type == authentication.name")
//    User findById(int id);
//
//    @PreAuthorize("hasRole('ADMIN')")
//    void updateUser(User user);
//由于@PreAuthorize可以使用Spring表达式语言，任何条件可以很容易地使用EL来表示。
// deleteUser 方法现在配置以通过同时拥有ADMIN和DBA角色的用户调用。
//    @PreAuthorize("hasRole('ADMIN') AND hasRole('DBA')")
//    void deleteUser(int id);
}

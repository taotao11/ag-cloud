package com.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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
    /**
     * 动态改变权限
     *
     *@Secured("ROLE_VIP")
     * 1、直接访问 /vip/test 路径将会得到403的Response；
     * 2、访问 /vip 获取 ROLE_VIP 授权，再访问 /vip/test 即可得到正确的Response。
     */
    @GetMapping("/vip/test")
    @Secured("ROLE_VIP")         // 需要ROLE_VIP权限可访问
    public String vipPath() {
        return "仅 ROLE_VIP 可看";
    }

    @GetMapping("/vip")
    public boolean updateToVIP() {
        // 得到当前的认证信息
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //  生成当前的所有授权
        List<GrantedAuthority> updatedAuthorities = new ArrayList<>(auth.getAuthorities());
        // 添加 ROLE_VIP 授权
        updatedAuthorities.add(new SimpleGrantedAuthority("ROLE_VIP"));
        // 生成新的认证信息
        Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);
        // 重置认证信息
        SecurityContextHolder.getContext().setAuthentication(newAuth);
        return true;
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

package com.security.controller;

import com.security.entity.UserEntity;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping("/save")
    @ResponseBody
    public UserEntity save(UserEntity userEntity){
        return service.insert(userEntity);
    }
}

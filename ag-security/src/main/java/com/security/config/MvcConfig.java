package com.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * addViewControllers()方法（覆盖WebMvcConfigurerAdapter中同名的方法）添加了四个视图控制器。
 * 两个视图控制器引用名称为“home”的视图（在home.html中定义），
 * 另一个引用名为“hello”的视图（在hello.html中定义）。
 * 第四个视图控制器引用另一个名为“login”的视图。 您将在下一部分中创建该视图。
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }

}
package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * security 配置类
 * 继承WebSecurityConfigurerAdapter，并重写它的方法来设置一些web安全的细节
 *
 */
@Configuration //配置功能
@EnableWebSecurity //注解开启Spring Security的功能
@EnableGlobalMethodSecurity//开启方法安全验证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AnyUserDetailsService anyUserDetailsService(){

        return new AnyUserDetailsService();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
           .authorizeRequests()//定义哪些URL需要被保护、哪些不需要被保护
               .antMatchers("/","/index","/save").permitAll()//指定了/和/home不需要任何认证就可以访问，其他的路径都必须通过身份验证。
               .antMatchers("/admin/**").hasRole("admin")// /admin/** 需要admin 权限
               //任何以"/db"开头的请求同时要求用户具有"ROLE_ADMIN"和"ROLE_DBA"角色。
               .antMatchers( "/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
               //任何没有匹配上的其他的url请求，只需要用户被验证。
               .anyRequest().authenticated()
               .and()
           .formLogin()//需要用户登录时候，转到的登录页面。
                .loginPage("/login").defaultSuccessUrl("/hello")
               .failureForwardUrl("/hello")//跳转错误页面
               .successForwardUrl("/hello")
                .permitAll()
                .and()
                .logout().permitAll()
                .logoutSuccessUrl("/login")//退出成功跳转的页面
               .and()
           .rememberMe()//记住我
               .key("unique-and-secret")
               .rememberMeCookieName("remember-me-cookie-name")
               .tokenValiditySeconds(24 * 60 * 60);

    }

    /**
     *登录验证
     * 在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。
     * @param auth
     * @throws Exception
     */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }

    /**
     * 实现自定义登录 验
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(anyUserDetailsService())
            .passwordEncoder(passwordEncoder());//设置加密验证

    }
    /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

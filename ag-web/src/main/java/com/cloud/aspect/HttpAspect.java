package com.cloud.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 请求类型Aop
 */
//开启AOp
//@Aspect
////成为组件
//@Component
public class HttpAspect {

    private  final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(public * com.cloud.controller.*.*(..))")
    public void log(){

    }

    /**
     * 请求前的方法
     */
    @Before("log()")
    public void before(){

    }
    /**
     * 请求后的方法
     *
     */
    @After("log()")
    public void  after(){

    }

    /**
     * 返回结果时的方法
     */
    @AfterReturning
    public void runtring(){

    }
}

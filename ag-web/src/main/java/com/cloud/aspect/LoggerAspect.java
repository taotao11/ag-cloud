package com.cloud.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 日志切面类
 *
 */

@Aspect
@Component
public class LoggerAspect {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(public * com.cloud.controller.*.*(..))")
    public void log(){

    }
//方法运行前打印
    @Before("log()")
    public void before(JoinPoint joinPoint){
        //获得request
        //RequestContextHolder.getRequestAttributes() 获得request 对象
        //JoinPoint 获得类名方法名
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //获得类 方法名
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();

        RequestLog requestLog = new RequestLog(
                request.getRequestURI().toString(),//获得请求路径
                request.getRemoteAddr(),//主机地址
                classMethod,//类方法
                joinPoint.getArgs()//参数
        );
        logger.info("  Request :  {}----------",requestLog);
    }
    //方法运行后打印
    @After("log()")
    public void after(){
//        logger.info("---------after  2------------");
    }
    //获取方法返回值 returning = "result" 指定名称
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterRuntrning(Object result){
        logger.info(" return  -----  : {}",result);
    }

    /**
     * 内部类
     *封装返回结果集
     *
     */
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}

package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 启动类
 * @EnableEurekaServer 开启注册中心
 */

@SpringBootApplication
@EnableEurekaServer
public class AgEurakaServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(AgEurakaServiceApp.class,args);
    }
}

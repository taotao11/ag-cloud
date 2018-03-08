package com.egfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
//注册服务
@EnableDiscoveryClient
//开启feign功能
@EnableFeignClients
public class EgFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgFeignApplication.class, args);
	}

	//
}

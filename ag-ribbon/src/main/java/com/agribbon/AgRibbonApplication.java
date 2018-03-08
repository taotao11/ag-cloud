package com.agribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者
 * @EnableCircuitBreaker 激活断路
 */
@SpringBootApplication
@EnableDiscoveryClient //激活服务发现
@EnableHystrix//启动断路器
public class AgRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgRibbonApplication.class, args);
	}
	@Bean
	@LoadBalanced //开启负载均衡
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}

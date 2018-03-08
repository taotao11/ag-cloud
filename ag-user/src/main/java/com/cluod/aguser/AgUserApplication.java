package com.cluod.aguser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @EnableEurekaClient 在服务注册中心进行注册 （会激活discoveryClient 进行服务注册
 *	@Value("${server.port}") 获得配置文件的信息
 *	String port;
 * 开启mapper 包扫描
 *
 */
@MapperScan("com.cluod.aguser.mapper")
@EnableEurekaClient
@SpringBootApplication
public class AgUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgUserApplication.class, args);
	}
}

package com.agconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * congif 类
 * 分布式配置中心
 */
@SpringBootApplication
@EnableConfigServer //启动分布式配置中心
public class AgConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgConfigServiceApplication.class, args);
	}
}

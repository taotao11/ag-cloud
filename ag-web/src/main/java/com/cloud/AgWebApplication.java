package com.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启事务
@EnableTransactionManagement
@MapperScan("com.cloud.mapper")
@SpringBootApplication
public class AgWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgWebApplication.class, args);
	}
}

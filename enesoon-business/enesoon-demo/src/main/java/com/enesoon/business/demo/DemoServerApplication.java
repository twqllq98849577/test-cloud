package com.enesoon.business.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@MapperScan("com.enesoon.business.demo.dao") //扫描的mapper
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class DemoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServerApplication.class, args);
	}
}
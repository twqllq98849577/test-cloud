package com.enesoon.business.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.enesoon.business.demo.dao")
public class MyBatisConfig {
}

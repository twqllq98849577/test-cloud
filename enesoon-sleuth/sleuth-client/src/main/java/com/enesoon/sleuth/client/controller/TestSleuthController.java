package com.enesoon.sleuth.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 路径：com.example.demo.sleuth.controller
 * 类名：
 * 功能：对外暴露接口
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/18 22:26
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RestController
public class TestSleuthController {

    private static final Logger log = LoggerFactory.getLogger(TestSleuthController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String test(){
        log.info("calling trace service-sleuth");
        return "I'm service-sleuth----test";
        //return restTemplate.getForObject("http://localhost:8082/miya", String.class);
    }

    @GetMapping("/info1")
    public String info1(){
        log.info("calling trace service-sleuth");
        return "I'm service-sleuth";
    }
}

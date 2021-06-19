package com.enesoon.feign.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enesoon.feign.client.service.TestService;

/**
 * 路径：com.example.demo.feign.controller
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/11 22:06
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String test(String name){
        return testService.getByClientOne(name);
    }
}

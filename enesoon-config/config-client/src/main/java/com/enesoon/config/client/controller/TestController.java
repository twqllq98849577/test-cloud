package com.enesoon.config.client.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 路径：com.example.demo.config.controller
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/14 10:55
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RestController
public class TestController {

    @Value("${foo}")
    String foo;

    @GetMapping("/test")
    public String test(){
        return foo;
    }
}

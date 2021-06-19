package com.enesoon.feign.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 路径：com.example.demo.feign.service
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/11 22:03
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
//@FeignClient(value = "feign-client")
@FeignClient(value = "enesoon-demo")
public interface TestService {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String getByClientOne(@RequestParam(value = "name")String name);
}

package com.enesoon.business.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enesoon.business.demo.entity.User;
import com.enesoon.business.demo.service.UserService;

/**
 * 路径：com.example.demo.bus.controller 类名： 功能：《用一句描述一下》 备注： 创建人：typ
 * 创建时间：2018/9/17 21:50 修改人： 修改备注： 修改时间：
 */
//@Api(value = "TestController管理")
@RestController
@EnableEurekaClient
public class TestController {
	@Autowired
	private UserService userService;

	@GetMapping("/test")
	public String test(String name) {
		//List<User> list = userService.test();
        //System.out.println("list:" + list);
        return "111";
	}
	
	@GetMapping("/login")
	public String login(String name) {
		//List<User> list = userService.test();
        //System.out.println("list:" + list);
        return "login";
	}
}

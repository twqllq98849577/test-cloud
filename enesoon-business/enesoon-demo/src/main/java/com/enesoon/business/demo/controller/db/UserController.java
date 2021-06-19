package com.enesoon.business.demo.controller.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enesoon.business.demo.entity.User;
import com.enesoon.business.demo.service.UserService;
import com.enesoon.business.demo.utils.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

/**
 * @Package: com.tp.mybatisplusstudy.controller
 * @ClassName: UserController
 * @Author: tanp
 * @Description: ${description}
 * @Date: 2020/4/22 9:13
 */
@RestController
@RequestMapping("/user")
@Api(value = "user-provider", description = "用户查询接口")
@SuppressWarnings({"static-access","rawtypes"})
public class UserController {

	@Autowired
	private UserService iUserService;
	
	
	@PostMapping(value ="/save", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Response save(@RequestBody User user) {
		iUserService.saveUser(user);
		return new Response().ok();
	}

	@PostMapping(value ="/update", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Response update(@RequestBody User user) {
		iUserService.updateUser(user);
		return new Response().ok();
	}

	@DeleteMapping(value = "/delete", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Response delete(@ApiParam(value = "id") @RequestParam(required = true) String userid) {
		User user = new User();
		user.setUserid(1);
		user.setUsername("Username");
		iUserService.updateUser(user);
		return new Response().ok();
	}

	@GetMapping(value = "/list", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Response list(@RequestParam(value="page", defaultValue="1") Integer page,
			@RequestParam(value="rows", defaultValue="10") Integer rows) {
		List<User> list = iUserService.list(page,rows) ;
		
		return new Response<User>().ok(list);
	}

}

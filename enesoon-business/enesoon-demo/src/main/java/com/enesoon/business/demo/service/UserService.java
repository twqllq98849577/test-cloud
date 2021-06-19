package com.enesoon.business.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.enesoon.business.demo.entity.User;

public interface UserService{
	public List<User> querySQL();
	
	public List<User> list(Integer page,Integer rows);
	
	public void saveUser(User entity);
	
	public void updateUser(User entity);
	
	public void deleteUser(User entity);

}

package com.enesoon.business.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.enesoon.business.demo.dao.UserMapper;
import com.enesoon.business.demo.entity.User;
import com.enesoon.business.demo.service.UserService;
import com.github.pagehelper.PageHelper;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserMapper userMapper;
	
    public List<User> querySQL(){
    	return userMapper.querySQL();
    }
	
	public List<User> list(Integer page,Integer rows){
		PageHelper.startPage(page, rows);
		QueryWrapper qw = new QueryWrapper();
        qw.likeRight("username","mike");
        return userMapper.selectList(qw);
	}
	
	public void saveUser(User entity){
		userMapper.insert(entity) ;
	}
	
	public void updateUser(User entity){
		userMapper.updateById(entity) ;
	}
	
	public void deleteUser(User entity){
		userMapper.updateById(entity) ;
	}

}

package com.enesoon.business.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.enesoon.business.demo.entity.User;

	

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface UserMapper extends BaseMapper<User>{

	public List<User> querySQL();
}

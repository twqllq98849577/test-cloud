package com.enesoon.business.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("t_user")
public class User implements Serializable{
	private int userid ;
	private String username ; 

}

package com.md.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.md.entity.User;
import com.md.mapper.UserMapper;
import com.md.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	@Transactional
	public void addUser(User user) {
		logger.info("新增用户信息开始。。。");
		userMapper.insertUser(user);
		logger.info("新增用户信息结束。。。");
	}

	@Override
	@Transactional
	public void delUser(String id) {
		logger.info("删除用户信息开始,用户编号:"+id+",。。。");
		userMapper.deleteById(id);
		logger.info("删除用户信息结束。。。");
	}

	@Override
	@Transactional
	public void editUser(User user) {
		logger.info("修改用户信息开始。。。");
		userMapper.updateUser(user);
		logger.info("修改用户信息结束。。。");
	}

	@Override
	public List<User> queryUserInfo(Map mapParams) {
		logger.info("info查询用户信息开始。。。");
		logger.debug("debug查询用户信息开始。。。");
		logger.error("error查询用户信息开始。。。");
		logger.warn("warn查询用户信息开始。。。");
		logger.info("查询用户信息开始。。。");
		return userMapper.selectUserInfo(mapParams);
	}
	
	@Override
	public Integer queryUserInfoCount(Map mapParams) {
		return userMapper.selectUserInfoCount(mapParams);
	}

	@Override
	public User queryUserById(String id) {
		return userMapper.queryUserById(id);
	}

}

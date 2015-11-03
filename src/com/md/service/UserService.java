package com.md.service;

import java.util.List;
import java.util.Map;

import com.md.entity.User;

public interface UserService {
	public void addUser(User user);
	
	public void delUser(String id);
	
	public void editUser(User user);
	
	public List<User> queryUserInfo(Map mapParams);
	
	public Integer queryUserInfoCount(Map mapParams);
	
	public User queryUserById(String id);
}

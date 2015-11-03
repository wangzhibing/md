package com.md.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.md.entity.User;

@Repository
public interface UserMapper {
	
	public void insertUser(User user);
	
	public void deleteById(String id);
	
	public void updateUser(User user);
	
	public List<User> selectUserInfo(Map mapParams);
	
	public Integer selectUserInfoCount(Map mapParams);
	
	public User queryUserById(String id);
}

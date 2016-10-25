package com.theo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theo.dao.UserDao;
import com.theo.domain.User;
import com.theo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao ;

	@Override
	public User checkUser(User user) {
		return userDao.checkUser(user);
	}
	
}

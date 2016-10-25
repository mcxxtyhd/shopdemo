package com.theo.service;

import com.theo.domain.User;

public interface UserService {
	// 验证用户是否合法
	public User checkUser(User user);
}

package com.theo.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.theo.dao.UserDao;
import com.theo.domain.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User checkUser(User user) {
		String sql = "select * from users where username=? and password=?";
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
		try{
			user= jdbcTemplate.queryForObject(sql, rowMapper,user.getUsername(), user.getPassword());
		}
		catch(Exception e){
		}
		return user;
	}
}

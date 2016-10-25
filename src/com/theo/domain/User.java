package com.theo.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String email;
	private String tel;
	private int grade;
	public User() {
		super();
	}
	public User(int id, String username, String password, String email, String tel, int grade) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", tel="
				+ tel + ", grade=" + grade + "]";
	}
	
}

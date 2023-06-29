package com.spring.bean;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class LoginForm {

	@NotBlank(message = "{NotBlank.lo.username}")
	private String username;

	@Length(min = 6, max = 12, message = "Length.lo.password")
	@NotBlank(message = "{NotBlank.lo.password}")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

package com.spring.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class AccountForm {

	@NotBlank(message = "{NotBlank.user.username}")
	private String username;
	@NotBlank(message = "{NotBlank.user.password}")
	@Length(min = 6, max = 12, message = "{Length.user.password}")
	private String password;
	@NotBlank(message = "{NotBlank.user.email}")
	@Length(max = 100, message = "Length.user.email")
	@Email(message = "{Format.user.email}")
	private String email;

	private Integer role;
	private Integer trangThai;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

}

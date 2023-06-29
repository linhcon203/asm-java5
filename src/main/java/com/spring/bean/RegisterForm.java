package com.spring.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class RegisterForm {

	@NotBlank(message = "{NotBlank.register.username}")
	private String username;
	@NotBlank(message = "{NotBlank.register.password}")
	@Length(min = 6, max = 12, message = "{Length.register.password}")
	private String password;
	@NotBlank(message = "{NotBlank.register.repass}")
	@Length(min = 6, max = 12, message = "{Length.register.repass}")
	private String repass;
	@NotBlank(message = "{NotBlank.register.email}")
	@Email(message = "{Format.register.email}")
	private String email;

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

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

}

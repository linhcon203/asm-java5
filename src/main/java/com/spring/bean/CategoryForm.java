package com.spring.bean;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class CategoryForm {

	private Integer id;
	@NotBlank(message = "{NotBlank.cate.ten}")
	@Length(max = 100, message = "{Length.cate.ten}")
	private String ten;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

}

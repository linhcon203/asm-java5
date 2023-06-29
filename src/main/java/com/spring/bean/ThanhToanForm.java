package com.spring.bean;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class ThanhToanForm {

	@NotBlank(message = "{NotBlank.gioHang.tennguoinhan}")
	@Length(max = 100 , message = "{Length.gioHang.tennguoinhan}")
	private String tennguoinhan;
	@NotBlank(message = "{NotBlank.gioHang.tennguoinhan}")
	@Length(min = 10 , max = 10 , message = "{Length.gioHang.sdt}")
	private String sdt;
	@NotBlank(message = "{NotBlank.gioHang.diachi}")
	@Length(max = 100 , message = "{Length.gioHang.diachi}")
	private String diachi;
	
	public String getTennguoinhan() {
		return tennguoinhan;
	}
	public void setTennguoinhan(String tennguoinhan) {
		this.tennguoinhan = tennguoinhan;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	
}

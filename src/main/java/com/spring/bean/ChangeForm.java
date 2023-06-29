package com.spring.bean;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class ChangeForm {

	@NotBlank(message = "")
	@Length(min = 6, max = 12, message = "")
	private String passcu;
	@NotBlank(message = "")
	@Length(min = 6, max = 12, message = "")
	private String passmoi;
	@NotBlank(message = "")
	@Length(min = 6, max = 12, message = "")
	private String repassmoi;

	public String getPasscu() {
		return passcu;
	}

	public void setPasscu(String passcu) {
		this.passcu = passcu;
	}

	public String getPassmoi() {
		return passmoi;
	}

	public void setPassmoi(String passmoi) {
		this.passmoi = passmoi;
	}

	public String getRepassmoi() {
		return repassmoi;
	}

	public void setRepassmoi(String repassmoi) {
		this.repassmoi = repassmoi;
	}

}

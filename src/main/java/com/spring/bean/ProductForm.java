package com.spring.bean;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ProductForm {

	private Integer id;
	@NotBlank(message = "{NotBlank.data.tieuDe}")
	private String tieuDe;
	@NotBlank(message = "{NotBlank.data.moTa}")
	private String moTa;
	@NotNull(message = "{NotBlank.data.gia}")
	@Min(value = 0 , message = "{Negative.data.giaNho}")
	@Max(value = 999999999 , message = "{Negative.data.giaLon}" )
	private BigDecimal gia;
	@Min(value = 0 , message = "{Negative.data.giamGiaNho}")
	@Max(value = 100 , message = "{Negative.data.giamGiaLon}")
	private Integer giamGia;
	private Integer soLuong;
	private Integer phanLoai;
	private String kichThuoc;
	@NotBlank(message = "{NotBlank.data.chatLieu}")
	private String chatLieu;
	@NotBlank(message = "{NotBlank.data.thietKe}")
	private String thietKe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public BigDecimal getGia() {
		return gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public Integer getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(Integer giamGia) {
		this.giamGia = giamGia;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public String getThietKe() {
		return thietKe;
	}

	public void setThietKe(String thietKe) {
		this.thietKe = thietKe;
	}

	public Integer getPhanLoai() {
		return phanLoai;
	}

	public void setPhanLoai(Integer phanLoai) {
		this.phanLoai = phanLoai;
	}

}

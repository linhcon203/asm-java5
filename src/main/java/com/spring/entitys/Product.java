package com.spring.entitys;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product", nullable = false)
	private Integer id;
	@Column(name = "tieude")
	private String tieuDe;
	@Column(name = "mota")
	private String moTa;
	@Column(name = "image")
	private String anh;
	@Column(name = "gia")
	private BigDecimal gia;
	@Column(name = "giamgia")
	private Integer giamGia;
	@Column(name = "soluong")
	private Integer soLuong;
	@Column(name = "phanloai")
	private String phanLoai;
	@Column(name = "kichthuoc")
	private String kichThuoc;
	@Column(name = "chatlieu")
	private String chatLieu;
	@Column(name = "thietke")
	private String thietKe;
	@Column(name = "trangthai")
	private Integer trangThai;

	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;

	public Product() {
		super();
	}

	public Product(Integer id, String tieuDe, String moTa, String anh, BigDecimal gia, Integer giamGia, Integer soLuong,
			String phanLoai, String kichThuoc, String chatLieu, String thietKe, Integer trangThai, Category category) {
		super();
		this.id = id;
		this.tieuDe = tieuDe;
		this.moTa = moTa;
		this.anh = anh;
		this.gia = gia;
		this.giamGia = giamGia;
		this.soLuong = soLuong;
		this.phanLoai = phanLoai;
		this.kichThuoc = kichThuoc;
		this.chatLieu = chatLieu;
		this.thietKe = thietKe;
		this.trangThai = trangThai;
		this.category = category;
	}

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

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
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

	public String getPhanLoai() {
		return phanLoai;
	}

	public void setPhanLoai(String phanLoai) {
		this.phanLoai = phanLoai;
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

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}

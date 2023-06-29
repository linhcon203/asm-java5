package com.spring.entitys;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "Cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGioHang;

	@ManyToOne
	@JoinColumn(name = "username")
	private Account username;

	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;

	@JoinColumn(name = "soLuong")
	private Integer soLuong;

	@JoinColumn(name = "donGia")
	private BigDecimal donGia;

	@JoinColumn(name = "kichThuoc")
	private String kichThuoc;

	public Cart() {
		super();
	}

	public Cart(Integer idGioHang, Account username, Product product, Integer soLuong, BigDecimal donGia,
			String kichThuoc) {
		super();
		this.idGioHang = idGioHang;
		this.username = username;
		this.product = product;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.kichThuoc = kichThuoc;
	}

	public Integer getIdGioHang() {
		return idGioHang;
	}

	public void setIdGioHang(Integer idGioHang) {
		this.idGioHang = idGioHang;
	}

	public Account getUsername() {
		return username;
	}

	public void setUsername(Account username) {
		this.username = username;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public BigDecimal getDonGia() {
		return donGia;
	}

	public void setDonGia(BigDecimal donGia) {
		this.donGia = donGia;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

}

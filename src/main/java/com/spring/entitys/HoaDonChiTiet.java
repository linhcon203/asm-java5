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
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTiet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHoaDonChiTiet")
	private Integer idHoaDonChiTiet;

	@ManyToOne
	@JoinColumn(name = "idHoaDon")
	private HoaDon hoaDon;

	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;

	@JoinColumn(name = "soLuong")
	private Integer soLuong;

	@JoinColumn(name = "donGia")
	private BigDecimal donGia;

	@JoinColumn(name = "kichThuoc")
	private String kichThuoc;

	public HoaDonChiTiet() {
		super();
	}

	public HoaDonChiTiet(Integer idHoaDonChiTiet, HoaDon hoaDon, Product product, Integer soLuong, BigDecimal donGia,
			String kichThuoc) {
		super();
		this.idHoaDonChiTiet = idHoaDonChiTiet;
		this.hoaDon = hoaDon;
		this.product = product;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.kichThuoc = kichThuoc;
	}

	public Integer getIdHoaDonChiTiet() {
		return idHoaDonChiTiet;
	}

	public void setIdHoaDonChiTiet(Integer idHoaDonChiTiet) {
		this.idHoaDonChiTiet = idHoaDonChiTiet;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
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

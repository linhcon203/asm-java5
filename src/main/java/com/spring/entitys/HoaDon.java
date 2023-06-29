package com.spring.entitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHoaDon")
	private Integer idHoaDon;

	@ManyToOne()
	@JoinColumn(name = "username")
	private Account username;

	@JoinColumn(name = "ngayTao")
	private String ngayTao;

	@JoinColumn(name = "ngayThanhToan")
	private String ngayThanhToan;

	@JoinColumn(name = "trangThai")
	private Integer trangThai;

	@JoinColumn(name = "nguoiNhan")
	private String nguoiNhan;

	@JoinColumn(name = "diaChi")
	private String diaChi;

	@JoinColumn(name = "soDienThoai")
	private String soDienThoai;

	@OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
	private List<HoaDonChiTiet> hdcts;

	public HoaDon() {
		super();
	}

	public HoaDon(Integer idHoaDon, Account username, String ngayTao, String ngayThanhToan, Integer trangThai,
			String nguoiNhan, String diaChi, String soDienThoai, List<HoaDonChiTiet> hdcts) {
		super();
		this.idHoaDon = idHoaDon;
		this.username = username;
		this.ngayTao = ngayTao;
		this.ngayThanhToan = ngayThanhToan;
		this.trangThai = trangThai;
		this.nguoiNhan = nguoiNhan;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.hdcts = hdcts;
	}

	public Integer getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(Integer idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public Account getUsername() {
		return username;
	}

	public void setUsername(Account username) {
		this.username = username;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(String ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	public String getNguoiNhan() {
		return nguoiNhan;
	}

	public void setNguoiNhan(String nguoiNhan) {
		this.nguoiNhan = nguoiNhan;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public List<HoaDonChiTiet> getHdcts() {
		return hdcts;
	}

	public void setHdcts(List<HoaDonChiTiet> hdcts) {
		this.hdcts = hdcts;
	}

}

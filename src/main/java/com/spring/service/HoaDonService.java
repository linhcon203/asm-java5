package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.spring.entitys.HoaDon;

public interface HoaDonService {

	public Page<HoaDon> getAll(Integer pageNum , Integer pageSize, String username);
	public List<HoaDon> count(String username);
	public Page<HoaDon> getAllPage(Integer pageNum , Integer pageSize);
	public List<HoaDon> countPage();
	public Optional<HoaDon> getById(Integer id);
	public HoaDon add(HoaDon hoaDon);
	public HoaDon update(HoaDon hoaDon);
	public HoaDon delete(HoaDon hoaDon);
	public HoaDon getHoaDonbyId(Integer id);
	public List<HoaDon> getHoaDonByUsername(String username);
}

package com.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.entitys.HoaDon;
import com.spring.repository.IHoaDonRepository;
import com.spring.service.HoaDonService;

@Service
public class IHoaDonService implements HoaDonService{

	@Autowired
	private IHoaDonRepository repo;
	
	@Override
	public Page<HoaDon> getAll(Integer pageNum, Integer pageSize, String username) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		return repo.phantrang(pageable, username);
	}

	@Override
	public List<HoaDon> count(String username) {
		// TODO Auto-generated method stub
		return repo.countPhanTrang(username);
	}

	@Override
	public Optional<HoaDon> getById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public HoaDon add(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		return repo.save(hoaDon);
	}

	@Override
	public HoaDon update(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		HoaDon hd = repo.getById(hoaDon.getIdHoaDon());
		hd.setTrangThai(hoaDon.getTrangThai());
		hd.setNgayThanhToan(hoaDon.getNgayThanhToan());
		return repo.save(hd);
	}

	@Override
	public HoaDon delete(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public HoaDon getHoaDonbyId(Integer id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public List<HoaDon> getHoaDonByUsername(String username) {
		// TODO Auto-generated method stub
		return repo.getHoaDonbyUsername(username);
	}

	@Override
	public Page<HoaDon> getAllPage(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		return repo.phantrangAll(pageable);
	}

	@Override
	public List<HoaDon> countPage() {
		// TODO Auto-generated method stub
		return repo.countPhanTrangAll();
	}
}

package com.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.entitys.HoaDon;

@Repository
public interface IHoaDonRepository extends JpaRepository<HoaDon, Integer>{

	@Query("Select e from HoaDon e where e.username.username like :user")
	Page<HoaDon> phantrang(Pageable pageable , @Param("user") String username);
	@Query("Select e from HoaDon e where e.username.username like :user")
	List<HoaDon> countPhanTrang(@Param("user") String username);
	@Query("Select e from HoaDon e")
	Page<HoaDon> phantrangAll(Pageable pageable);
	@Query("Select e from HoaDon e")
	List<HoaDon> countPhanTrangAll();
	@Query("Select e from HoaDon e where e.username.username like :user")
	List<HoaDon> getHoaDonbyUsername(@Param("user") String usernmae);
}

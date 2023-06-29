package com.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entitys.Category;



@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer>{
	@Query("Select e from Category e where e.trangThai = 0")
	Page<Category> phantrang(Pageable pageable);
	@Query("Select e from Category e where e.trangThai = 0")
	List<Category> countPhanTrang();
	

	
}

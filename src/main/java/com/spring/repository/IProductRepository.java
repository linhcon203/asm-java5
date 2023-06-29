package com.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.entitys.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{
	@Query("Select e from Product e where e.trangThai = 0")
	Page<Product> phantrang(Pageable pageable);
	@Query("Select e from Product e where e.trangThai = 0")
	List<Product> countPhanTrang();
	
	@Query("Select e from Product e where e.trangThai = 0 and e.category.id =:id")
	Page<Product> phantrangCategory(Pageable pageable , @Param("id") Integer id);
	@Query("Select e from Product e where e.trangThai = 0 and e.category.id =:id")
	List<Product> countPhanTrangCategory( @Param("id") Integer id);
	

}

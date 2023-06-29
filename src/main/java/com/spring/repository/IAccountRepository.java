package com.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.entitys.Account;

@Repository
public interface IAccountRepository  extends JpaRepository<Account, Integer>{
	@Query("SELECT e FROM Account e WHERE e.username LIKE :username")
	Account getByUsername(@Param("username") String username);

	@Query("Select e from Account e where e.trangThai = 0")
	Page<Account> phantrang(Pageable pageable);
	@Query("Select e from Account e where e.trangThai = 0")
	List<Account> countPhanTrang();

	

	
	
//	FROM Account  WHERE username = :u AND password = :p

//
//
//
//	@Query("UPDATE Account SET password = :matkhau where username = :ma")
//	Object doiMatKhau(String username, String password);
//
//	void update(Account account);



	

} 

package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.entitys.Cart;


@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer>{

//	@Query("SELECT e FROM Cart e WHERE e.username LIKE :username")
//	List<Cart> getCartByUsername(@Param("username") String username);
	
	@Query("Select e from Cart e where e.username.username = :user")
	List<Cart> giohang(@Param("user") String username);
	@Query("Select e from Cart e where e.username.username = :user and product.id = :id and kichThuoc like :kt")
	Cart getByID(@Param("user") String username,@Param("id") Integer id , @Param("kt") String kt);
	@Query("Delete from Cart e where e.username.username = :user")
	void deleteCartbyUsername(@Param("user") String username);

//	Cart getById(String username, Integer idProduct, Integer kichThuoc);


//	@Query("Update Cart set soLuong = :soluong where username.username = :id and product.id =:idPro and kichThuoc =:kichThuoc")
//	void updateCart(String username, Integer id, String kichThuoc);

//	Cart getById(String username, Integer id, String kichThuoc);

//	Cart getCartByUsername(@Param("username") String username);
//	@Query("From Cart where username.username = :user and product.id = :id and kichThuoc = :kichThuoc")
	
}

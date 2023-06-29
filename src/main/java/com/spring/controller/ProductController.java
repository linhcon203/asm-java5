package com.spring.controller;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.bean.ProductForm;
import com.spring.entitys.Category;
import com.spring.entitys.Product;
import com.spring.repository.ICategoryRepository;
import com.spring.repository.IProductRepository;


@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired
	private IProductRepository productRepository;
	
	@Autowired 
	private ICategoryRepository categoryRepository;
	
	@Autowired
	@Value("${upload.path}")	
	private String pathFolder;

	
	@GetMapping("/products")
	public String QLProduct(Model model ,@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
		Integer pageSize = 8;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		List<Product> list = productRepository.phantrang(pageable).getContent();
		List<Product> count = productRepository.countPhanTrang();
		model.addAttribute("listProduct", list);
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);
		return "adminProduct";
	}
	
	@GetMapping("/add")
	public String showAddProduct(Model model) {
		model.addAttribute("data", new ProductForm());
		List<Category> categories = categoryRepository.countPhanTrang();
		model.addAttribute("list",categories); 
		return"adminProductAdd";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateProduct(Model model, @PathVariable("id")Integer id) {
		model.addAttribute("data", new ProductForm());
		List<Category> categories = categoryRepository.countPhanTrang();
		model.addAttribute("list",categories);
		Product product = productRepository.getById(id);
		model.addAttribute("product", product);
		return"adminProductUpdate";
	}
	
	

	@PostMapping("/add")
	public String addProduct(Model model, RedirectAttributes redirect,
			@Valid @ModelAttribute("data") ProductForm form,BindingResult result , @RequestParam(name = "anh") MultipartFile file
			) {
		if (result.hasErrors()) {
			return"adminProductAdd";
		}
		
		try {
			
			if (!file.isEmpty()) {
				byte[] bytes;
				bytes = file.getBytes();
				Path path = Paths.get(pathFolder + file.getOriginalFilename());
				Files.write(path, bytes);
				String tieuDe = form.getTieuDe();
				String moTa = form.getMoTa();
				String anh = file.getOriginalFilename();
				BigDecimal gia = form.getGia();
				Integer giamGia = form.getGiamGia();
				Integer soLuong = form.getSoLuong();
				Integer phanLoai = form.getPhanLoai();
				String kichThuoc = form.getKichThuoc();
				String chatLieu = form.getChatLieu();
				String thietKe = form.getThietKe();
				
				Product product = new Product();
				Category cate = categoryRepository.getById(phanLoai);
				product.setTieuDe(tieuDe);
				product.setMoTa(moTa);
				product.setAnh(anh);
				product.setGia(gia);
				product.setGiamGia(giamGia);
				product.setSoLuong(soLuong);
				product.setCategory(cate);
				product.setKichThuoc(kichThuoc);
				product.setChatLieu(chatLieu);
				product.setThietKe(thietKe);
				product.setTrangThai(0);
				productRepository.save(product);
				redirect.addFlashAttribute("message", "Add Product thành công!");
				redirect.addFlashAttribute("type", "success");
				return "redirect:/admin/products";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return"adminProductAdd";
	}
	
	@PostMapping("/update")
	public String UpdateProduct(Model model, RedirectAttributes redirect,
			@Valid @ModelAttribute("data") ProductForm form, @RequestParam(name = "anh") MultipartFile file,
			BindingResult result) {
		try {
			Product product = productRepository.getById(form.getId());
			String anh = "";
			if (file.isEmpty()) {
				anh = product.getAnh();
			}
			else {
				byte[] bytes;
				bytes = file.getBytes();
				Path path = Paths.get(pathFolder + file.getOriginalFilename());
				Files.write(path, bytes);
				 anh = file.getOriginalFilename();
			}
				String tieuDe = form.getTieuDe();
				String moTa = form.getMoTa();
				BigDecimal gia = form.getGia();
				Integer giamGia = form.getGiamGia();
				Integer soLuong = form.getSoLuong();
				Integer phanLoai = form.getPhanLoai();
				String kichThuoc = form.getKichThuoc();
				String chatLieu = form.getChatLieu();
				String thietKe = form.getThietKe();
				
				
				Category cate = categoryRepository.getById(phanLoai);
				product.setTieuDe(tieuDe);
				product.setMoTa(moTa);
				product.setAnh(anh);
				product.setGia(gia);
				product.setGiamGia(giamGia);
				product.setSoLuong(soLuong);
				product.setCategory(cate);
				product.setKichThuoc(kichThuoc);
				product.setChatLieu(chatLieu);
				product.setThietKe(thietKe);
				product.setTrangThai(0);
				
				productRepository.save(product);
				redirect.addFlashAttribute("message", "Update Product thành công!");
				redirect.addFlashAttribute("type", "success");
				return"redirect:/admin/products";
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return"adminProductUpdate";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(Model model ,RedirectAttributes redirect, @PathVariable("id") Integer id) {
		Product p = productRepository.getById(id);
		p.setTrangThai(1);
		productRepository.save(p);
		redirect.addFlashAttribute("message", "Xóa Product thành công!");
		redirect.addFlashAttribute("type", "success");
		return"redirect:/admin/products";
	}

}

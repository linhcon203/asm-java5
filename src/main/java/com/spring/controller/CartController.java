package com.spring.controller;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.bean.ThanhToanForm;
import com.spring.entitys.Account;
import com.spring.entitys.Cart;
import com.spring.entitys.HoaDon;
import com.spring.entitys.HoaDonChiTiet;
import com.spring.entitys.Product;
import com.spring.repository.IAccountRepository;
import com.spring.repository.IProductRepository;
import com.spring.service.CartService;
import com.spring.service.HoaDonChiTietService;
import com.spring.service.HoaDonService;

@Controller
@RequestMapping("/cart")
public class CartController {

	
	@Autowired
	IAccountRepository accountRepository;
	
	@Autowired
	IProductRepository productRepository;
	
	@Autowired
	private CartService service;
	
	@Autowired
	private HoaDonService hoaDonService;
	
	@Autowired
	private HoaDonChiTietService hoaDonChiTietService;
	
	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest req;
	
	@GetMapping(value = {"/" , "/index",""})
	public String indexC(Model model) {
		Account account = (Account) session.getAttribute("account");
		List<Cart> list = service.getCartbyUser(account.getUsername());
		Double tongTien = 0.0;
		for (Cart cart : list) {
			String tien = String.valueOf(cart.getDonGia());
			tongTien += (cart.getSoLuong() * Double.valueOf(tien));
		}
		model.addAttribute("tongTien", tongTien);
		model.addAttribute("listCart", list);
		model.addAttribute("gioHang", new ThanhToanForm());
		return "cartPage";
	}
	@GetMapping(value = "/thanhtoan")
	public String cartPage(Model model) {
		Account account = (Account) session.getAttribute("account");
		List<Cart> list = service.getCartbyUser(account.getUsername());
		Double tongTien = 0.0;
		for (Cart cart : list) {
			String tien = String.valueOf(cart.getDonGia());
			tongTien += (cart.getSoLuong() * Double.valueOf(tien));
		}
		model.addAttribute("tongTien", tongTien);
		model.addAttribute("listCart", list);
		model.addAttribute("gioHang", new ThanhToanForm());
		return "cartPage";
	}
		
	@GetMapping("/giam")
	public String giamCart(Model model, RedirectAttributes redirect , @RequestParam(name = "id") Integer id , @RequestParam(name = "kichThuoc") String kichThuoc) {
		
		Account account = (Account) session.getAttribute("account");
		Cart cart = service.getById(account.getUsername() , id , kichThuoc);
		if (cart.getSoLuong() == 1) {
			service.delete(cart);
			return "redirect:/cart";
		}
		cart.setSoLuong(cart.getSoLuong() - 1);
		service.update(cart);
		
		return "redirect:/cart";
	}
	@GetMapping("/them")
	public String themCart(Model model , RedirectAttributes redirect, @RequestParam(name = "id") Integer id , @RequestParam(name = "kichThuoc") String kichThuoc) {
		
		Account account = (Account) session.getAttribute("account");
		Cart cart = service.getById(account.getUsername() , id , kichThuoc);
//		Product product = productRepository.getById(id);
//		if (product.getSoLuong() == 0) {
//			service.delete(cart);
//			return "redirect:/cart";
//		}
		cart.setSoLuong(cart.getSoLuong() +1);
		service.update(cart);
		
		return "redirect:/cart";
	}
	@GetMapping("/delete")
	public String deleteCart(Model model , @RequestParam(name = "id") Integer id , @RequestParam(name = "kichThuoc") String kichThuoc, RedirectAttributes redirect) {
		
		Account account = (Account) session.getAttribute("account");
		Cart cart = service.getById(account.getUsername() , id , kichThuoc);

		cart.setSoLuong(cart.getSoLuong() +1);
		service.delete(cart);
		redirect.addFlashAttribute("message", "Xóa thành công khỏi giỏ hàng !");
		redirect.addFlashAttribute("type", "success");
		return "redirect:/cart";
	}
	
	@PostMapping("/thanhtoan")
	public String thanhToanCart(Model model , RedirectAttributes redirect, @Valid @ModelAttribute("gioHang") ThanhToanForm form , BindingResult result ) {
		Account account = (Account) session.getAttribute("account");
		List<Cart> list = service.getCartbyUser(account.getUsername());
		Double tongTien = 0.0;
		for (Cart cart : list) {
			String tien = String.valueOf(cart.getDonGia());
			tongTien += (cart.getSoLuong() * Double.valueOf(tien));
		}
		model.addAttribute("tongTien", tongTien);
		model.addAttribute("listCart", list);
		
		if (result.hasErrors()) {
			return"cartPage";
		}
		
		List<Cart> cart = service.getCartbyUser(account.getUsername());
		if (cart.isEmpty()) {
			redirect.addFlashAttribute("message", "Giỏ hàng của bạn chưa có gì!");
			redirect.addFlashAttribute("type", "error");
			return"cartPage";
		}
		if (!result.hasErrors()) {
			HoaDon hoaDon = new HoaDon();
			
			hoaDon.setUsername(account);
			hoaDon.setTrangThai(0);
			hoaDon.setNguoiNhan(form.getTennguoinhan());
			hoaDon.setDiaChi(form.getDiachi());
			hoaDon.setSoDienThoai(form.getSdt());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			ZonedDateTime now = ZonedDateTime.now();
			String date = dtf.format(now);
			hoaDon.setNgayTao(date);
		
			hoaDonService.add(hoaDon);
			
			for (Cart cart2 : cart) {
				
				HoaDonChiTiet hdct = new HoaDonChiTiet();
				hdct.setHoaDon(hoaDon);
				hdct.setProduct(cart2.getProduct());
				hdct.setDonGia(cart2.getDonGia());
				hdct.setSoLuong(cart2.getSoLuong());
				hdct.setKichThuoc(cart2.getKichThuoc());
				hoaDonChiTietService.add(hdct);
				service.delete(cart2);
			}
			redirect.addFlashAttribute("message", "Đặt hàng thành công !");
			redirect.addFlashAttribute("type", "success");
			return"redirect:/cart";
		}
		return"cartPage";
	}
	
}
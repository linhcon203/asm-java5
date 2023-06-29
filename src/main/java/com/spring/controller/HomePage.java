package com.spring.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.bean.CartForm;
import com.spring.bean.ChangeForm;
import com.spring.bean.LoginForm;
import com.spring.bean.RegisterForm;
import com.spring.entitys.Account;
import com.spring.entitys.Cart;
import com.spring.entitys.Category;
import com.spring.entitys.Product;
import com.spring.repository.IAccountRepository;
import com.spring.repository.ICartRepository;
import com.spring.repository.ICategoryRepository;
import com.spring.repository.IProductRepository;
import com.spring.service.CartService;
import com.spring.service.HoaDonChiTietService;
import com.spring.service.HoaDonService;

@Controller
public class HomePage {

	@Autowired
	private IAccountRepository accountRepository;

	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private ICategoryRepository categoryRepository;
	
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
	
	@Autowired
	HttpServletResponse resp;

	@RequestMapping(value = {"" ,"/","/index" })
	public String HomePage(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
		Integer pageSize = 8;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		List<Product> list = productRepository.phantrang(pageable).getContent();
		List<Product> count = productRepository.countPhanTrang();
		model.addAttribute("listProduct", list);
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);
		return "homePage";
	}

	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("lo", new LoginForm());
		return "loginPage";
	}

	
	@GetMapping("/logout")
	public String showLogout(Model model, RedirectAttributes attributes) {
//		session.removeAttribute("account");
		session.invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("/403")
	public String Page403() {
		return"403";
	}

	@GetMapping("/product")
	public String showProduct(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
		Integer pageSize = 8;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		List<Product> list = productRepository.phantrang(pageable).getContent();
		List<Product> count = productRepository.countPhanTrang();
		model.addAttribute("listProduct", list);
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);
		List<Category> categories = categoryRepository.countPhanTrang();
		model.addAttribute("listCategory", categories);
		return "productPage";
	}
	
	@GetMapping("/product/{id}")
	public String showProductCate(Model model,@PathVariable("id") Integer id, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
		Integer pageSize = 8;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		List<Product> list = productRepository.phantrangCategory(pageable ,id).getContent();
		List<Product> count = productRepository.countPhanTrangCategory(id);
		model.addAttribute("listProduct", list);
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);
		List<Category> categories = categoryRepository.countPhanTrang();
		model.addAttribute("listCategory", categories);
		return "productPage";
	}

	@GetMapping("/info")
	public String showInfo(Model model) {
		return "about";
	}

	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("register", new RegisterForm());
		return "registerPage";
	}

	@PostMapping("/register")
	public String addRegister(Model model, RedirectAttributes redirect,
			@Valid @ModelAttribute("register") RegisterForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			return "registerPage";
		}
		if (!result.hasErrors()) {
			if (accountRepository.getByUsername(form.getUsername()) != null) {
//				req.setAttribute("username", username);
				req.setAttribute("message", "Username đã tồn tại trên hệ thống !");
				req.setAttribute("type", "error");
				return "registerPage";
			}
			if (!form.getPassword().equals(form.getRepass())) {
				
				req.setAttribute("message", "Pass và Repass chưa khớp !");
				req.setAttribute("type", "error");
				return "registerPage";
			}
			if (req.getParameter("checkbox") == null) {
				req.setAttribute("message", "Vui lòng đồng ý với điều khoản trước khi đăng ký !");
				req.setAttribute("type", "error");
				return "registerPage";
			}
			String username = form.getUsername();
			String password = form.getPassword();
			String repass = form.getRepass();
			String email = form.getEmail();
			Account account = new Account();

			account.setUsername(username);
			account.setPassword(password);
			account.setEmail(email);
			account.setRole(1);
			account.setTrangThai(0);

			if (accountRepository.save(account) != null) {

				redirect.addFlashAttribute("message" , "Đăng ký thành công !");
				redirect.addFlashAttribute("type", "success");
				return "redirect:/register";
			}

		}
		return "registerPage";

	}

	@GetMapping("/forget")
	public String showForget(Model model) {
		
		return "forgetPage";
	}
//	@GetMapping("/cart")
//	public String showCart(Model model) {
//		
//		return "cartPage";
//	}

	@GetMapping("/change")
	public String showChange(Model model, RedirectAttributes redirect , @Valid @ModelAttribute("change") ChangeForm form , BindingResult result) {
//		if (!result.hasErrors()) {
//			Account account = (Account) session.getAttribute("account");
//			if (accountRepository.doiMatKhau(account.getUsername() , form.getPasscu()) == null) {
//				req.setAttribute("message", "Mật khẩu cũ chưa chính xác !");
//				req.setAttribute("type", "error");
//			}
//			if (!form.getPassmoi().equals(form.getRepassmoi())) {
//				req.setAttribute("message", "Password và Repassword chưa chính xác !");
//				req.setAttribute("type", "error");
//			}
//			account.setPassword(form.getPassmoi());
//			accountRepository.update(account);
//			redirect.addFlashAttribute("message", "Đổi mật khẩu thành công !");
//			redirect.addFlashAttribute("type", "success");
//			return "redirect:/change";
//		}
		return "changePage";
	}

	@PostMapping("/login")
	public String checkLogin(@Valid @ModelAttribute("lo") LoginForm form, BindingResult result, HttpSession session,
			Model model) {
		String username = form.getUsername();
		String password = form.getPassword();

		if (!result.hasErrors()) {
			Account account = accountRepository.getByUsername(username);
			if (account == null) {
				System.out.println("false");
				return "login";
			}
			if (account.getPassword().equals(password)) {
				session.setAttribute("account", account);
				System.out.println("oke");
				return "redirect:/index";
			}
			model.addAttribute("message", "Username or Password incorrect");
		}
		return "loginPage";
	}

	@GetMapping("/detail/{id}")
	public String detailProduct(Model model, @PathVariable("id") Integer id) {
		Product product = productRepository.getById(id);
		model.addAttribute("p", product);
		return "detailPage";
	}
	
	@PostMapping("/detail/{id}")
	public String detailCart(Model model , @ModelAttribute(name = "gioHang") CartForm form ,  RedirectAttributes redirect ,
			 BindingResult result ) {
		Account account =  accountRepository.getByUsername(form.getUsername());
		if (account == null) {
			redirect.addFlashAttribute("message", "Vui lòng đăng nhập trước khi vào giỏ hàng!");
			redirect.addFlashAttribute("type", "error");
			
			return"redirect:/detail/{id}";
		}
		if (form.getKichThuoc() == null) {
			redirect.addFlashAttribute("message", "Vui lòng chọn size trước khi thêm vào giỏ hàng!");
			redirect.addFlashAttribute("type", "error");
			return"redirect:/detail/{id}";
		}

		if (!result.hasErrors()) {
//			Account account2 = accountRepository.getByUsername(form.getUsername());
			Product product = productRepository.getById(form.getId());
			String kichThuoc = req.getParameter("kichThuoc");
			BigDecimal donGia = productRepository.getById(form.getIdProduct()).getGia();
			Cart cart = service.getById(account.getUsername(), form.getIdProduct(), form.getKichThuoc());
			if (cart == null) {
				Cart cart2 = new Cart();
				cart2.setUsername(account);
				cart2.setProduct(product);
				cart2.setKichThuoc(kichThuoc);
				cart2.setDonGia(donGia);
				cart2.setSoLuong(1);
			if (service.add(cart2) != null) {
				redirect.addFlashAttribute("message", "Thêm thành công vào giỏ hàng!");
				redirect.addFlashAttribute("type", "success");
				return"redirect:/detail/{id}";
			}
		}
			else {
				cart.setSoLuong(cart.getSoLuong() + 1);
				if (service.update(cart) != null) {
					redirect.addFlashAttribute("message", "Thêm thành công vào giỏ hàng!");
					redirect.addFlashAttribute("type", "success");
					return"redirect:/detail/{id}";
				}
			}
		}
	
		return"detailPage";
	}

}

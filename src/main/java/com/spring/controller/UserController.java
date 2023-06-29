package com.spring.controller;

import java.util.List;

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

import com.spring.bean.AccountForm;
import com.spring.entitys.Account;
import com.spring.repository.IAccountRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IAccountRepository accountRepository;

	@GetMapping("/user")
	public String showUser(Model model ,@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
		Integer pageSize = 5;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		List<Account> list = accountRepository.phantrang(pageable).getContent();
		List<Account> count = accountRepository.countPhanTrang();
		model.addAttribute("listAccount", list);
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);
//		List<Account> accounts = accountRepository.findAll();
//		model.addAttribute("listAccount", accounts);
		return "UserPage";
	}

	@GetMapping("/add")
	public String showAddUser(Model model) {
		model.addAttribute("user", new AccountForm());
		List<Account> accounts = accountRepository.findAll();
		model.addAttribute("listAccount", accounts);
		return "UserPageAdd";
	}

	@GetMapping("/update/{username}")
	public String showAddUsers(Model model, @PathVariable("username") String username) {
		model.addAttribute("user", new AccountForm());
		Account account = accountRepository.getByUsername(username);
		model.addAttribute("user", account);
		return "UserPageUpdate";
	}

	@PostMapping("/add")
	public String saveUsers(Model model, RedirectAttributes redirect, @Valid @ModelAttribute("user") AccountForm form, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "UserPageAdd";
		}

		if (!result.hasErrors()) {

			String username = form.getUsername();
			String password = form.getPassword();
			String email = form.getEmail();
			Integer role = form.getRole();

			Account account1 = new Account();
			account1.setUsername(username);
			account1.setPassword(password);
			account1.setEmail(email);
			account1.setRole(role);
			account1.setTrangThai(0);

			accountRepository.save(account1);
			redirect.addFlashAttribute("message", "Add User thành công!");
			redirect.addFlashAttribute("type", "success");
			return "redirect:/users/user";
		}
		return "UserPageAdd";
	}

	@PostMapping("/update")
	public String updateUsers(Model model, RedirectAttributes redirect, @ModelAttribute("user") AccountForm form,
			BindingResult result) {
		if (result.hasErrors()) {
			return"UserPageUpdate";
		}
		if (!result.hasErrors()) {
			String username = form.getUsername();
			String password = form.getPassword();
			String email = form.getEmail();
			Integer role = form.getRole();

			Account account = accountRepository.getByUsername(username);
			account.setPassword(password);
			account.setEmail(email);
			account.setRole(role);
			account.setTrangThai(0);

			accountRepository.save(account);
			redirect.addFlashAttribute("message", "Update User thành công!");
			redirect.addFlashAttribute("type", "success");
			return "redirect:/users/user";
		}
		return"UserPageUpdate";

	

	}

	@GetMapping("/delete/{username}")
	public String deleteUser(Model model,RedirectAttributes redirect, @PathVariable("username") String username) {
		Account account = accountRepository.getByUsername(username);
		account.setTrangThai(1);
		accountRepository.save(account);
		redirect.addFlashAttribute("message", "Xóa User thành công!");
		redirect.addFlashAttribute("type", "success");
		return "redirect:/users/user";
	}

}

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

import com.spring.bean.CategoryForm;
import com.spring.entitys.Category;
import com.spring.repository.ICategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICategoryRepository categoryRepository;

	@GetMapping("/categorys")
	public String showCategory(Model model ,@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
		Integer pageSize = 5;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		List<Category> list = categoryRepository.phantrang(pageable).getContent();
		List<Category> count = categoryRepository.countPhanTrang();
		model.addAttribute("listCategory", list);
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);

		return "CategoryPage";
	}

	@GetMapping("/add")
	public String showAddCategory(Model model) {
		model.addAttribute("cate", new CategoryForm());
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("listCategory", categories);
		return "CategoryPageAdd";
	}

	@GetMapping("/update/{id}")
	public String UpdateCategory(Model model , RedirectAttributes redirect, @PathVariable("id") Integer id) {
		model.addAttribute("cate", new CategoryForm());
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("listCategory", categories);
		Category category = categoryRepository.getById(id);
		model.addAttribute("cate", category);
		return "CategoryPageUpdate";
	}

	@PostMapping("/add")
	public String addCategory(Model model, RedirectAttributes redirect,
			@Valid @ModelAttribute("cate") CategoryForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "CategoryPageAdd";
		}
		if (!result.hasErrors()) {
			String ten = form.getTen();
			Category category = new Category();
			category.setTen(ten);
			category.setTrangThai(0);
			categoryRepository.save(category);
			redirect.addFlashAttribute("message", "Add Category thành công!");
			redirect.addFlashAttribute("type", "success");
			return "redirect:/category/categorys";
		}
		return "CategoryPageAdd";
	}

	@PostMapping("/update")
	public String UpdateCategory(Model model, RedirectAttributes redirect,
			@Valid @ModelAttribute("cate") CategoryForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "CategoryPageUpdate";
		}
		String ten = form.getTen();
		Category category = categoryRepository.getById(form.getId());
		category.setTen(ten);
		category.setTrangThai(0);
		categoryRepository.save(category);
		redirect.addFlashAttribute("message", "Update Category thành công!");
		redirect.addFlashAttribute("type", "success");
		return "redirect:/category/categorys";
	}

	@GetMapping("/delete/{id}")
	public String deleteCategory(Model model, RedirectAttributes redirect, @PathVariable("id") Integer id) {
		Category category = categoryRepository.getById(id);
		category.setTrangThai(1);
		categoryRepository.save(category);
		redirect.addFlashAttribute("message", "Xóa Category thành công!");
		redirect.addFlashAttribute("type", "success");
		return "redirect:/category/categorys";
	}

}

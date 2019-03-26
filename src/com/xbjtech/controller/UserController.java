package com.xbjtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.xbjtech.model.User;
import com.xbjtech.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@PutMapping("/put")
	public String doPut() {
		System.out.println("doPUT");
		return "hello";
	}
	
	/**
	 * 新增
	 */
	@PostMapping("/user")
	public String insert(User user) {
		userService.insertUser(user);
		return "redirect:/users";
	}
	
	/**
	 * 列表
	 * @return
	 */
	@GetMapping("/users")
	public String list(Model model) {
		List<User> list = userService.list();
		model.addAttribute("list", list);
		return "user/list";
	}
	
	@PutMapping("/user")
	public String update(User user) {
		userService.updateUser(user);
		return "redirect:/users";
	}
	
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable Long id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
	
	@GetMapping("/user/add")
	public String addPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user/add";
	}
	
	@GetMapping("/user/edit/{id}")
	public String editPage(@PathVariable Long id, Model model) {
		User user = userService.selectById(id);
		model.addAttribute("user", user);
		return "user/update";
	}

}

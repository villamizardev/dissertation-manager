package com.disseration.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.disseration.app.service.ProfilesServiceJpa;

@Controller
public class HomeController {
	@Autowired
	ProfilesServiceJpa profilesServiceJpa;
	
	@GetMapping("/")
	public String form(Model model) {
		return "projects/projectOptions.html";
	}
	
	@GetMapping("/login")
	public String home(Model model) {
		return "users/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/login";
	}
}
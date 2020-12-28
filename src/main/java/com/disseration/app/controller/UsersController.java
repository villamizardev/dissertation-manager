package com.disseration.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.disseration.app.model.Profile;
import com.disseration.app.model.User;
import com.disseration.app.service.IUsersService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsersController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IUsersService usersService;

	@GetMapping("/registrarme")
	public String registrar() {
		return "users/registerForm";
	}

	@GetMapping("/iniciar-sesion")
	public String iniciarSesion() {
		return "users/login";
	}

	@GetMapping("/lista")
	public String todos(Model model) {
		model.addAttribute("usuarios", usersService.findAllUsers());
		return "users/userList";
	}

	@PostMapping("/guardar")
	public String save(User user, BindingResult result, RedirectAttributes redirectAttributes) {
		try {
			String pwdPlano = user.getPassword();
			String pwdEncriptado = passwordEncoder.encode(pwdPlano);
			user.setPassword(pwdEncriptado);
			Profile profile = new Profile();
			profile.setId(user.getSetProfile());
			user.agregar(profile);
			user.setStatus(1);
			usersService.save(user);
			redirectAttributes.addFlashAttribute("msg", "Guardado Exitosamente");
			return "redirect:/usuarios/lista";
		} catch (Exception e) {
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("msg", "Error. Inténtelo nuevamente.");
		return "redirect:/usuarios/lista";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable("id") int userID) {
		usersService.deleteByUserID(userID);
		return "redirect:/usuarios/lista";
	}

}

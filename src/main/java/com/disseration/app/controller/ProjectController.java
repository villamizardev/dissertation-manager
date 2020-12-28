package com.disseration.app.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.disseration.app.model.Correction;
import com.disseration.app.model.Project;
import com.disseration.app.model.User;
import com.disseration.app.service.IProjectsService;
import com.disseration.app.service.IUsersService;
import com.disseration.app.util.StripHTML;

@Controller
@RequestMapping(value = "/proyectos")
public class ProjectController {

	@Autowired
	IProjectsService projectsService;

	@Autowired
	IUsersService userService;
	
	@GetMapping("/detalles/{id}")
	public String details(@PathVariable("id") int idProject, Model model) {
		Project project = projectsService.findProjectByID(idProject);
		List<User> allJuries = userService.findAllTeachers();
		model.addAttribute("project", project);
		model.addAttribute("jury", allJuries);
		return "projects/projectNew";
	}
	
	@GetMapping("/todos-los-proyectos")
	public String allProjects(Model model) {
		List<Project> allProjects = projectsService.allProjects();
		List<Project> cleanProjects = new ArrayList<Project>();;
		
		if (!allProjects.isEmpty()) {
			for (Project project : allProjects) {
				project.setTitle(StripHTML.strip(project.getTitle()));
				cleanProjects.add(project);
			}
			model.addAttribute("allProjects", cleanProjects);
		}
		
		return "projects/projectList";
	}
	
	@GetMapping("/opciones")
	public String options() {
		return "projects/projectOptions";
	}

	@GetMapping("/nuevo-proyecto")
	public String newProject(Principal principal, Model model) {
		User user = userService.findUserByUsername(principal.getName());
		if (user.getId_project() != null) {
			Project project = projectsService.findProjectByID(user.getId_project().getId());
			model.addAttribute("project", project);
			model.addAttribute("id", project.getId());
			
			model.addAttribute("corrections", new Correction());

			System.out.println(project.getTitle());
			System.out.println(project.getId());
		} else {
			Project project = new Project();
			model.addAttribute("project", project);
		}

		return "projects/projectNew";
	}

	@PostMapping("/guardar")
	public String save(Project project, BindingResult result, RedirectAttributes redirectAttributes, Principal principal) {
		try {			
			if (project.getTitle() != "") {
				
				
				if((projectsService.countByTitle(project.getTitle()) > 0) && (projectsService.findProjectByTitle(project.getTitle()).getId() != project.getId())) {
					redirectAttributes.addFlashAttribute("error", "ERROR: El proyecto ya existe");
					return "redirect:/proyectos/nuevo-proyecto";
				}
				
				projectsService.saveProject(project);
				Project objProject = projectsService.findProjectByTitle(project.getTitle());
				User objUser = userService.findUserByUsername(principal.getName());
				objUser.setId_project(objProject);
				userService.save(objUser);
				redirectAttributes.addFlashAttribute("ok", "Proyecto enviado a revisión");
			} else {
				redirectAttributes.addFlashAttribute("error", "ERROR: Sin el título del proyecto no es posible enviar a revisión");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "ERROR: Inténtelo más tarde");
		}

		return "redirect:/proyectos/nuevo-proyecto";
	}
}

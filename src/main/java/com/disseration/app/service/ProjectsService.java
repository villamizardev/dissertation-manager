package com.disseration.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disseration.app.model.Project;
import com.disseration.app.repository.ProjectsRepository;

@Service
public class ProjectsService implements IProjectsService{
	
	@Autowired
	ProjectsRepository projectRepository;

	@Override
	public List<Project> allProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project findProjectByID(Integer projectID) {
		Optional<Project> optional = projectRepository.findById(projectID);
		return optional.get();
	}

	@Override
	public Project saveProject(Project project) {
		projectRepository.save(project);
		return project;
	}

	@Override
	public Project findProjectByTitle(String title) {		 
		return projectRepository.findByTitle(title);
	}

	@Override
	public Integer countByTitle(String title) {
		return projectRepository.countByTitle(title);
	}

}

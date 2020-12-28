package com.disseration.app.service;

import java.util.List;

import com.disseration.app.model.Project;

public interface IProjectsService {
	public List<Project> allProjects();
	public Project findProjectByID(Integer projectID);
	public Project saveProject(Project project);
	public Project findProjectByTitle(String title);
	public Integer countByTitle(String title);
}

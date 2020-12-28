package com.disseration.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disseration.app.model.Project;

public interface ProjectsRepository extends JpaRepository<Project, Integer> {
	public Project findByTitle(String title);
	public Integer countByTitle(String title);
}

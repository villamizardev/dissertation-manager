package com.disseration.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "corrections")
public class Correction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String problem;
	private String justification;
	private String general_aim;
	private String specific_aim;
	private String hypothesis;
	private String theory;
	private String methodology;
	private String schedule;
	private String budget;
	private String bibliography;
	private String annexes;
	@OneToOne
	@JoinColumn(name = "id_project")
	private Project id_project;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getGeneral_aim() {
		return general_aim;
	}

	public void setGeneral_aim(String general_aim) {
		this.general_aim = general_aim;
	}

	public String getSpecific_aim() {
		return specific_aim;
	}

	public void setSpecific_aim(String specific_aim) {
		this.specific_aim = specific_aim;
	}

	public String getHypothesis() {
		return hypothesis;
	}

	public void setHypothesis(String hypothesis) {
		this.hypothesis = hypothesis;
	}

	public String getTheory() {
		return theory;
	}

	public void setTheory(String theory) {
		this.theory = theory;
	}

	public String getMethodology() {
		return methodology;
	}

	public void setMethodology(String methodology) {
		this.methodology = methodology;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getBibliography() {
		return bibliography;
	}

	public void setBibliography(String bibliography) {
		this.bibliography = bibliography;
	}

	public String getAnnexes() {
		return annexes;
	}

	public void setAnnexes(String annexes) {
		this.annexes = annexes;
	}

	public Project getId_project() {
		return id_project;
	}

	public void setId_project(Project id_project) {
		this.id_project = id_project;
	}

	@Override
	public String toString() {
		return "Correction [id=" + id + ", title=" + title + ", problem=" + problem + ", justification=" + justification
				+ ", general_aim=" + general_aim + ", specific_aim=" + specific_aim + ", hypothesis=" + hypothesis
				+ ", theory=" + theory + ", methodology=" + methodology + ", schedule=" + schedule + ", budget="
				+ budget + ", bibliography=" + bibliography + ", annexes=" + annexes + ", id_project=" + id_project
				+ "]";
	}
}

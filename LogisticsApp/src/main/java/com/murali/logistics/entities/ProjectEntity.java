package com.murali.logistics.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProjectEntity {
	
	
	@Id
	private int projectId;
	private String projectName;
	private String projectOwner;
	private BigDecimal projectDuration;
	private int projectCost;
	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectOwner() {
		return projectOwner;
	}
	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}
	public BigDecimal getProjectDuration() {
		return projectDuration;
	}
	public void setProjectDuration(BigDecimal projectDuration) {
		this.projectDuration = projectDuration;
	}
	public int getProjectCost() {
		return projectCost;
	}
	public void setProjectCost(int projectCost) {
		this.projectCost = projectCost;
	}
	
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectOwner=" + projectOwner
				+ ", projectDuration=" + projectDuration + ", projectCost=" + projectCost + "]";
	}

}

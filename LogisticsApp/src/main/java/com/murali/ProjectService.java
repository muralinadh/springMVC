package com.murali;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.logistics.dao.ProjectDAO;
import com.murali.logistics.entities.ProjectEntity;
import com.murali.logistics.model.*;


@Service
public class ProjectService {
	
	@Autowired
	ProjectDAO projectDAO;
	
	public boolean saveProject(Project project) {
		
		ProjectEntity pe = new ProjectEntity();
		pe.setProjectId(project.getProjectId());
		pe.setProjectName(project.getProjectName());
		pe.setProjectOwner(project.getProjectOwner());
		pe.setProjectDuration(project.getProjectDuration());
		pe.setProjectCost(project.getProjectCost());
		
		projectDAO.saveProject(pe);
		
		return true;
		
	}
	
public boolean deleteProject(int projectId) {
		
		return true;
		
	}
	
	public Project getProject(int projectId){
		return null;
	}
	
	public List<Project> getAllProjects() {
		return null;
	}
}

/*
List<Logistics> logisticCollection = new ArrayList<Logistics >();
	
	public ProjectService(){
		
		Logistics l1 = new Logistics(101, "Hathway", 23.4f);
		Logistics l2 = new Logistics(102, "FedEx", 232.4f);
		Logistics l3 = new Logistics(103, "Passage", 13.4f);
		
		logisticCollection.add(l1);
		logisticCollection.add(l2);
		logisticCollection.add(l3);
		
	}
	
	public List<Logistics> getAllLogistics(){
		return logisticCollection;
	}
 */
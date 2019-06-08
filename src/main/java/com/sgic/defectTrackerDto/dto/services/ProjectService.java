package com.sgic.defectTrackerDto.dto.services;

import java.util.List;

import com.sgic.defectTrackerDto.dto.entities.Project;

public interface ProjectService {
	
	Project saveProject(Project project);

	List<Project> getProjects();
	
	Project getProjectById(int projectId);
	
	void deleteProjectById(int projectId);
	
	Project updateProject(Project project);
}



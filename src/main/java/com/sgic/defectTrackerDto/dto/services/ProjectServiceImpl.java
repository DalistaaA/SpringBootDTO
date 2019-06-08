package com.sgic.defectTrackerDto.dto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.defectTrackerDto.dto.entities.Project;
import com.sgic.defectTrackerDto.dto.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public List<Project> getProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(int projectId) {
		return projectRepository.findProjectByProjectId(projectId);
	}

	@Override
	public void deleteProjectById(int projectId) {
		projectRepository.deleteById(projectId);
		
	}

	@Override
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}

//	@Override
//	public Project updateProject(Project project) {
//		int projectId = project.getProjectId();
//		boolean isExist = projectRepository.findProjectByProjectId(projectId) !=null;
//		if(isExist) {
//			return projectRepository.save(project);
//		}
//	}

	

}

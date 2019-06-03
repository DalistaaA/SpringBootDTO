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

}

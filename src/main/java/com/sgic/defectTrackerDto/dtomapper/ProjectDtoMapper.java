package com.sgic.defectTrackerDto.dtomapper;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.defectTrackerDto.dto.entities.Project;
import com.sgic.defectTrackerDto.dto.services.ProjectService;
import com.sgic.defectTrackerDto.dtos.ProjectDto;

@Service
public class ProjectDtoMapper {

	@Autowired
	private ProjectService projectService;
	
	ModelMapper modelmapper = new ModelMapper();
	
	PropertyMap<ProjectDto, Project> projectMap = new PropertyMap<ProjectDto, Project>() {
		protected void configure() {
			map().setProjectName(source.getProjectName());
			map().setProjectDescription(source.getProjectDescription());
		}
	};

	@SuppressWarnings("unused")
	private ProjectDtoMapper EntityToDTO(Project project) {
		ProjectDtoMapper projectDTO = modelmapper.map(project, ProjectDtoMapper.class);
		return projectDTO;
	}
	
	
	public Project saveProject(ProjectDto projectDto) {
		TypeMap<ProjectDto, Project> typeMap = modelmapper.getTypeMap(ProjectDto.class, Project.class );
		if(typeMap==null) {
			modelmapper.addMappings(projectMap);
		}
		
		Project project = modelmapper.map(projectDto, Project.class);
		return projectService.saveProject(project);
	}
	
	public List<ProjectDto> getAllProjects(){
		List<Project> project=projectService.getProjects();
		Type listType =new TypeToken<List<ProjectDto>>() {}.getType();
		List<ProjectDto> getpr= new ModelMapper().map(project, listType);
		return getpr;
	}
}

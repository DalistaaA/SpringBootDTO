package com.sgic.defectTrackerDto.dto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.defectTrackerDto.dtomapper.ProjectDtoMapper;
import com.sgic.defectTrackerDto.dtos.ProjectDto;

@RestController
public class ProjectController {

	@Autowired
	private ProjectDtoMapper projectDtoMapper;
	
	@PostMapping("/save")
	public HttpStatus saveProject(@Valid @RequestBody ProjectDto projectDto) {
		projectDtoMapper.saveProject(projectDto);
		return HttpStatus.CREATED;
	}
	
	@GetMapping("/getAllProjects")
	public List<ProjectDto> getProjects(){
		return projectDtoMapper.getAllProjects();
	}
}

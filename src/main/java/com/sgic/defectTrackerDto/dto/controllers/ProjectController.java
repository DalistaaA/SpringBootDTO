package com.sgic.defectTrackerDto.dto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@DeleteMapping("/deleteProjectById/{projectId}")
	public ResponseEntity<ProjectDto> deleteProject(@PathVariable("projectId") int projectId){
		projectDtoMapper.deleteProject(projectId);
		return new ResponseEntity<ProjectDto>(HttpStatus.OK);
		
	}
	
//	@GetMapping("/findProjectById/{projectId}")
//	public ResponseEntity<ProjectDto> getProjectById(@PathVariable("projectId") int projectId) {
//		projectDtoMapper.getOneProject(projectId);
//		return new ResponseEntity<ProjectDto>(HttpStatus.OK);
//	}
	
	@PutMapping("/updateProject")
	public ResponseEntity<ProjectDto> updateProject(@Valid @RequestBody ProjectDto projectDto){
		projectDtoMapper.updateProjects(projectDto);
		return new ResponseEntity<ProjectDto>(projectDto, HttpStatus.NO_CONTENT);
	}
}

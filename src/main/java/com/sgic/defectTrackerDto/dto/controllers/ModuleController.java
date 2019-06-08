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

import com.sgic.defectTrackerDto.dtomapper.ModuleDtoMapper;
import com.sgic.defectTrackerDto.dtos.ModuleDto;
import com.sgic.defectTrackerDto.dtos.ProjectDto;

@RestController
public class ModuleController {

	@Autowired
	private ModuleDtoMapper moduleDtoMapper;
	
	@PostMapping("/savemodule")
	public HttpStatus saveModule(@Valid @RequestBody ModuleDto moduleDto) {
		moduleDtoMapper.saveModules(moduleDto);
		return HttpStatus.CREATED;
	}
	
	@GetMapping("/getAllmodules")
	public List<ModuleDto> getProjects(){
		return moduleDtoMapper.getAllModules();
	}
	
	@DeleteMapping("/deleteModuleById/{moduleId}")
	public ResponseEntity<ModuleDto> deleteModule(@PathVariable("moduleId") int moduleId){
		moduleDtoMapper.deleteModule(moduleId);
		return new ResponseEntity<ModuleDto>(HttpStatus.OK);
		
	}
	
	@PutMapping("/updateModule")
	public ResponseEntity<ModuleDto> updateModule(@Valid @RequestBody ModuleDto moduleDto){
		moduleDtoMapper.updateModuless(moduleDto);
		return new ResponseEntity<ModuleDto>(moduleDto, HttpStatus.NO_CONTENT);
	}
}

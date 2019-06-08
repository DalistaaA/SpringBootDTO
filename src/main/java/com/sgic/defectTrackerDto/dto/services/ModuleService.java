package com.sgic.defectTrackerDto.dto.services;

import java.util.List;

import com.sgic.defectTrackerDto.dto.entities.Module;

public interface ModuleService {

	Module saveModule(Module module);

	List<Module> getModules();
	
	Module getModuleById(int moduleId);
	
	void deleteModuleById(int moduleId);
	
	Module updateModule(Module module);
}

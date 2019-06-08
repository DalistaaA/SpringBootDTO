package com.sgic.defectTrackerDto.dto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.defectTrackerDto.dto.entities.Module;
import com.sgic.defectTrackerDto.dto.repositories.ModuleRepository;

@Service
public class ModuleServiceImpl implements ModuleService{

	@Autowired
	private ModuleRepository moduleRepository;
	
	@Override
	public Module saveModule(Module module) {
		return moduleRepository.save(module);
	}

	@Override
	public List<Module> getModules() {
		return moduleRepository.findAll();
	}

	@Override
	public Module getModuleById(int moduleId) {
		return moduleRepository.findModuleByModuleId(moduleId);
	}

	@Override
	public void deleteModuleById(int moduleId) {
		moduleRepository.deleteById(moduleId);
	}

	@Override
	public Module updateModule(Module module) {
		return moduleRepository.save(module);
	}

}

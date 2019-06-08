package com.sgic.defectTrackerDto.dtomapper;

import java.lang.reflect.Type;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.defectTrackerDto.dto.entities.Module;
import com.sgic.defectTrackerDto.dto.services.ModuleService;
import com.sgic.defectTrackerDto.dtos.ModuleDto;

@Service
public class ModuleDtoMapper {

	@Autowired
	private ModuleService moduleService;
	
	ModelMapper modelmapper = new ModelMapper();
	
//	PropertyMap<ModuleDto, Module> projectMap = new PropertyMap<ModuleDto, Module>() {
//		protected void configure() {
//			map().setModuleName(source.getModuleName());
//			map().getProject().setProjectId(source.getProjectId());
//
//		}
//	};
	
	private ModuleDtoMapper EntityToDTO(Module module) {
		ModuleDtoMapper moduleDto = modelmapper.map(module, ModuleDtoMapper.class);
		return moduleDto;
	}
	
	public Module saveModules(ModuleDto moduleDto) {
		Module module = modelmapper.map(moduleDto, Module.class);
		return moduleService.saveModule(module);
	}
	

	public List<ModuleDto> getAllModules(){
		List<Module> module=moduleService.getModules();
		Type listType =new TypeToken<List<ModuleDto>>() {}.getType();
		List<ModuleDto> getmod= new ModelMapper().map(module, listType);
		return getmod;
	}
	
	public ModuleDto deleteModule(int moduleId) {
		moduleService.deleteModuleById(moduleId);
		return null;
	}
	
	public void updateModuless(ModuleDto moduleDto) {
		Module module = modelmapper.map(moduleDto, Module.class);
		EntityToDTO(moduleService.updateModule(module));
	}
}

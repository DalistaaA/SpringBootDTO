package com.sgic.defectTrackerDto.dto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.defectTrackerDto.dto.entities.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer>{

	Module findModuleByModuleId(int moduleId);
}

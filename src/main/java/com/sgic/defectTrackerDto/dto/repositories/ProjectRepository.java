package com.sgic.defectTrackerDto.dto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.defectTrackerDto.dto.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

	Project findProjectByProjectId(int projectId);
}

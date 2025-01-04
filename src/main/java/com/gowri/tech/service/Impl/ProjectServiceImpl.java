package com.gowri.tech.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowri.tech.entity.Projects;
import com.gowri.tech.repo.ProjectsRepo;
import com.gowri.tech.service.ProjectService;

/**
 * @author -NaveenWodeyar
 * @date -24-Nov-2024
 * @time - 12:25:04 am
 * @location -
 */
@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectsRepo projectsRepo;

	@Override
	public void saveProducts(Projects project) {
		 projectsRepo.save(project);
	}

	@Override
	public List<Projects> getProducts() {
		return projectsRepo.findAll();
	}

	@Override
	public Projects getProduct(Integer pId) {
		return projectsRepo.findById(pId).get();
	}

	@Override
	public Projects editProject(Projects project, Integer pId) {
		if (projectsRepo.existsById(pId)) {
			Projects projects = projectsRepo.findById(pId).orElseThrow();
			
			return projects;
		}
		return null;
	}

}

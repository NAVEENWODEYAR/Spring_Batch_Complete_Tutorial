package com.gowri.tech.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gowri.tech.entity.Projects;
import com.gowri.tech.repo.ProjectsRepo;
import com.gowri.tech.service.ProjectService;

import jakarta.transaction.Transactional;

/**
 * @author -NaveenWodeyar
 * @date -24-Nov-2024
 * @time - 12:25:04 am
 * @location -
 */

@Service
public class ProjectServiceImpl implements ProjectService {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	@Autowired
	private ProjectsRepo projectsRepo;

	@Override
	@Transactional
	public void saveProducts(Projects project) {
		log.info("save/persist operation");
		 projectsRepo.save(project);
	}

	@Override
	@Transactional
	public List<Projects> getProducts() {
		log.info("findAll/fech student records");
		return projectsRepo.findAll();
	}

	@Override
	@Transactional
	public Projects getProduct(Integer pId) {
		log.info("findById");
		return projectsRepo.findById(pId).get();
	}

	@Override
	@Transactional
	public Projects editProject(Projects project, Integer pId) {
		if (projectsRepo.existsById(pId)) {
			Projects projects = projectsRepo.findById(pId).orElseThrow();
			BeanUtils.copyProperties(project, projects);			
			return projects;
		}
		return null;
	}

}

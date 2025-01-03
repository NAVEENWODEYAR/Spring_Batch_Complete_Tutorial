package com.gowri.tech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gowri.tech.entity.Projects;

/**
 * @author -NaveenWodeyar
 * @date -23-Nov-2024
 * @time - 10:47:56 pm
 * @location -
 */
@Service
public interface ProjectService {

	public void saveProducts(Projects project);
	public List<Projects> getProducts();
	public Projects getProduct(Integer pId);

}

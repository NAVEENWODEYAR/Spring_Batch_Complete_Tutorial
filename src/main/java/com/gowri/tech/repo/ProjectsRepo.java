package com.gowri.tech.repo;
/**
 * @author -NaveenWodeyar
 * @date -17-Nov-2024
 * @time - 7:47:37 pm
 * @location -
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gowri.tech.entity.Projects;

@Repository
public interface ProjectsRepo extends JpaRepository<Projects, Integer> {

}

package com.gowri.tech.repo;
/**
 * @author -NaveenWodeyar
 * @date -17-Nov-2024
 * @time - 7:49:32 pm
 * @location -
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gowri.tech.entity.EmployeesTable;

@Repository
public interface EmployeesTableRepository extends JpaRepository<EmployeesTable, Integer> {

}

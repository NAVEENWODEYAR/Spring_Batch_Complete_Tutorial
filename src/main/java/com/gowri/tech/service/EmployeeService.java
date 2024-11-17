package com.gowri.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowri.tech.entity.EmployeesTable;
import com.gowri.tech.repo.EmployeesTableRepository;

/**
 * @author -NaveenWodeyar
 * @date -17-Nov-2024
 * @time - 7:52:00 pm
 * @location -
 */
@Service
public interface EmployeeService {

	public void saveEmpLoyee(EmployeesTable employeesTable);
	

}

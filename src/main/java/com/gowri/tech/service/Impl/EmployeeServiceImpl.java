package com.gowri.tech.service.Impl;

import java.util.List;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gowri.tech.entity.EmployeesTable;
import com.gowri.tech.repo.EmployeesTableRepository;
import com.gowri.tech.service.EmployeeService;

/**
 * @author -NaveenWodeyar
 * @date -17-Nov-2024
 * @time - 7:54:28 pm
 * @location -
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeesTableRepository  employeesTableRepository;
	
	@Override
	public void saveEmpLoyee(EmployeesTable request) {
		log.info("Save() started: {}",System.currentTimeMillis());
		employeesTableRepository.save(request);
	}

	@Override
	public List<EmployeesTable> empList() {
		log.info("Employee List:");
		return employeesTableRepository.findAll();
	}

	@Override
	public String deleteEmp(Integer empId) {
		employeesTableRepository.deleteById(empId);
		return "Employee with Id "+empId+" deleted successfully";
	}

	@Override
	public EmployeesTable editEmp(EmployeesTable employee, Integer empId) {
		return null;
	}

}

package com.gowri.tech.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gowri.tech.entity.EmployeesTable;
/**
 * @author -NaveenWodeyar
 * @date -17-Nov-2024
 * @time - 7:52:00 pm
 * @location -
 */
@Service
public interface EmployeeService {

	public void saveEmpLoyee(EmployeesTable employeesTable);
	
	public List<EmployeesTable> empList();
	
	public String deleteEmp(Integer empId);
	
	public EmployeesTable editEmp(EmployeesTable employee, Integer empId);
	

}

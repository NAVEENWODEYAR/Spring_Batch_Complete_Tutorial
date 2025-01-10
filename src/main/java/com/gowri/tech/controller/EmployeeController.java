package com.gowri.tech.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gowri.tech.entity.EmployeesTable;
import com.gowri.tech.service.Impl.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author -NaveenWodeyar
 * @date -17-Nov-2024
 * @time - 8:04:29 pm
 * @location -
 */

@RestController
@RequestMapping("/api/v1/emp")
public class EmployeeController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping
	public String test() {
		return "Employee_Controller,";
	}
	
	@PostMapping("/add")
	public String postMethodName(@RequestBody EmployeesTable request) {
		employeeServiceImpl.saveEmpLoyee(request);
		return "Employee persisted into db";
	}
	
}

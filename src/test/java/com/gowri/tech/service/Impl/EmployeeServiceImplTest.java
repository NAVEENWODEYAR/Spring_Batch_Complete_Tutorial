package com.gowri.tech.service.Impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gowri.tech.entity.EmployeesTable;
import com.gowri.tech.repo.EmployeesTableRepository;
/**
 * @author -NaveenWodeyar
 * @date -25-Nov-2024
 * @time - 8:53:43 pm
 * @location -
 */
class EmployeeServiceImplTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Mock
    private EmployeesTableRepository employeesTableRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private EmployeesTable employee;

    @BeforeEach
    void setUp() {
        // Initialize mock objects
        MockitoAnnotations.openMocks(this);

        // Create a test Employee object
        employee = new EmployeesTable();
        employee.setId(1L);
        employee.setName("John Doe");
        employee.setPosition("Software Engineer");
    }

    @Test
    void testSaveEmployee() {
        // Act: Call saveEmployee method
        employeeService.saveEmpLoyee(employee);

        // Assert: Verify that the save method is called on the repository
        verify(employeesTableRepository, times(1)).save(employee);
    }

    @Test
    void testSaveEmployee_nullEmployee() {
        // Act: Call saveEmployee method with null employee
        employeeService.saveEmpLoyee(null);

        // Assert: Verify that save method is not called
        verify(employeesTableRepository, times(0)).save(any(EmployeesTable.class));
    }
}

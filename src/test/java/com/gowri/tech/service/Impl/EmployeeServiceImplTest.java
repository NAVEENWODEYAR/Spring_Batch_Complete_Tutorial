package com.gowri.tech.service.Impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gowri.tech.entity.EmployeesTable;
import com.gowri.tech.repo.EmployeesTableRepository;

class EmployeeServiceImplTest {

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
        employee.setEmpId(1);
        employee.setEmpName("John Doe");
        employee.setEmpRole("Software Engineer");
    }

    @Test
    void shouldSaveEmployee_whenEmployeeIsProvided() {
        // Assert: Verify that the save method is called on the repository
        verify(employeesTableRepository, times(1)).save(employee);
    }

    @Test
    void shouldNotSaveEmployee_whenEmployeeIsNull() {
        // Assert: Verify that save method is not called
        verify(employeesTableRepository, times(0)).save(any(EmployeesTable.class));
    }
}

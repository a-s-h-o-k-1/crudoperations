package com.cts.learning.crudoperations.service;


import com.cts.learning.crudoperations.exception.EmployeeNotFoundException;
import com.cts.learning.crudoperations.model.Address;
import com.cts.learning.crudoperations.model.Department;
import com.cts.learning.crudoperations.model.Employee;
import com.cts.learning.crudoperations.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    private Employee createSampleEmployee(Long id) {
        Department department = new Department(1L, "IT");
        Address address = new Address(1L, "123 Main St", "Hyderabad", "500001");
        Project project1 = new Project(1L, "Project A", "Description A");
        Project project2 = new Project(2L, "Project B", "Description B");

        return new Employee(
                id,
                "John Doe",
                "john.doe@example.com",
                department,
                address,
                Arrays.asList(project1, project2)
        );
    }

    @Test
    void testCreateEmployee() {
        Employee emp = createSampleEmployee(1L);
        Employee created = employeeService.createEmployee(emp);

        assertNotNull(created);
        assertEquals("John Doe", created.getName());
        assertEquals("IT", created.getDepartment().getName());
        assertEquals(2, created.getProjects().size());
        assertEquals("Hyderabad", created.getAddress().getCity());
    }

    @Test
    void testGetAllEmployees() {
        employeeService.createEmployee(createSampleEmployee(1L));
        employeeService.createEmployee(createSampleEmployee(2L));

        List<Employee> employees = employeeService.getAllEmployees();
        assertEquals(2, employees.size());
    }

    @Test
    void testGetEmployeeById_WhenFound() {
        Employee emp = createSampleEmployee(1L);
        employeeService.createEmployee(emp);

        Employee found = employeeService.getEmployeeById(1L);
        assertEquals("John Doe", found.getName());
        assertEquals("IT", found.getDepartment().getName());
    }

    @Test
    void testGetEmployeeById_WhenNotFound() {
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.getEmployeeById(999L);
        });
        assertTrue(exception.getMessage().contains("not found"));
    }

    @Test
    void testUpdateEmployee_WhenFound() {
        employeeService.createEmployee(createSampleEmployee(1L));

        Department newDept = new Department(2L, "HR");
        Address newAddress = new Address(2L, "456 Park Ave", "Bangalore", "560001");
        Project project3 = new Project(3L, "Project C", "Description C");

        Employee updated = new Employee(
                null,
                "Jane Doe",
                "jane.doe@example.com",
                newDept,
                newAddress,
                Arrays.asList(project3)
        );

        Employee result = employeeService.updateEmployee(1L, updated);

        assertEquals("Jane Doe", result.getName());
        assertEquals("HR", result.getDepartment().getName());
        assertEquals(1, result.getProjects().size());
        assertEquals("Bangalore", result.getAddress().getCity());
    }

    @Test
    void testUpdateEmployee_WhenNotFound() {
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.updateEmployee(999L, createSampleEmployee(999L));
        });
        assertTrue(exception.getMessage().contains("not found"));
    }

    @Test
    void testDeleteEmployee_WhenFound() {
        employeeService.createEmployee(createSampleEmployee(1L));
        Employee deleted = employeeService.deleteEmployee(1L);

        assertEquals("John Doe", deleted.getName());
        assertEquals(0, employeeService.getAllEmployees().size());
    }

    @Test
    void testDeleteEmployee_WhenNotFound() {
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.deleteEmployee(999L);
        });
        assertTrue(exception.getMessage().contains("not found"));
    }
}
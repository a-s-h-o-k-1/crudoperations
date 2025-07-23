package com.cts.learning.crudoperations.controller;

import com.cts.learning.crudoperations.model.Address;
import com.cts.learning.crudoperations.model.Department;
import com.cts.learning.crudoperations.model.Employee;
import com.cts.learning.crudoperations.model.Project;
import com.cts.learning.crudoperations.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    private Employee sampleEmployee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup nested model objects
        Department department = new Department(101L, "Engineering");
        Address address = new Address(201L, "123 Main St", "Bangalore", "560001");
        Project project1 = new Project(301L, "Spring Boot API", "REST API development");
        Project project2 = new Project(302L, "Angular Frontend", "Frontend UI development");

        // Sample Employee object with nested relationships
        sampleEmployee = new Employee(
                1L,
                "John Doe",
                "john.doe@example.com",
                department,
                address,
                Arrays.asList(project1, project2)
        );
    }

    @Test
    void testCreateEmployee() {
        when(employeeService.createEmployee(any(Employee.class)))
                .thenReturn(sampleEmployee);

        ResponseEntity<Employee> response = employeeController.createEmployee(sampleEmployee);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(sampleEmployee, response.getBody());
        assertEquals("John Doe", response.getBody().getName());
        assertEquals("Engineering", response.getBody().getDepartment().getName());
        assertEquals(2, response.getBody().getProjects().size());

        verify(employeeService, times(1)).createEmployee(sampleEmployee);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employeeList = Arrays.asList(sampleEmployee);

        when(employeeService.getAllEmployees()).thenReturn(employeeList);

        ResponseEntity<List<Employee>> response = employeeController.getAllEmployees();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("John Doe", response.getBody().get(0).getName());

        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void testGetEmployeeById() {
        Long id = 1L;

        when(employeeService.getEmployeeById(id)).thenReturn(sampleEmployee);

        ResponseEntity<Employee> response = employeeController.getEmployeeById(id);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(sampleEmployee, response.getBody());
        assertEquals("123 Main St", response.getBody().getAddress().getStreet());

        verify(employeeService, times(1)).getEmployeeById(id);
    }

    @Test
    void testUpdateEmployee() {
        Long id = 1L;

        when(employeeService.updateEmployee(eq(id), any(Employee.class)))
                .thenReturn(sampleEmployee);

        ResponseEntity<Employee> response = employeeController.updateEmployee(id, sampleEmployee);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(sampleEmployee, response.getBody());
        assertEquals("Bangalore", response.getBody().getAddress().getCity());

        verify(employeeService, times(1)).updateEmployee(id, sampleEmployee);
    }

    @Test
    void testDeleteEmployee() {
        Long id = 1L;

        when(employeeService.deleteEmployee(id)).thenReturn(sampleEmployee);

        ResponseEntity<Employee> response = employeeController.deleteEmployee(id);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(sampleEmployee, response.getBody());
        assertEquals("Spring Boot API", response.getBody().getProjects().get(0).getTitle());

        verify(employeeService, times(1)).deleteEmployee(id);
    }
}

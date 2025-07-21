package com.cts.learning.crudoperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cts.learning.crudoperations.model.Employee;
import com.cts.learning.crudoperations.service.EmployeeService;

/**
 * REST controller for managing Employee resources.
 * Provides endpoints for creating, reading, updating, and deleting employees.
 */
@RestController
@RequestMapping("/cts/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Creates a new employee.
     *
     * @param employee The employee object to be created.
     * @return ResponseEntity containing the created employee.
     */
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee created = employeeService.createEmployee(employee);
        return ResponseEntity.ok(created);
    }

    /**
     * Retrieves all employees.
     *
     * @return ResponseEntity containing a list of all employees.
     */
    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    /**
     * Retrieves an employee by ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return ResponseEntity containing the employee if found.
     */
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    /**
     * Updates an existing employee by ID.
     *
     * @param id The ID of the employee to update.
     * @param employee The updated employee data.
     * @return ResponseEntity containing the updated employee.
     */
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updated = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updated);
    }

    /**
     * Deletes an employee by ID.
     *
     * @param id The ID of the employee to delete.
     * @return ResponseEntity containing the deleted employee.
     */
    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        Employee deleted = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(deleted);
    }
}

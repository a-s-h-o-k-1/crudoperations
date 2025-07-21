package com.cts.learning.crudoperations.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.learning.crudoperations.exception.EmployeeNotFoundException;
import com.cts.learning.crudoperations.model.Employee;

/**
 * Service class for managing Employee operations using in-memory storage.
 * Supports basic CRUD operations and throws custom exceptions when needed.
 */
@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();
    //private long nextId = 1;

    /**
     * Creates a new employee and adds it to the list.
     *
     * @param employee The employee object to be created.
     * @return The created employee with an assigned ID.
     */
    public Employee createEmployee(Employee employee) {
        //employee.setId(nextId++);
        employeeList.add(employee);
        System.out.println("Created Employee: " + employee);
        return employee;
    }

    /**
     * Retrieves all employees from the list.
     *
     * @return A list of all employees.
     */
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return The employee object if found.
     * @throws EmployeeNotFoundException if no employee with the given ID exists.
     */
    public Employee getEmployeeById(Long id) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
    }

    /**
     * Updates an existing employee by ID.
     *
     * @param id The ID of the employee to update.
     * @param updatedEmployee The updated employee data.
     * @return The updated employee object.
     * @throws EmployeeNotFoundException if no employee with the given ID exists.
     */
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee emp = employeeList.get(i);
            if (emp.getId().equals(id)) {
                updatedEmployee.setId(id);
                employeeList.set(i, updatedEmployee);
                System.out.println("Updated Employee: " + updatedEmployee);
                return updatedEmployee;
            }
        }
        throw new EmployeeNotFoundException("Cannot update. Employee with ID " + id + " not found.");
    }

    /**
     * Deletes an employee by ID.
     *
     * @param id The ID of the employee to delete.
     * @return The deleted employee object.
     * @throws EmployeeNotFoundException if no employee with the given ID exists.
     */
    public Employee deleteEmployee(Long id) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee emp = employeeList.get(i);
            if (emp.getId().equals(id)) {
                employeeList.remove(i);
                System.out.println("Deleted Employee: " + emp);
                return emp;
            }
        }
        throw new EmployeeNotFoundException("Cannot delete. Employee with ID " + id + " not found.");
    }
}

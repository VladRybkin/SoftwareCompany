package ua.training.service;


import ua.training.model.entity.Employee;

import java.util.List;


public interface EmployeeService {


    void createEmployee(String name) throws Exception;

    void updateEmployee(Employee employee) throws Exception;

    List<Employee> getAllEmployees();

}

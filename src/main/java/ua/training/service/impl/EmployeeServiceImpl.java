package ua.training.service.impl;

import ua.training.model.entity.Employee;
import ua.training.service.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {

    private Map<Integer, Employee> employees = new HashMap<>();


    public void createEmployee(String name) throws Exception {
        Employee employee = new Employee();
        employee.setId(employees.size() + 1);
        employee.setName(name);

        if (!employees.containsKey(employee.getId())) {
            employees.put(employee.getId(), employee);
        } else {
            throw new Exception("user with current id " + employee.getId() + "already exist");
        }
    }

    public void updateEmployee(Employee employee) throws Exception {
        if (employees.containsKey(employee.getId())) {
            employees.put(employee.getId(), employee);
        } else {
            throw new Exception("employee doesn't exist");
        }


    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }
}

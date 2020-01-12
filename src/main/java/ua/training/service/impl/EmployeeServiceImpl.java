package ua.training.service.impl;

import ua.training.model.entity.Employee;
import ua.training.service.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private Map<Integer, Employee> employees = new HashMap<>();


    public void createEmployee(Employee employee) throws Exception {

        employee.setId(employees.size() + 1);
        employee.setName(employee.getName());

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

    @Override
    public Employee findById(int id) {
        return employees.get(id);
    }

    @Override
    public List<Employee> getEmployeesById(int departmentId) {
        return employees.values().stream().filter(e -> e.getId() == departmentId).collect(Collectors.toList());
    }
}

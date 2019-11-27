package ua.training.service.impl;

import ua.training.model.entity.Department;
import ua.training.model.entity.Employee;
import ua.training.service.DepartmentService;
import ua.training.service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentServiceImpl implements DepartmentService {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    private Map<Integer, Department> departments = new HashMap<>();

    @Override
    public void createDepartment(String name) throws Exception {
        Department department = new Department();
        department.setId(departments.size() + 1);
        department.setName(name);

        if (!departments.containsKey(department.getId())) {
            departments.put(department.getId(), department);
        } else {
            throw new Exception("department with current id " + department.getId() + "already exist");
        }
    }

    @Override
    public void updateDepartment(Department department) throws Exception {
        if (departments.containsKey(department.getId())) {
            departments.put(department.getId(), department);
        } else {
            throw new Exception("department doesn't exist");
        }
    }

    @Override
    public void assignToDepartment(Employee employee, Department department) {
        employee.setDepatmentId(department.getId());
    }

    @Override
    public List<Employee> getAllEmployees(int departmentId) {
        return employeeService.getAllEmployees().stream().filter(e -> e.getId() == departmentId).collect(Collectors.toList());
    }
}

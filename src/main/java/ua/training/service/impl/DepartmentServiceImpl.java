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

    private EmployeeService employeeService;

    private Map<Integer, Department> departments = new HashMap<>();

    public DepartmentServiceImpl() {
    }

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void createDepartment(Department department) throws Exception {
        department.setId(departments.size() + 1);
        department.setName(department.getName());

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
    public void assignToDepartment(Employee employee, Department department) throws Exception {

        employee.setDepatmentId(department.getId());
        employeeService.updateEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees(int departmentId) {
        return employeeService.getAllEmployees().stream().filter(e -> e.getId() == departmentId).collect(Collectors.toList());
    }

    @Override
    public Department findById(int id) {
        return departments.get(id);
    }


}

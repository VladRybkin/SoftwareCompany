package ua.training.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.training.model.entity.Department;
import ua.training.model.entity.Employee;
import ua.training.service.DepartmentService;
import ua.training.service.EmployeeService;


import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceITestIT {

    private DepartmentService departmentServiceTest;
    private EmployeeService employeeService;

    private String TEST_NAME = "Test name";

    private String TEST_NAME_UPDATED = "updated test name";

    @BeforeEach
    void setup() {
        employeeService = new EmployeeServiceImpl();
        departmentServiceTest = new DepartmentServiceImpl(employeeService);

    }

    @Test
    void createDepartment() throws Exception {
        Department department = new Department();
        department.setName(TEST_NAME);

        departmentServiceTest.createDepartment(department);
        Department foundById = departmentServiceTest.findById(department.getId());
        department.setId(1);

        assertEquals(department.getId(), foundById.getId());
        assertEquals(department.getName(), foundById.getName());
    }

    @Test
    void updateDepartment() throws Exception {
        Department department = new Department();
        department.setName(TEST_NAME);

        departmentServiceTest.createDepartment(department);
        department.setName(TEST_NAME_UPDATED);
        departmentServiceTest.updateDepartment(department);
        Department result = departmentServiceTest.findById(department.getId());
        assertEquals(result.getName(), TEST_NAME_UPDATED);
    }

    @Test
    void assignToDepartment() throws Exception {
        Employee employee = new Employee();
        Department department = new Department();
        department.setId(1);
        employeeService.createEmployee(employee);
        departmentServiceTest.assignToDepartment(employee, department);

    }

    @Test
    void getAllEmployess() throws Exception {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setDepatmentId(1);
        employeeService.createEmployee(employee);
        departmentServiceTest.getAllEmployees(1);
        assertEquals(1, departmentServiceTest.getAllEmployees(1).size());

    }


    @Test
    void findById() throws Exception {
        Department department = new Department();

        department.setName(TEST_NAME);
        departmentServiceTest.createDepartment(department);
        Department foundById = departmentServiceTest.findById(1);
        assertEquals(foundById.getName(), department.getName());
    }
}
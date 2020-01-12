package ua.training.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.training.model.entity.Department;
import ua.training.model.entity.Employee;
import ua.training.service.DepartmentService;
import ua.training.service.EmployeeService;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTestIT {

    private DepartmentService departmentServiceTest;
    private EmployeeService employeeService;

    private String TEST_NAME = "Test name";

    private String TEST_NAME_UPDATED = "updated test name";

    private static final int ID=1;

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
        department.setId(ID);

        assertThat(department.getId(), is(foundById.getId()));
        assertThat(department.getName(), is(foundById.getName()));
    }

    @Test
    void updateDepartment() throws Exception {
        Department department = new Department();
        department.setName(TEST_NAME);

        departmentServiceTest.createDepartment(department);
        department.setName(TEST_NAME_UPDATED);
        departmentServiceTest.updateDepartment(department);
        Department result = departmentServiceTest.findById(department.getId());
        assertThat(result.getName(), is(TEST_NAME_UPDATED));
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
        employee.setId(ID);
        employee.setDepatmentId(ID);
        employeeService.createEmployee(employee);
        departmentServiceTest.getAllEmployees(ID);
        assertThat(departmentServiceTest.getAllEmployees(ID).size(), is(ID));

    }


    @Test
    void findById() throws Exception {
        Department department = new Department();
        department.setName(TEST_NAME);
        departmentServiceTest.createDepartment(department);
        Department foundById = departmentServiceTest.findById(ID);
        assertThat(foundById.getName(), is(department.getName()));
    }

    @Test
    void ShouldThrowDepartmentDoesntExistException() throws Exception {
        Department department = new Department();
        department.setId(ID);
        assertNull(departmentServiceTest.findById(ID));
        assertThrows(Exception.class, () -> {
            departmentServiceTest.updateDepartment(department);
        });
    }
}
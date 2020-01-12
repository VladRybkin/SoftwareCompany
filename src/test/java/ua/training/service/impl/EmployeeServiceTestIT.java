package ua.training.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.training.model.entity.Employee;
import ua.training.service.EmployeeService;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class EmployeeServiceTestIT {

    private EmployeeService employeeServiceTest;

    private String TEST_NAME = "Test name";

    private String TEST_NAME_UPDATED = "updated test name";

    @BeforeEach
    void setup() {
        employeeServiceTest = new EmployeeServiceImpl();
    }

    @Test
    void createEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setName(TEST_NAME);

        employeeServiceTest.createEmployee(employee);
        Employee foundByIdEmployee = employeeServiceTest.findById(employee.getId());
        employee.setId(1);

        assertThat(employee.getId(), is(foundByIdEmployee.getId()));
        assertThat(employee.getName(), is(foundByIdEmployee.getName()));
    }

    @Test
    void updateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setName(TEST_NAME);

        employeeServiceTest.createEmployee(employee);
        employee.setName(TEST_NAME_UPDATED);
        employeeServiceTest.updateEmployee(employee);
        Employee result = employeeServiceTest.findById(employee.getId());
        assertThat(result.getName(), is(TEST_NAME_UPDATED));
    }

    @Test
    void getAllEmployees() throws Exception {
        Employee employee = new Employee();
        Employee employee2 = new Employee();

        employee.setName(TEST_NAME);
        employee2.setName(TEST_NAME + 2);
        employeeServiceTest.createEmployee(employee);
        employeeServiceTest.createEmployee(employee2);
        assertThat(employeeServiceTest.getAllEmployees(), is(Arrays.asList(employee, employee2)));
    }

    @Test
    void findById() throws Exception {
        Employee employee = new Employee();

        employee.setName(TEST_NAME);
        employeeServiceTest.createEmployee(employee);
        Employee foundById = employeeServiceTest.findById(1);
        assertThat(foundById.getName(), is(employee.getName()));

    }
}
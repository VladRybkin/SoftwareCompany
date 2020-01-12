package ua.training.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.training.model.entity.Department;
import ua.training.model.entity.Employee;


import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Mock
    private EmployeeServiceImpl employeeServiceMock;

    private static final int ID=1;


    @Test
    void assignToDepartment() throws Exception {

        Employee employee = new Employee();
        employee.setId(ID);

        Department department = new Department();
        department.setId(ID);

        departmentService.assignToDepartment(employee, department);
        assertEquals(employee.getId(), department.getId());
        verify(employeeServiceMock).updateEmployee(employee);

    }

    @Test
    void getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        when((employeeServiceMock.getEmployeesById(ID))).thenReturn(employees);
        assertThat(departmentService.getAllEmployees(ID), is(employees));
        verify(employeeServiceMock).getEmployeesById(ID);


    }



}
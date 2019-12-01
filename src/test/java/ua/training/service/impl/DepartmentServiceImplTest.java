package ua.training.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.training.model.entity.Department;
import ua.training.model.entity.Employee;
import ua.training.service.DepartmentService;
import ua.training.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @InjectMocks
    private DepartmentServiceImpl departmentServiceMock;

    @Mock
    private EmployeeServiceImpl employeeServiceMock;


    @Test
    void assignToDepartment() throws Exception {

        Employee employee = new Employee();
        employee.setId(1);

        Department department = new Department();
        department.setId(1);

        departmentServiceMock.assignToDepartment(employee, department);
        assertEquals(employee.getId(), department.getId());
        verify(employeeServiceMock).updateEmployee(employee);

    }

    @Test
    void getAllEmployees() {
        DepartmentService departmentService = mock(DepartmentService.class);
        List<Employee> employees = new ArrayList<>();
        lenient().when((departmentService.getAllEmployees(anyInt()))).thenReturn(employees);

    }


    @Test
    void ShouldThrowDepartmentDoesntExistException() throws Exception {
        Department department = new Department();
        department.setId(1);
        assertThrows(Exception.class, () -> {
            departmentServiceMock.updateDepartment(department);
        });
    }
}
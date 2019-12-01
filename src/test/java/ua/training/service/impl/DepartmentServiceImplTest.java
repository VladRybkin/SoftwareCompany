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


    private EmployeeService employeeServiceTest;

    @BeforeEach
    void setup() {
        employeeServiceTest = new EmployeeServiceImpl();
    }


    @Test
    void updateDepartment() throws Exception {
        Department department = new Department();
        department.setId(1);
        departmentServiceMock.createDepartment("Test Department");
        departmentServiceMock.updateDepartment(department);

    }

    @Test
    void assignToDepartment() throws Exception {
        employeeServiceTest.createEmployee("Test Employee");
        Employee employee = employeeServiceTest.getAllEmployees().stream().findAny().get();

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
    void ShouldNotThrowDepartmentAlreadyDoesNotExistException() throws Exception {
        departmentServiceMock.createDepartment("Test Department");
        Department department = new Department();
        department.setId(1);
        assertDoesNotThrow(() -> {
            departmentServiceMock.updateDepartment(department);
        });
    }

    @Test
    void ShouldNotThrowEmployeeAlreadyExistException() throws Exception {

        assertDoesNotThrow(() -> {
            departmentServiceMock.createDepartment("Test Department");
        });
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
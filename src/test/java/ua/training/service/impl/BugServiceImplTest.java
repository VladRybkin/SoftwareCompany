package ua.training.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.training.model.entity.Bug;
import ua.training.model.entity.Department;
import ua.training.model.entity.Employee;
import ua.training.service.BugService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BugServiceImplTest {

    @Mock
    private BugService bugServiceMock;

    @Mock
    private BugService bugServiceTest;

    @BeforeEach
    void setup() {
        bugServiceTest = new BugServiceImpl();
    }


    @Test
    void ShouldThrowBugDoesntExistException() throws Exception {
        Bug bug = new Bug();
        bug.setId(1);
        lenient().doThrow(new Exception()).when(bugServiceMock).updateBug(bug);
    }


    @Test
    void assignToEmployee() throws Exception {
        Bug bug = new Bug();
        bug.setId(1);

        Employee employee = new Employee();
        employee.setId(1);

        bugServiceMock.assignToEmployee(employee, bug);
        assertEquals(bug.getId(), employee.getId());

    }
}
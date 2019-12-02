package ua.training.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.training.model.entity.Bug;
import ua.training.model.entity.Employee;
import ua.training.service.BugService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BugServiceTestIT {

    private BugService bugServiceTest;

    private String TEST_DESCRIPTION = "Test Description";

    private String TEST_DESCRIPTION_UPDATED = "updated test descritption";

    @BeforeEach
    void setup() {
        bugServiceTest = new BugServiceImpl();
    }


    @Test
    void create() throws Exception {
        Bug bug = new Bug();
        bug.setDescription(TEST_DESCRIPTION);
        bug.setEmployeeId(1);
        bugServiceTest.createBug(bug);
        Bug foundByIdBug = bugServiceTest.findById(bug.getId());
        bug.setId(1);

        assertEquals(bug.getId(), foundByIdBug.getId());
        assertEquals(bug.getDescription(), foundByIdBug.getDescription());
        assertEquals(bug.getEmployeeId(), foundByIdBug.getEmployeeId());

    }


    @Test
    void update() throws Exception {
        Bug bug = new Bug();
        bug.setDescription(TEST_DESCRIPTION);
        bug.setEmployeeId(1);
        bugServiceTest.createBug(bug);
        bug.setDescription(TEST_DESCRIPTION_UPDATED);
        bugServiceTest.updateBug(bug);
        Bug result = bugServiceTest.findById(bug.getId());
        assertEquals(result.getDescription(), TEST_DESCRIPTION_UPDATED);
    }


    @Test
    void assignToEmployee() throws Exception {
        Bug bug = new Bug();
        bugServiceTest.createBug(bug);

        Employee employee = new Employee();
        employee.setId(1);

        bugServiceTest.assignToEmployee(employee, bug);
        assertEquals(bug.getEmployeeId(), employee.getId());
    }

    @Test
    void findById() throws Exception {
        Bug bug = new Bug();
        bug.setEmployeeId(999);
        bug.setDescription(TEST_DESCRIPTION);
        bugServiceTest.createBug(bug);
        Bug foundById = bugServiceTest.findById(1);
        assertEquals(foundById.getDescription(), bug.getDescription());
        assertEquals(foundById.getEmployeeId(), bug.getEmployeeId());

    }


}

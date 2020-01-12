package ua.training.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.training.model.entity.Bug;
import ua.training.model.entity.Employee;
import ua.training.service.BugService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BugServiceTestIT {

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

        assertThat(bug.getId(), is(foundByIdBug.getId()));
        assertThat(bug.getDescription(), is(foundByIdBug.getDescription()));
        assertThat(bug.getEmployeeId(), is(foundByIdBug.getEmployeeId()));

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
        assertThat(result.getDescription(), is(TEST_DESCRIPTION_UPDATED));
    }


    @Test
    void assignToEmployee() throws Exception {
        Bug bug = new Bug();
        bugServiceTest.createBug(bug);

        Employee employee = new Employee();
        employee.setId(1);

        bugServiceTest.assignToEmployee(employee, bug);
        assertThat(bug.getEmployeeId(), is(employee.getId()));
    }

    @Test
    void findById() throws Exception {
        Bug bug = new Bug();
        bug.setEmployeeId(999);
        bug.setDescription(TEST_DESCRIPTION);
        bugServiceTest.createBug(bug);
        Bug foundById = bugServiceTest.findById(1);
        assertThat(foundById.getEmployeeId(), is(bug.getEmployeeId()));

    }


}

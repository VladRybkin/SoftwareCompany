package ua.training.service.impl;

import ua.training.model.entity.Bug;
import ua.training.model.entity.Employee;
import ua.training.service.BugService;


import java.util.HashMap;
import java.util.Map;

public class BugServiceImpl implements BugService {

    private Map<Integer, Bug> bugs = new HashMap<>();

    @Override
    public void createBug(Bug bug) throws Exception {

        bug.setId(bugs.size() + 1);
        bug.setDescription(bug.getDescription());

        if (!bugs.containsKey(bug.getId())) {
            bugs.put(bug.getId(), bug);
        } else {
            throw new Exception("bug with current id " + bug.getId() + "already exist");
        }
    }

    @Override
    public void updateBug(Bug bug) throws Exception {
        if (bugs.containsKey(bug.getId())) {
            bugs.put(bug.getId(), bug);
        } else {
            throw new Exception("not bug found id= " + bug.getId());
        }
    }

    @Override
    public void assignToEmployee(Employee employee, Bug bug) throws Exception {
        bug.setEmployeeId(employee.getId());
        updateBug(bug);
    }

    @Override
    public Bug findById(int id) {
        return bugs.get(id);
    }
}

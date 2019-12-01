package ua.training.service;

import ua.training.model.entity.Bug;
import ua.training.model.entity.Employee;

public interface BugService {

    void createBug(Bug bug) throws Exception;

    void updateBug(Bug bug) throws Exception;

    void assignToEmployee(Employee employee, Bug bug) throws Exception;

    Bug findById(int id);

}

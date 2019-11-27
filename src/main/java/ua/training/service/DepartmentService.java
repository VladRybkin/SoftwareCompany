package ua.training.service;

import ua.training.model.entity.Department;
import ua.training.model.entity.Employee;

import java.util.List;

public interface DepartmentService {


    void createDepartment(String name) throws Exception;

    void updateDepartment(Department department) throws Exception;

    void assignToDepartment(Employee employee, Department department) ;

    List<Employee> getAllEmployees(int departmentId);

}

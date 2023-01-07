package com.practice.PRACTICE.service;
import java.util.List;
import com.practice.PRACTICE.exception.ObjectNotFound;
import com.practice.PRACTICE.exception.ResourceNotFoundException;
import com.practice.PRACTICE.entity.Employee;

public interface EmpService {
    Employee create(Employee employee);
    Employee findByEmpId(long empId) throws ResourceNotFoundException;
    List<Employee> getAllEmployee();
    void deleteEmployee(long empId) throws ResourceNotFoundException;
    Employee updateEmp(Employee employee, long id) throws ResourceNotFoundException;
    Employee findByName(String fname, String lname) throws ObjectNotFound;
}

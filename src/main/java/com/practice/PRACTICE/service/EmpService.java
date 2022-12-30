package com.practice.PRACTICE.service;

import com.practice.PRACTICE.entity.Employee;
import com.practice.PRACTICE.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Map;

public interface EmpService {
    Employee create(Employee employee);
    Employee findByEmpId(long empId) throws ResourceNotFoundException;
    List<Employee> getAllEmployee();
    void deleteEmployee(long empId) throws ResourceNotFoundException;
    Employee updateEmp(Employee employee, long id) throws ResourceNotFoundException;
}

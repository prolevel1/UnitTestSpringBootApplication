package com.practice.PRACTICE.service;

import com.practice.PRACTICE.entity.Employee;
import com.practice.PRACTICE.exception.ObjectNotFound;
import com.practice.PRACTICE.exception.ResourceNotFoundException;
import com.practice.PRACTICE.repo.EmpRepo;
import com.practice.PRACTICE.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.practice.PRACTICE.util.Constants.*;
@Service
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpRepo empRepo;

    @Override
    public Employee create(Employee employee) {
        return empRepo.save(employee);
    }

    @Override
    public Employee findByEmpId(long empId) throws ResourceNotFoundException {
        Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Not found Id::"+empId));
        return emp;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return empRepo.findAll();
    }

    @Override
    public void deleteEmployee(long empId) throws ResourceNotFoundException {
        Employee emp = findByEmpId(empId);
        empRepo.deleteById(emp.getEmpId());

    }

    @Override
    public Employee updateEmp(Employee employee, long id) throws ResourceNotFoundException {
     //   Employee emp = empRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Id::"+id));
        Employee emp = empRepo.findById(id).orElse(null);
        //   emp.setFirstName(employee.getFirstName());
    //    emp.setLastName(employee.getLastName());
        Employee updated = this.empRepo.save(employee);
        return updated;
    }

    @Override
    public Employee findByName(String fName, String lName) throws ObjectNotFound {
        List<Employee> employees = this.getAllEmployee();
        Employee res = null;
        for (Employee e : employees) {
            if (e.getLastName().equalsIgnoreCase(lName) && e.getFirstName().equalsIgnoreCase(fName)) {
                res =   e;
                break;
            }

        }
        if (res == null) {

            throw new ObjectNotFound(OBJECT_NOT_FOUND);
        }
        return res;
    }
}




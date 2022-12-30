package com.practice.PRACTICE.controller;

import com.practice.PRACTICE.entity.Employee;
import com.practice.PRACTICE.exception.ResourceNotFoundException;
import com.practice.PRACTICE.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmpService empService;
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(empService.getAllEmployee());
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(empService.create(employee));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(empService.findByEmpId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) throws ResourceNotFoundException {
        empService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee, @PathVariable long id) throws ResourceNotFoundException {
        return  ResponseEntity.ok(empService.updateEmp(employee, id));
    }
}

package com.practice.PRACTICE.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.practice.PRACTICE.entity.Employee;
import com.practice.PRACTICE.exception.ObjectNotFound;
import com.practice.PRACTICE.exception.ResourceNotFoundException;
import com.practice.PRACTICE.service.EmpService;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmpService empService;
    @PostMapping("/get")
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
    @PostMapping("/get/{fname}/{lname}")
    public ResponseEntity<Employee> getName(@PathVariable String fname, @PathVariable String lname) throws ObjectNotFound {
        return ResponseEntity.ok(empService.findByName(fname, lname));
    }
}

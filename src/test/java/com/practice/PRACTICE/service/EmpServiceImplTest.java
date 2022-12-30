package com.practice.PRACTICE.service;

import com.practice.PRACTICE.entity.Employee;
import com.practice.PRACTICE.exception.ResourceNotFoundException;
import com.practice.PRACTICE.repo.EmpRepo;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static junit.framework.TestCase.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class EmpServiceImplTest {
    @Mock
    private EmpRepo empRepo;
    @InjectMocks
    private EmpServiceImpl empService;

    private Employee employee;

    @BeforeEach
    public void setup() {
      employee = Employee.builder()
              .empId(1)
              .firstName("Sonam")
              .lastName("Singh")
              .build();
    }
    @DisplayName("JUnit Test for get All Employees")
    @Test
    public void getAllEmpTest() {
        Employee employee1 = Employee.builder()
                .empId(2)
                .firstName("Raj")
                .lastName("Kumar")
                .build();
        given(empRepo.findAll()).willReturn(List.of(employee, employee1));

        List<Employee> employees = empService.getAllEmployee();

       assertEquals(employees.size(), 2);
    }
    @DisplayName("JUnit Test for get Employee By ID")
    @Test
    public void testEmployeeById() throws ResourceNotFoundException {
        given(empRepo.findById(1L)).willReturn(Optional.of(employee));

        Employee save = empService.findByEmpId(employee.getEmpId());

        assertEquals(employee, save);
    }
    @DisplayName("JUnit test for updateEmployee method")
    @Test
    public void updateEmployeeTest() throws ResourceNotFoundException {
        given(empRepo.save(employee)).willReturn(employee);
       employee.setLastName("raj");
        employee.setFirstName("Kumar");

        long id = employee.getEmpId();

        Employee employee1 = empService.updateEmp(employee, id);

        assertEquals(employee1.getEmpId(), employee.getEmpId());
    }
    @DisplayName("JUnit Test to save employee")
    @Test
    public void saveEmployeeTest() {
        given(empRepo.save(employee)).willReturn(employee);

        Employee employee1 = empService.create(employee);
        assertThat(employee1).isNotNull();
    }
    @DisplayName("JUnit test for deleteEmployee method")
    @Test
    public void employeeId_DeleteEmployee() throws ResourceNotFoundException {
        long empId = 1;
        willDoNothing().given(empRepo).deleteById(empId);
       // Employee empId1 = empService.findByEmpId(empId);
        empService.deleteEmployee(empId);
        verify(empRepo, times(1)).deleteById(empId);
    }


}
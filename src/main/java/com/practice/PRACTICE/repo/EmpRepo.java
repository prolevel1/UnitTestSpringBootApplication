package com.practice.PRACTICE.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.practice.PRACTICE.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

}

package com.practice.PRACTICE.repo;

import com.practice.PRACTICE.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

}

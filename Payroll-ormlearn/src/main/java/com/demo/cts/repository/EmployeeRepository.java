package com.demo.cts.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.cts.model.Employee;



@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}
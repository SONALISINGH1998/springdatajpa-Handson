package com.demo.cts.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.cts.model.Department;



@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
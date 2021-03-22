package com.cognizant.ormlearn.repository;

import java.util.List;

import com.cognizant.ormlearn.model.Employee;

public interface EmployeeRepositoryCustom {
	
	 List<Employee> findEmployeesByName(String name);

}
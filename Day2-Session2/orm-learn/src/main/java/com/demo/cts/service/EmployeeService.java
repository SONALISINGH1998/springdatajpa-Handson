package com.demo.cts.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cts.OrmLearn3Application;
import com.demo.cts.model.Employee;
import com.demo.cts.repository.EmployeeRepository;



@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;
  
  private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearn3Application.class);
  
  @Transactional
  public Employee get(int id) {

	  LOGGER.info("Start");
	  Optional<Employee> e=employeeRepository.findById(id);
	  Employee e1=e.get();
	  return e1;
  }
  
  @Transactional
  public void saveEmployee(Employee employee) {
	  LOGGER.info("Start");
	  employeeRepository.save(employee);
	  LOGGER.info("End");

  }
  @Transactional
  public List<Employee> getAllPermanentEmployees(){
	  LOGGER.info("Start");
	  return employeeRepository.getAllPermanentEmployees();
	  
	  
  }
  @Transactional
  public List<Employee> getAllPermanentEmployeesWithSkills(){
	  LOGGER.info("Start");
	  return employeeRepository.getAllPermanentEmployeesWithSkills();
	  
	  
  }
  @Transactional
  public List<Employee> getAllEmployeesNative(){
	  return employeeRepository.getAllEmployeesNative();
  }
  
}
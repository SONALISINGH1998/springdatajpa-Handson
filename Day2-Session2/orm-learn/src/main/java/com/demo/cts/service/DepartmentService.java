package com.demo.cts.service;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cts.OrmLearn3Application;
import com.demo.cts.model.Department;
import com.demo.cts.repository.DepartmentRepository;




@Service
public class DepartmentService {
	@Autowired
	 private DepartmentRepository departmentRepository;
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearn3Application.class);
	
	@Transactional
	public Department get(int id) {

		  LOGGER.info("Start");
		  return departmentRepository.findById(id).get();
	  }
	  
	  @Transactional
	  public void save(Department department) {
		  LOGGER.info("Start");
		  departmentRepository.save(department);
		  LOGGER.info("End");

	  }
}
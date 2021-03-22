package com.cognizant.service;
import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Attempt;
import com.cognizant.repository.AttemptRepository;



@Service
public class AttemptService {
	
	@Autowired
	private AttemptRepository attemptRepository;
	
	@Transactional
	public Attempt getAttemptById() {
		return attemptRepository.getAttempt(1, 1);
	}
	
	
}
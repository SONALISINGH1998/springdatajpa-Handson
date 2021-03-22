package com.cognizant.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.Question;


public interface QuestionRepository extends JpaRepository<Question, String>{

}
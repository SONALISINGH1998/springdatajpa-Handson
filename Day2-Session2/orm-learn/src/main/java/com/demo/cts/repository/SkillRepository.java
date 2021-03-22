package com.demo.cts.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.cts.model.Skill;




@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>  {

}
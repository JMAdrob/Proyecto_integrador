package com.JuanBorda.portfolio.repository;

import com.JuanBorda.portfolio.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository<Skills, Long>{
    
}

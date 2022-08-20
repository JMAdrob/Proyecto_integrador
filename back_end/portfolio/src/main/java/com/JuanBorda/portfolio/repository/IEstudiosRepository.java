package com.JuanBorda.portfolio.repository;

import com.JuanBorda.portfolio.model.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudiosRepository extends JpaRepository<Estudios, Long>{
    
}

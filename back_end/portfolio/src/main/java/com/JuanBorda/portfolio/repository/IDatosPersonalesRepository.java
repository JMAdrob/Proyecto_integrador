package com.JuanBorda.portfolio.repository;

import com.JuanBorda.portfolio.model.DatosPersonales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDatosPersonalesRepository extends JpaRepository<DatosPersonales, Long>{
    
}

package com.JuanBorda.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Estudios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEst;
    
    private String nombreEst;
    private String descripcionEst;
    private String imgEst;

    public Estudios() {
    }

    public Estudios(Long idEst, String nombreEst, String descripcionEst, String imgEst) {
        this.idEst = idEst;
        this.nombreEst = nombreEst;
        this.descripcionEst = descripcionEst;
        this.imgEst = imgEst;
    }
    
    
}

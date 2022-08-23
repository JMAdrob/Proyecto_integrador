package com.JuanBorda.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idS;
    
    private String nombreS;
    private int porcentajeS;
    private String colorS;

    public Skills() {
    }

    public Skills(Long idS, String nombreS, int porcentajeS, String colorS) {
        this.idS = idS;
        this.nombreS = nombreS;
        this.porcentajeS = porcentajeS;
        this.colorS = colorS;
    }   
    
}

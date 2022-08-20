package com.JuanBorda.portfolio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity 
public class DatosPersonales implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //@Column(nullable = false, updatable = false)
    private String nombre;
    private String apellido;
    private String acercaDeMi;
    private String titulo;
    private String fotoImg;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExp")
    private List<Experiencia> experienciaList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEst")
    private List<Estudios> estudiosList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idS")
    private List<Skills> skillList;

    public DatosPersonales() {
    }

    public DatosPersonales(Long id, String nombre, String apellido, String acercaDeMi, String titulo, String fotoImg) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.acercaDeMi = acercaDeMi;
        this.titulo = titulo;
        this.fotoImg = fotoImg;
    }
    
    
}

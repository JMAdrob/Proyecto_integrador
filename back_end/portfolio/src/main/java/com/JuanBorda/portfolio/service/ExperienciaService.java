package com.JuanBorda.portfolio.service;

import com.JuanBorda.portfolio.model.Experiencia;
import com.JuanBorda.portfolio.repository.IExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService {
    
    private final IExperienciaRepository iExperienciaRepository;
    
    @Autowired
    public ExperienciaService(IExperienciaRepository iExperienciaRepository) {
        this.iExperienciaRepository = iExperienciaRepository;
    }
    
    public Experiencia crearExperiencia(Experiencia experiencia){
        return iExperienciaRepository.save(experiencia);
    }
    
    public List<Experiencia> buscarExperiencia() {
        return iExperienciaRepository.findAll();
    } 
    
    public Experiencia editarExperiencia(Experiencia experincia) {
        return iExperienciaRepository.save(experincia);
    }
    
    public void borrarExperiencia(Long id) {
        iExperienciaRepository.deleteById(id);
    }
}

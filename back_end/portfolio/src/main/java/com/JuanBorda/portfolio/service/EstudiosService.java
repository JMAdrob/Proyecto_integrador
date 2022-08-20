package com.JuanBorda.portfolio.service;

import com.JuanBorda.portfolio.model.Estudios;
import com.JuanBorda.portfolio.repository.IEstudiosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstudiosService {
    
    private final IEstudiosRepository iEstudiosRepository;
    
    @Autowired
    public EstudiosService(IEstudiosRepository iEstudiosRepository) {
        this.iEstudiosRepository = iEstudiosRepository;
    }
    
    public Estudios crearEstudios(Estudios estudios){
        return iEstudiosRepository.save(estudios);
    }
    
    public List<Estudios> buscarEstudios() {
        return iEstudiosRepository.findAll();
    } 
    
    public Estudios editarEstudios(Estudios estudios) {
        return iEstudiosRepository.save(estudios);
    }
    
    public void borrarEstudios(Long id) {
        iEstudiosRepository.deleteById(id);
    }
    
}

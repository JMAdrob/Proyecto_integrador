package com.JuanBorda.portfolio.service;

import com.JuanBorda.portfolio.exception.DatosPersonalesNotFoundException;
import com.JuanBorda.portfolio.model.DatosPersonales;
import com.JuanBorda.portfolio.repository.IDatosPersonalesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DatosPersonalesService {

    private final IDatosPersonalesRepository iDatosPersonalesRepository;
    
    @Autowired
    public DatosPersonalesService(IDatosPersonalesRepository iDatosPersonalesRepository) {
        this.iDatosPersonalesRepository = iDatosPersonalesRepository;
    }
    
    public DatosPersonales crearDatosPersonales(DatosPersonales datosPersonales){
        return iDatosPersonalesRepository.save(datosPersonales);
    }
    
    public List<DatosPersonales> buscarDatosPersonales() {
        return iDatosPersonalesRepository.findAll();
    } 
    
    public DatosPersonales buscarDatosPersonalesById(Long id){
        return iDatosPersonalesRepository.findById(id).orElseThrow(() -> new DatosPersonalesNotFoundException("No existen los datos"));
    }
    
    public DatosPersonales editarDatosPersonales(DatosPersonales datosPersonales) {
        return iDatosPersonalesRepository.save(datosPersonales);
    }
    
    public void borrarDatosPersonales(Long id) {
        iDatosPersonalesRepository.deleteById(id);
    }
    
}

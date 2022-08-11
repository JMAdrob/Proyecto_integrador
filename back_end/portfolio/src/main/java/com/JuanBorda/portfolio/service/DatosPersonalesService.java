package com.JuanBorda.portfolio.service;

import com.JuanBorda.portfolio.model.DatosPersonales;
import com.JuanBorda.portfolio.repository.IDatosPersonalesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosPersonalesService implements IDatosPersonalesService{

    @Autowired IDatosPersonalesRepository iDatosPersonalesRepository;
    
    
    @Override
    public List<DatosPersonales> getDatosPersonales() {
        List<DatosPersonales> datos = iDatosPersonalesRepository.findAll();
        return datos;
    }

    @Override
    public void saveDatosPersonales(DatosPersonales datos) {
        iDatosPersonalesRepository.save(datos);
    }

    @Override
    public void deleteDatosPersonales(Long id) {
        iDatosPersonalesRepository.deleteById(id);
    }

    @Override
    public DatosPersonales findDatosPersonales(Long id) {
        DatosPersonales datos = iDatosPersonalesRepository.findById(id).orElse(null);
        return datos;
    }
    
}

package com.JuanBorda.portfolio.service;

import com.JuanBorda.portfolio.model.DatosPersonales;
import java.util.List;

public interface IDatosPersonalesService {

    public List <DatosPersonales> getDatosPersonales();
    
    public void saveDatosPersonales(DatosPersonales datos);
    
    public void deleteDatosPersonales(Long id);
    
    public DatosPersonales findDatosPersonales(Long id);
}

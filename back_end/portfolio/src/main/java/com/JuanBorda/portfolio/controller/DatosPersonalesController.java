package com.JuanBorda.portfolio.controller;

import com.JuanBorda.portfolio.model.DatosPersonales;
import com.JuanBorda.portfolio.service.IDatosPersonalesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DatosPersonalesController {
    
    @Autowired IDatosPersonalesService iDatosPersonalesService;
    
    @GetMapping("/datospersonales/traer")
    public List <DatosPersonales> getDatosPersonales() {
        return iDatosPersonalesService.getDatosPersonales();
    }
    
    @PostMapping("/datospersonales/crear")
    public String createDatosPersonales(@RequestBody DatosPersonales datos){
        iDatosPersonalesService.saveDatosPersonales(datos);
        return "Creado exitosamente";
    }
    
    @DeleteMapping("/datospersonales/borrar/{id}")
    public String deleteDatosPersonales(@PathVariable long id){
        iDatosPersonalesService.deleteDatosPersonales(id);
        return "Eliminacion completada";
    }
    
    @PutMapping("/datospersonales/editar/{id}")
    public DatosPersonales editDatosPersonales(@PathVariable Long id,
                                            @RequestParam("nombre") String nuevoNombre,
                                            @RequestParam("apellido") String nuevoApellido
                                            ){
        DatosPersonales datosPersonales = iDatosPersonalesService.findDatosPersonales(id);
        
        datosPersonales.setNombre(nuevoNombre);
        datosPersonales.setApellido(nuevoApellido);
        
        iDatosPersonalesService.saveDatosPersonales(datosPersonales);
        
        return datosPersonales;
    }
    
    @GetMapping("/datospersonales/traer/yo")
    public DatosPersonales findDatosPersonales(){
        return iDatosPersonalesService.findDatosPersonales((long)1);
    }
}

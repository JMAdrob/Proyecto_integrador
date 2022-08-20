package com.JuanBorda.portfolio.controller;

import com.JuanBorda.portfolio.model.DatosPersonales;
import com.JuanBorda.portfolio.service.DatosPersonalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/datospersonales")
@CrossOrigin("http://localhost:4200")
public class DatosPersonalesController {
    
    private final DatosPersonalesService datosPersonalesService;
    
    public DatosPersonalesController(DatosPersonalesService datosPersonalesService) {
        this.datosPersonalesService = datosPersonalesService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DatosPersonales> obtenerDatosPersonales(@PathVariable("id") Long id){
        DatosPersonales datosPersonales = datosPersonalesService.buscarDatosPersonalesById(id);
        return new ResponseEntity<>(datosPersonales, HttpStatus.OK);
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity<DatosPersonales> editarDatosPersonales(@RequestBody DatosPersonales datosPersonales){
        DatosPersonales actualizarDatosPersonales = datosPersonalesService.editarDatosPersonales(datosPersonales);
        return new ResponseEntity<>(actualizarDatosPersonales, HttpStatus.OK);
    }
    
}
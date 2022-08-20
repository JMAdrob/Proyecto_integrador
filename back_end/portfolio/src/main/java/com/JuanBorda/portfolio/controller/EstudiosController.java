package com.JuanBorda.portfolio.controller;

import com.JuanBorda.portfolio.model.Estudios;
import com.JuanBorda.portfolio.service.EstudiosService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudios")
@CrossOrigin("http://localhost:4200")
public class EstudiosController {
    
    private final EstudiosService estudiosService;
    
    public EstudiosController(EstudiosService estudiosService){
        this.estudiosService = estudiosService;
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity<Estudios> editarEstudio(@RequestBody Estudios estudios){
        Estudios actualizarEstudios = estudiosService.editarEstudios(estudios);
        return new ResponseEntity<>(actualizarEstudios, HttpStatus.OK);
    }
    
    @GetMapping("/todo")
    public ResponseEntity<List<Estudios>> obtenerEstudios(){
        List<Estudios> estudios = estudiosService.buscarEstudios();
        return new ResponseEntity<>(estudios, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Estudios> crearEstudio(@RequestBody Estudios estudios){
        Estudios nuevoEstudio = estudiosService.crearEstudios(estudios);
        return new ResponseEntity<>(nuevoEstudio, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Estudios> borrarEstudios(@PathVariable("id") Long id){
        estudiosService.borrarEstudios(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

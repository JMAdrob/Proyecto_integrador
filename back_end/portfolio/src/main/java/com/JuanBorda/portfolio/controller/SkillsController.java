package com.JuanBorda.portfolio.controller;

import com.JuanBorda.portfolio.model.Skills;
import com.JuanBorda.portfolio.service.SkillsService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    
    private final SkillsService skillsService;
    
    public SkillsController(SkillsService skillsService){
        this.skillsService = skillsService;
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity<Skills> editarSkill(@RequestBody Skills skills){
        Skills actualizarExperiencia = skillsService.editarSkill(skills);
        return new ResponseEntity<>(actualizarExperiencia, HttpStatus.OK);
    }
    
    @GetMapping("/todo")
    public ResponseEntity<List<Skills>> obtenerSkills(){
        List<Skills> skills = skillsService.buscarSkill();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Skills> crearSkill(@RequestBody Skills skills){
        Skills nuevoSkill = skillsService.crearSkill(skills);
        return new ResponseEntity<>(nuevoSkill, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Skills> borrarSkill(@PathVariable("id") Long id){
        skillsService.borrarSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

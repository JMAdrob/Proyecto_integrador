package com.JuanBorda.portfolio.service;


import com.JuanBorda.portfolio.model.Skills;
import com.JuanBorda.portfolio.repository.ISkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillsService {
    
    private final ISkillsRepository iSkillsRepository;
    
    @Autowired
    public SkillsService(ISkillsRepository iSkillsRepository) {
        this.iSkillsRepository = iSkillsRepository;
    }
    
    public Skills crearSkill(Skills skills){
        return iSkillsRepository.save(skills);
    }
    
    public List<Skills> buscarSkill() {
        return iSkillsRepository.findAll();
    } 
    
    public Skills editarSkill(Skills skills) {
        return iSkillsRepository.save(skills);
    }
    
    public void borrarSkill(Long id) {
        iSkillsRepository.deleteById(id);
    }
}

package com.miporfoliobackend.bar.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.miporfoliobackend.bar.models.Experiencia;

import com.miporfoliobackend.bar.repository.IExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired IExperienciaRepository iexpRepository;

    @Override
    public List<Experiencia> getTodas() {
        List<Experiencia> listExp = iexpRepository.findAll();
        return listExp;
    }

    @Override
    public List<Experiencia> getTodasByPrsId(Long prsId) {
        List<Experiencia> listExp = iexpRepository.findAllByPersona(prsId);
        return listExp;
    }

    @Override
    public Experiencia findExperiencia(long id) {
        return iexpRepository.findById(id).orElse(null);

    }

    @Override
    public Experiencia saveExperiencia(Experiencia exp) {
        return iexpRepository.save(exp);
        
    }

    @Override
    public void deleteExperiencia(long id) {
        iexpRepository.deleteById(id);
        
    }
    
}
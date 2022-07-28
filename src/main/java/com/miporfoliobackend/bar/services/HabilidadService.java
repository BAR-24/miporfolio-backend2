package com.miporfoliobackend.bar.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.miporfoliobackend.bar.models.Habilidad;

import com.miporfoliobackend.bar.repository.IHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class HabilidadService implements IHabilidadService{
    
    @Autowired IHabilidadRepository ihabRepository;

    @Override
    public List<Habilidad> getTodas() {
        List<Habilidad> listExp = ihabRepository.findAll();
        return listExp;
    }
    
    @Override
    public List<Habilidad> getTodasByPrsId(Long prsId) {
        List<Habilidad> listProyectos = ihabRepository.findAllByPersona(prsId);
        return listProyectos;
    }

    @Override
    public Habilidad findHabilidad(long id) {
        return ihabRepository.findById(id).orElse(null);

    }

    @Override
    public Habilidad saveHabilidad(Habilidad exp) {
        return ihabRepository.save(exp);
        
    }

    @Override
    public void deleteHabilidad(long id) {
        ihabRepository.deleteById(id);
        
    }
    
}

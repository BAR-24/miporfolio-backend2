package com.miporfoliobackend.bar.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.miporfoliobackend.bar.models.Persona;

import com.miporfoliobackend.bar.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class PersonaService implements IPersonaService{
    
    @Autowired IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listPersonas = ipersonaRepository.findAll();
        return listPersonas;
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }

    @Override
    public Persona savePersona(Persona persona) {
        return ipersonaRepository.save(persona);
        
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
        
    }
    
}

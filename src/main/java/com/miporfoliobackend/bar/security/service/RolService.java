package com.miporfoliobackend.bar.security.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miporfoliobackend.bar.security.entity.Rol;
import com.miporfoliobackend.bar.security.enums.RolNombre;
import com.miporfoliobackend.bar.security.repository.IRolRepository;

@Service
@Transactional
public class RolService {
    
    @Autowired
    IRolRepository iRolRepository;

    public Optional<Rol> getByRolNombre (RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        iRolRepository.save(rol);
    }
}

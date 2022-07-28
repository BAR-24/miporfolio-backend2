package com.miporfoliobackend.bar.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miporfoliobackend.bar.security.entity.Usuario;
import com.miporfoliobackend.bar.security.repository.IUsuarioRepository;


@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    IUsuarioRepository iUsuarioRepository;

    public Optional<Usuario> getByusrName (String usrName){
        return iUsuarioRepository.findByusrName(usrName);
    }

    public boolean existsByusrName(String usrName){
        return iUsuarioRepository.existsByusrNombre(usrName);
    }

    public boolean existsByusrEmail(String usrEmail){
        return iUsuarioRepository.existsByusrEmail(usrEmail);
    }

    public void save(Usuario usr){
        iUsuarioRepository.save(usr);
    }
}

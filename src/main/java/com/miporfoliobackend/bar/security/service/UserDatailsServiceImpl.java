package com.miporfoliobackend.bar.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.miporfoliobackend.bar.security.entity.Usuario;
import com.miporfoliobackend.bar.security.entity.UsuarioPrincipal;

@Service
public class UserDatailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usrService;

    @Override
    public UserDetails loadUserByUsername(String usrName) throws UsernameNotFoundException {
        Usuario usuario = usrService.getByusrName(usrName).get();

        return UsuarioPrincipal.build(usuario);
    }

    
    
}

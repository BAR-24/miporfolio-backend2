package com.miporfoliobackend.bar.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miporfoliobackend.bar.security.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Optional<Usuario> findByusrName(String usrName);

    boolean existsByusrNombre(String usrNombre);

    boolean existsByusrEmail(String usrEmail);

}

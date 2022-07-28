package com.miporfoliobackend.bar.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miporfoliobackend.bar.security.entity.Rol;
import com.miporfoliobackend.bar.security.enums.RolNombre;

@Repository
public interface IRolRepository extends JpaRepository <Rol, Integer> {
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}

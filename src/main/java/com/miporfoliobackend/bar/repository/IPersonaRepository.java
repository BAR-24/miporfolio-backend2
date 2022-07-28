package com.miporfoliobackend.bar.repository;

import com.miporfoliobackend.bar.models.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    
}

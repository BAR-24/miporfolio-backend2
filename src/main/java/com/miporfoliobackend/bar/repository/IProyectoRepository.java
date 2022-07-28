package com.miporfoliobackend.bar.repository;

import com.miporfoliobackend.bar.models.Proyecto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Long>{

    @Query("select x from Proyecto x where x.persona.prsId like :var_parm")
    public abstract List<Proyecto> findAllByPersona(@Param("var_parm") Long prsId);
    
}
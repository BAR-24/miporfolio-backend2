package com.miporfoliobackend.bar.repository;

import com.miporfoliobackend.bar.models.Habilidad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadRepository extends JpaRepository<Habilidad, Long>{

    @Query("select x from Habilidad x where x.persona.prsId like :var_parm")
    public abstract List<Habilidad> findAllByPersona(@Param("var_parm") Long prsId);
    
}

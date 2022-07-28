package com.miporfoliobackend.bar.repository;
import java.util.List;

import com.miporfoliobackend.bar.models.Experiencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long>{

    @Query("select x from Experiencia x where x.persona.prsId like :var_parm")
    public abstract List<Experiencia> findAllByPersona(@Param("var_parm") Long prsId);
    
}
    


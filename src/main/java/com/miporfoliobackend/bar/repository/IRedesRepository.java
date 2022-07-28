package com.miporfoliobackend.bar.repository;


import com.miporfoliobackend.bar.models.Redes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IRedesRepository extends JpaRepository<Redes, Long> {
 
  
    @Query("select x from Redes x where x.persona.prsId like :var_parm")
    public abstract Redes findAllByPersona(@Param("var_parm") Long prsId);
}

package com.miporfoliobackend.bar.repository;
import java.util.List;

import com.miporfoliobackend.bar.models.Educacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Long> {
 
  
    @Query("select x from Educacion x where x.persona.prsId like :var_parm")
    public abstract List<Educacion> findAllByPersona(@Param("var_parm") Long prsId);
}

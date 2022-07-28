package com.miporfoliobackend.bar.services;

import java.util.List;

import com.miporfoliobackend.bar.models.Experiencia;

public interface IExperienciaService {
    //Traer experiencias
    public List<Experiencia> getTodas();

    //Traer experiencias por prs
    public List<Experiencia> getTodasByPrsId(Long prsId);
    
    //Traer experiencia
    public Experiencia findExperiencia(long id);

    //Guardar experiencia
    public Experiencia saveExperiencia(Experiencia educacion);

    //Borra experiencia
    public void deleteExperiencia(long id);

}

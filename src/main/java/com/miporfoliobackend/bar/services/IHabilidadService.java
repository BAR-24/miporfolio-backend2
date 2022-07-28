package com.miporfoliobackend.bar.services;

import java.util.List;

import com.miporfoliobackend.bar.models.Habilidad;

public interface IHabilidadService {
    //Traer hablidades
    public List<Habilidad> getTodas();
    
    public List<Habilidad> getTodasByPrsId(Long prsId);

    //Traer habilidad
    public Habilidad findHabilidad(long id);

    //Guardar habilidad
    public Habilidad saveHabilidad(Habilidad educacion);

    //Borra habilidad
    public void deleteHabilidad(long id);

}

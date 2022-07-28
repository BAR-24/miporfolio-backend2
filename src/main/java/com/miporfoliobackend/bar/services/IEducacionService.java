package com.miporfoliobackend.bar.services;

import java.util.List;

import com.miporfoliobackend.bar.models.Educacion;

public interface IEducacionService {
    //Traer educacion
    public List<Educacion> getTodas();

    public List<Educacion> getTodasByPrsId(Long prsId);
    
    //Traer educacion
    public Educacion findEducacion(Long id);

    //Guardar educacion
    public Educacion saveEducacion(Educacion educacion);

    //Borra educacion
    public void deleteEducacion(Long id);

}

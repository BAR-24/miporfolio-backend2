package com.miporfoliobackend.bar.services;

import java.util.List;

import com.miporfoliobackend.bar.models.Proyecto;

public interface IProyectoService {
    //Traer Proyectos
    public List<Proyecto> getProyectos();

    public List<Proyecto> getTodasByPrsId(Long prsId);
    
    //Traer Proyecto
    public Proyecto findProyecto(long id);

    //Guardar Proyecto
    public Proyecto saveProyecto(Proyecto Proyecto);

    //Borra Proyecto
    public void deleteProyecto(long id);



}

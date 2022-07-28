package com.miporfoliobackend.bar.services;

import java.util.List;

import com.miporfoliobackend.bar.models.Redes;

public interface IRedesService {
    //Traer educacion
    public List<Redes> getTodas();

    public Redes getTodasByPrsId(Long prsId);
    
    //Traer educacion
    public Redes findRedes(Long id);

    //Guardar educacion
    public Redes saveRedes(Redes educacion);

    //Borra educacion
    public void deleteRedes(Long id);

}

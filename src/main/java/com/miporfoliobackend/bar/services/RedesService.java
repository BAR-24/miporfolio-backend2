package com.miporfoliobackend.bar.services;

import java.util.List;


import org.springframework.stereotype.Service;
import com.miporfoliobackend.bar.models.Redes;

import com.miporfoliobackend.bar.repository.IRedesRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class RedesService implements IRedesService{
    
    @Autowired IRedesRepository iRedesRepository;

    @Override
    public List<Redes> getTodas() {
        List<Redes> listRedes = iRedesRepository.findAll();
        return listRedes;
    }  
    
    @Override
    public Redes getTodasByPrsId(Long prsId) {
        Redes Redes = iRedesRepository.findAllByPersona(prsId);
        return Redes;
    }
 

    @Override
    public Redes findRedes(Long id) {
        return iRedesRepository.findById(id).orElse(null);

    }

    @Override
    public Redes saveRedes(Redes rds) {
       return iRedesRepository.save(rds);
        
    }

    @Override
    public void deleteRedes(Long id) {
        iRedesRepository.deleteById(id);
        
    }



    



    


    



   
    
}

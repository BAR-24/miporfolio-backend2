package com.miporfoliobackend.bar.controller;

import java.util.List;

import com.miporfoliobackend.bar.models.Educacion;

import com.miporfoliobackend.bar.services.IEducacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EducacionController {

    @Autowired IEducacionService ieducacionService;

    @GetMapping("/educacion/traer")
    public List<Educacion> getTodas(){
        return ieducacionService.getTodas();
    }

    @GetMapping("/educacion/traerporprs/{prsId}")
    public List<Educacion> getTodasByPrsId(@PathVariable("prsId") Long prsId){
        return ieducacionService.getTodasByPrsId(prsId);
    }
 
    @PostMapping("/educacion/crear")
    public String crearEducacion(@RequestBody Educacion educacion){
    
        ieducacionService.saveEducacion(educacion);
        return "Se creo educacion con exito!";
    }

    @GetMapping("/educacion/traer/{id}")
    public Educacion findEducacion(@PathVariable("id") Long id){
        return ieducacionService.findEducacion(id);
    }

    @DeleteMapping("/educacion/borrar/{id}")
    public String deleteEducacion(@PathVariable("id") Long id){
        ieducacionService.deleteEducacion(id);
        return "Se elimino educacion con exito";
    }

    
    @PutMapping("/educacion/editar")
    public ResponseEntity<Educacion> editEducacionStatus(@RequestBody Educacion educacion){
        Educacion editEducacion = ieducacionService.saveEducacion(educacion);
         return new ResponseEntity<>(editEducacion, HttpStatus.CREATED);      
          
    }


}


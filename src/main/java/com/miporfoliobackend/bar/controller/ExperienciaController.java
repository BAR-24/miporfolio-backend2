package com.miporfoliobackend.bar.controller;

import java.util.List;

import com.miporfoliobackend.bar.models.Experiencia;
import com.miporfoliobackend.bar.services.IExperienciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {

    @Autowired IExperienciaService iexperienciaService;

    @GetMapping("/experiencia/traer")
    public List<Experiencia> getTodas(){
        return iexperienciaService.getTodas();
    }

    @GetMapping("/experiencia/traerporprs/{prsId}")
    public List<Experiencia> getTodasByPrsId(@PathVariable("prsId") Long prsId){
        return iexperienciaService.getTodasByPrsId(prsId);
    }

  
    @PostMapping("/experiencia/crear")
    public String crearExperiencia(@RequestBody Experiencia exp){
    
        iexperienciaService.saveExperiencia(exp);
        return "Se creo experiencia con exito!";
    }

    @GetMapping("/eperiencia/traer/{id}")
    public Experiencia findEducacion(@PathVariable("id") Long id){
        return iexperienciaService.findExperiencia(id);
    }


    @DeleteMapping("/experiencia/borrar/{id}")
    public String deleteExperiencia(@PathVariable("id") Long id){
        iexperienciaService.deleteExperiencia(id);
        return "Se elimino experiencia con exito";
    }

  
    @PutMapping("/experiencia/editar")
    public ResponseEntity<Experiencia> editExperienciaStatus(@RequestBody Experiencia exp){
        Experiencia editExp = iexperienciaService.saveExperiencia(exp);   
         return new ResponseEntity<>(editExp, HttpStatus.CREATED);      
          
    }
 


}
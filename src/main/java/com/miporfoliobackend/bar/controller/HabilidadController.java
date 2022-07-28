package com.miporfoliobackend.bar.controller;

import java.util.List;

import com.miporfoliobackend.bar.models.Habilidad;
import com.miporfoliobackend.bar.services.IHabilidadService;

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
public class HabilidadController {

    @Autowired IHabilidadService iHabilidadService;

    @GetMapping("/habilidad/traer")
    public List<Habilidad> getTodas(){
        return iHabilidadService.getTodas();
    }

    @GetMapping("/habilidad/traerporprs/{prsId}")
    public List<Habilidad> getTodasByPrsId(@PathVariable("prsId") Long prsId){
        return iHabilidadService.getTodasByPrsId(prsId);
    }


    @PostMapping("/habilidad/crear")
    public String crearHabilidad(@RequestBody Habilidad Habilidad){
    
        iHabilidadService.saveHabilidad(Habilidad);
        return "Se creo Habilidad con exito!";
    }    


    @DeleteMapping("/habilidad/borrar/{id}")
    public String deleteHabilidad(@PathVariable("id") Long id){
        iHabilidadService.deleteHabilidad(id);
        return "Se elimino Habilidad con exito";
    }

    @GetMapping("/habilidad/traer/{id}")
    public ResponseEntity<Habilidad> findPersona(@PathVariable("id") Long id){
             Habilidad hab =  iHabilidadService.findHabilidad(id);
             return new ResponseEntity<>(hab, HttpStatus.OK);        
    }


    @PutMapping("/habilidad/editar")
    public ResponseEntity<Habilidad> editHabilidadStatus(@RequestBody Habilidad Habilidad){
       Habilidad ediHab = iHabilidadService.saveHabilidad(Habilidad);             
       
       return new ResponseEntity<>(ediHab,HttpStatus.OK);     

    }


}

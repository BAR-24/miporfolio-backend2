package com.miporfoliobackend.bar.controller;

import java.util.List;

import com.miporfoliobackend.bar.models.Proyecto;
import com.miporfoliobackend.bar.services.IProyectoService;

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
public class ProyectoController {

    @Autowired IProyectoService iProyectoService;

    @GetMapping("/proyecto/traer")
    public List<Proyecto> getTodas(){
        return iProyectoService.getProyectos();
    }

    @GetMapping("/proyecto/traerporprs/{prsId}")
    public List<Proyecto> getTodasByPrsId(@PathVariable("prsId") Long prsId){
        return iProyectoService.getTodasByPrsId(prsId);
    }


    @PostMapping("/proyecto/crear")
    public String crearProyecto(@RequestBody Proyecto Proyecto){
    
        iProyectoService.saveProyecto(Proyecto);
        return "Se creo proyecto con exito!";
    }

    @GetMapping("/proyecto/traer/{id}")
    public Proyecto findProyecto(@PathVariable("id") Long id){
        return iProyectoService.findProyecto(id);
    }

    @DeleteMapping("/proyecto/borrar/{id}")
    public String deleteProyecto(@PathVariable("id") Long id){
        iProyectoService.deleteProyecto(id);
        return "Se elimino proyecto con exito";
    }

    @PutMapping("/proyecto/editar")
    public ResponseEntity<Proyecto> editProyectoStatus(@RequestBody Proyecto Proyecto){
       Proyecto ediPro = iProyectoService.saveProyecto(Proyecto);             
       
       return new ResponseEntity<>(ediPro,HttpStatus.OK);     

    }


}

package com.miporfoliobackend.bar.controller;

import java.util.List;

import com.miporfoliobackend.bar.models.Redes;
import com.miporfoliobackend.bar.services.IRedesService;

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
public class RedesController {

    @Autowired IRedesService iRedesService;

    @GetMapping("/redes/traer")
    public List<Redes> getTodas(){
        return iRedesService.getTodas();
    }

    @GetMapping("/redes/traerporprs/{prsId}")
    public Redes getTodasByPrsId(@PathVariable("prsId") Long prsId){
        return iRedesService.getTodasByPrsId(prsId);
    }


    @PostMapping("/redes/crear")
    public String crearRedes(@RequestBody Redes Redes){
    
        iRedesService.saveRedes(Redes);
        return "Se agregaron redes con exito!";
    }


    @GetMapping("/redes/traer/{id}")
    public Redes findRedes(@PathVariable("id") Long id){
        return iRedesService.findRedes(id);
    }


    @DeleteMapping("/redes/borrar/{id}")
    public String deleteRedes(@PathVariable("id") Long id){
        iRedesService.deleteRedes(id);
        return "Se elimino redes con exito";
    }

    @PutMapping("/redes/editar")
    public ResponseEntity<Redes> editRedesStatus(@RequestBody Redes Redes){
       Redes rdsPro = iRedesService.saveRedes(Redes);             
       
       return new ResponseEntity<>(rdsPro,HttpStatus.OK);     

    }


}

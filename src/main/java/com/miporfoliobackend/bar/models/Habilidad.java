package com.miporfoliobackend.bar.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity 
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long habId;

    @NotNull
    @Size(min = 1, max=100, message = "No cumple con los parametros de validacion")
    private String habTitulo; 
    
    @NotNull
    @Size(min = 1, max=500, message = "No cumple con los parametros de validacion")  
    private String habDescripcion;

    @NotNull
    private int habProcentaje;

    @ManyToOne
    @JoinColumn(name = "prsId")
    private Persona persona;
   
    public Habilidad() {
        
    }  

    public Habilidad(long habId, String habTitulo, String habDescripcion, int habProcentaje) {
        this.habId = habId;
        this.habTitulo = habTitulo;
        this.habDescripcion = habDescripcion;
        this.habProcentaje = habProcentaje;
    }

    public long getHabId() {
        return habId;
    }

    public void setHabId(long habId) {
        this.habId = habId;
    }

    public String getHabTitulo() {
        return habTitulo;
    }

    public void setHabTitulo(String habTitulo) {
        this.habTitulo = habTitulo;
    }

    public String getHabDescripcion() {
        return habDescripcion;
    }

    public void setHabDescripcion(String habDescripcion) {
        this.habDescripcion = habDescripcion;
    }

    public int getHabProcentaje() {
        return habProcentaje;
    }

    public void setHabProcentaje(int habProcentaje) {
        this.habProcentaje = habProcentaje;
    }

    @JsonBackReference
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
   

    

}

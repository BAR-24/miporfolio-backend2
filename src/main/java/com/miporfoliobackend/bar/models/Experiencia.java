package com.miporfoliobackend.bar.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;





@Entity 
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long expId;

    @NotNull
    @Size(min = 1, max=100, message = "No cumple con los parametros de validacion")
    private String expTitulo;
    
    @NotNull
    @Size(min = 1, max=500, message = "No cumple con los parametros de validacion")
    private String expDescripcion;  

    @NotNull
    private int expFechaInicio; 
    
    @NotNull
    private int expFechaFin;
   
    private String expImgUrl;

    @ManyToOne
    @JoinColumn(name = "prsId")
    private Persona persona;

    public Experiencia() {
        
    }   

    public Experiencia(long expId, String expTitulo, String expDescripcion, int expFechaInicio, int expFechaFin,
            String expImgUrl) {
        this.expId = expId;
        this.expTitulo = expTitulo;
        this.expDescripcion = expDescripcion;
        this.expFechaInicio = expFechaInicio;
        this.expFechaFin = expFechaFin;
        this.expImgUrl = expImgUrl;
    }

    public long getExpId() {
        return expId;
    }

    public void setExpId(long expId) {
        this.expId = expId;
    }

    public String getExpTitulo() {
        return expTitulo;
    }

    public void setExpTitulo(String expTitulo) {
        this.expTitulo = expTitulo;
    }

    public String getExpDescripcion() {
        return expDescripcion;
    }

    public void setExpDescripcion(String expDescripcion) {
        this.expDescripcion = expDescripcion;
    }

    public int getExpFechaInicio() {
        return expFechaInicio;
    }

    public void setExpFechaInicio(int expFechaInicio) {
        this.expFechaInicio = expFechaInicio;
    }

    public int getExpFechaFin() {
        return expFechaFin;
    }

    public void setExpFechaFin(int expFechaFin) {
        this.expFechaFin = expFechaFin;
    }

    public String getExpImgUrl() {
        return expImgUrl;
    }

    public void setExpImgUrl(String expImgUrl) {
        this.expImgUrl = expImgUrl;
    }

    @JsonBackReference
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
 

    
    

    

    


}

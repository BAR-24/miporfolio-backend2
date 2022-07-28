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
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eduId;    

    @NotNull
    @Size(min = 1, max=100, message = "No cumple con los parametros de validacion")
    private String eduTitulo;  
    
    @NotNull
    @Size(min = 1, max=500, message = "No cumple con los parametros de validacion")
    private String eduDescripcion;  

    @NotNull  
    private int eduFechaInicio;
    
    @NotNull
    private int eduFechaFin;
    
    private String eduImgUrl;

    
    @ManyToOne
    @JoinColumn(name = "prsId")
    private Persona persona;
    
    public Educacion(){

    }
    
    public Educacion(long eduId, String eduTitulo, String eduDescripcion, int eduFechaInicio, int eduFechaFin,
            String eduImgUrl) {
        this.eduId = eduId;
        this.eduTitulo = eduTitulo;
        this.eduDescripcion = eduDescripcion;
        this.eduFechaInicio = eduFechaInicio;
        this.eduFechaFin = eduFechaFin;
        this.eduImgUrl = eduImgUrl;
       
    }

    public long getEduId() {
        return eduId;
    }

    public void setEduId(long eduId) {
        this.eduId = eduId;
    }

    public String getEduTitulo() {
        return eduTitulo;
    }

    public void setEduTitulo(String eduTitulo) {
        this.eduTitulo = eduTitulo;
    }

    public String getEduDescripcion() {
        return eduDescripcion;
    }

    public void setEduDescripcion(String eduDescripcion) {
        this.eduDescripcion = eduDescripcion;
    }

    public int getEduFechaInicio() {
        return eduFechaInicio;
    }

    public void setEduFechaInicio(int eduFechaInicio) {
        this.eduFechaInicio = eduFechaInicio;
    }

    public int getEduFechaFin() {
        return eduFechaFin;
    }

    public void setEduFechaFin(int eduFechaFin) {
        this.eduFechaFin = eduFechaFin;
    }

    public String getEduImgUrl() {
        return eduImgUrl;
    }

    public void setEduImgUrl(String eduImgUrl) {
        this.eduImgUrl = eduImgUrl;
    }

    @JsonBackReference
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }   
    

   
   
    
}
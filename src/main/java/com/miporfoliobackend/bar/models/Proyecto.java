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
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long proId;

    @NotNull
    @Size(min = 1, max=100, message = "No cumple con los parametros de validacion")
    private String proTitulo;
    
    @NotNull
    @Size(min = 1, max=500, message = "No cumple con los parametros de validacion")
    private String proDescripcion;  

    @NotNull    
    private int proFechaInicio;   
    
    @NotNull
    private int proFechaFin;
    
    private String proImgUrl;
    
    @ManyToOne
    @JoinColumn(name = "prsId")
    private Persona persona;

    public Proyecto() {

        
    }

    public Proyecto(long proId, String proTitulo, String proDescripcion, int proFechaInicio, int proFechaFin,
            String proImgUrl) {
        this.proId = proId;
        this.proTitulo = proTitulo;
        this.proDescripcion = proDescripcion;
        this.proFechaInicio = proFechaInicio;
        this.proFechaFin = proFechaFin;
        this.proImgUrl = proImgUrl;
    }

    public long getProId() {
        return proId;
    }

    public void setProId(long proId) {
        this.proId = proId;
    }

    public String getProTitulo() {
        return proTitulo;
    }

    public void setProTitulo(String proTitulo) {
        this.proTitulo = proTitulo;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public int getProFechaInicio() {
        return proFechaInicio;
    }

    public void setProFechaInicio(int proFechaInicio) {
        this.proFechaInicio = proFechaInicio;
    }

    public int getProFechaFin() {
        return proFechaFin;
    }

    public void setProFechaFin(int proFechaFin) {
        this.proFechaFin = proFechaFin;
    }

    public String getProImgUrl() {
        return proImgUrl;
    }

    public void setProImgUrl(String proImgUrl) {
        this.proImgUrl = proImgUrl;
    }

    @JsonBackReference
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    


    


      
    

   
   
    
}
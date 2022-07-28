package com.miporfoliobackend.bar.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.miporfoliobackend.bar.security.entity.Usuario;





@Entity 
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prsId;

    @NotNull
    @Size(min = 1, max=50, message = "No cumple con los parametros de validacion")
    private String prsNombre; 

    @NotNull
    @Size(min = 1, max=50, message = "No cumple con los parametros de validacion")  
    private String prsApellido; 

    @NotNull    
    private int prsEdad;  

    @NotNull
    @Size(min = 1, max=80, message = "No cumple con los parametros de validacion")
    private String prsOcupacion;

    @NotNull
    @Size(min = 1, max=500, message = "No cumple con los parametros de validacion")
    private String prsAcercaDeMi;
    
    private String prsImgPerfilUrl;
    private String prsImgPortadaUrl;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY) 
    private List<Educacion> listEdu = new ArrayList<>();

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY) 
    private List<Experiencia> listExp = new ArrayList<>();

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Habilidad> listHab = new ArrayList<>();

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Proyecto> listPro = new ArrayList<>();

    @OneToOne(mappedBy = "persona", fetch = FetchType.LAZY)
    private Redes redes = new Redes();

    @OneToOne(mappedBy = "persona", fetch = FetchType.LAZY)
    private Usuario usuario = new Usuario();
   

    public Persona(){

    }

    public Persona(Long prsId, String prsNombre, String prsApellido, int prsEdad, String prsOcupacion,
            String prsAcercaDeMi, String prsImgPerfilUrl, String prsImgPortadaUrl) {
        this.prsId = prsId;
        this.prsNombre = prsNombre;
        this.prsApellido = prsApellido;
        this.prsEdad = prsEdad;
        this.prsOcupacion = prsOcupacion;
        this.prsAcercaDeMi = prsAcercaDeMi;
        this.prsImgPerfilUrl = prsImgPerfilUrl;
        this.prsImgPortadaUrl = prsImgPortadaUrl;
    }

    public Long getPrsId() {
        return prsId;
    }

    public void setPrsId(Long prsId) {
        this.prsId = prsId;
    }

    public String getPrsNombre() {
        return prsNombre;
    }

    public void setPrsNombre(String prsNombre) {
        this.prsNombre = prsNombre;
    }

    public String getPrsApellido() {
        return prsApellido;
    }

    public void setPrsApellido(String prsApellido) {
        this.prsApellido = prsApellido;
    }

    public int getPrsEdad() {
        return prsEdad;
    }

    public void setPrsEdad(int prsEdad) {
        this.prsEdad = prsEdad;
    }

    public String getPrsOcupacion() {
        return prsOcupacion;
    }

    public void setPrsOcupacion(String prsOcupacion) {
        this.prsOcupacion = prsOcupacion;
    }

    public String getPrsAcercaDeMi() {
        return prsAcercaDeMi;
    }

    public void setPrsAcercaDeMi(String prsAcercaDeMi) {
        this.prsAcercaDeMi = prsAcercaDeMi;
    }

    public String getPrsImgPerfilUrl() {
        return prsImgPerfilUrl;
    }

    public void setPrsImgPerfilUrl(String prsImgPerfilUrl) {
        this.prsImgPerfilUrl = prsImgPerfilUrl;
    }

    public String getPrsImgPortadaUrl() {
        return prsImgPortadaUrl;
    }

    public void setPrsImgPortadaUrl(String prsImgPortadaUrl) {
        this.prsImgPortadaUrl = prsImgPortadaUrl;
    }

    @JsonManagedReference
    public List<Educacion> getListEdu() {
        return listEdu;
    }

    public void setListEdu(List<Educacion> listEdu) {
        this.listEdu = listEdu;
    }

    @JsonManagedReference
    public List<Experiencia> getListExp() {
        return listExp;
    }

    public void setListExp(List<Experiencia> listExp) {
        this.listExp = listExp;
    }

    @JsonManagedReference
    public List<Habilidad> getListHab() {
        return listHab;
    }

    public void setListHab(List<Habilidad> listHab) {
        this.listHab = listHab;
    }

    @JsonManagedReference
    public List<Proyecto> getListPro() {
        return listPro;
    }

    public void setListPro(List<Proyecto> listPro) {
        this.listPro = listPro;
    }
   
    public Redes getRedes() {
        return redes;
    }

    public void setRedes(Redes rds) {
        redes = rds;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usr) {
        usuario = usr;
    }
    

   

}
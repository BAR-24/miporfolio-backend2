package com.miporfoliobackend.bar.security.dto;

import java.util.HashSet;
import java.util.Set;

import com.miporfoliobackend.bar.models.Persona;



public class NuevoUsuario {
    private String usrNombre;
    private String usrName;
    private String usrEmail;
    private String usrPassword;
    private Set<String> usrRoles = new HashSet<>();
    private Persona usrPersona;
    
    public String getUsrNombre() {
        return usrNombre;
    }
    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }
    public String getUsrName() {
        return usrName;
    }
    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }
    public String getUsrEmail() {
        return usrEmail;
    }
    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }
    public String getUsrPassword() {
        return usrPassword;
    }
    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }
    public Set<String> getUsrRoles() {
        return usrRoles;
    }
    public void setUsrRoles(Set<String> usrRoles) {
        this.usrRoles = usrRoles;
    }
    public Persona getUsrPersona() {
        return usrPersona;
    }
    public void setUsrPersona(Persona usrPersona) {
        this.usrPersona = usrPersona;
    }


    

    

}

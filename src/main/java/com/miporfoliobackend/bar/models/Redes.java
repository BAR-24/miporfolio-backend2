package com.miporfoliobackend.bar.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;





@Entity 
public class Redes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rdsId;
    
    private String rdsFacebook; 

    private String rdsTwiter;
    
    private String rdsLinkedIn; 
    
    private String rdsGit;

    

    @OneToOne
    @JoinColumn(name = "prsId")
    private Persona persona;

    public Redes() {

        
    }

    public Redes(long rdsId, String rdsFacebook, String rdsTwiter, String rdsLinkedIn, String rdsGit,
            Persona persona) {
        this.rdsId = rdsId;
        this.rdsFacebook = rdsFacebook;
        this.rdsTwiter = rdsTwiter;
        this.rdsLinkedIn = rdsLinkedIn;        
        this.rdsGit = rdsGit;
        this.persona = persona;
    }

    public long getRdsId() {
        return rdsId;
    }

    public void setRdsId(long rdsId) {
        this.rdsId = rdsId;
    }

    public String getRdsFacebook() {
        return rdsFacebook;
    }

    public void setRdsFacebook(String rdsFacebook) {
        this.rdsFacebook = rdsFacebook;
    }

    public String getRdsTwiter() {
        return rdsTwiter;
    }

    public void setRdsTwiter(String rdsTwiter) {
        this.rdsTwiter = rdsTwiter;
    }    

    public String getRdsLinkedIn() {
        return rdsLinkedIn;
    }

    public void setRdsLinkedIn(String rdsLinkedIn) {
        this.rdsLinkedIn = rdsLinkedIn;
    }

    public String getRdsGit() {
        return rdsGit;
    }

    public void setRdsGit(String rdsGit) {
        this.rdsGit = rdsGit;
    }   

    @JsonBackReference
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    

   
    


    
    

    

    


}

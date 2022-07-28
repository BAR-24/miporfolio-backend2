package com.miporfoliobackend.bar.security.dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {

    @NotBlank
    private String usrName;
    @NotBlank
    private String password;
    
    public String getUsrName() {
        return usrName;
    }
    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
 

    
    
}

package com.miporfoliobackend.bar.security.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miporfoliobackend.bar.security.dto.JwtDto;
import com.miporfoliobackend.bar.security.dto.LoginUsuario;
import com.miporfoliobackend.bar.security.dto.NuevoUsuario;
import com.miporfoliobackend.bar.security.entity.Rol;
import com.miporfoliobackend.bar.security.entity.Usuario;
import com.miporfoliobackend.bar.security.enums.RolNombre;
import com.miporfoliobackend.bar.security.jwt.JwtProvider;
import com.miporfoliobackend.bar.security.service.RolService;
import com.miporfoliobackend.bar.security.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passEncoder;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    UsuarioService usrService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

   
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Error en datos ingresados"), HttpStatus.BAD_REQUEST);
        }
        if(usrService.existsByusrName(nuevoUsuario.getUsrName())){
            return new ResponseEntity(new Mensaje("Nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(usrService.existsByusrEmail(nuevoUsuario.getUsrEmail())){
            return new ResponseEntity(new Mensaje("Nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }

        Usuario usr = new Usuario(nuevoUsuario.getUsrNombre(), nuevoUsuario.getUsrName(),
        nuevoUsuario.getUsrEmail(), passEncoder.encode(nuevoUsuario.getUsrPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

        if (nuevoUsuario.getUsrRoles().contains("admin")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        usr.setRoles(roles);
        usr.setPersona(nuevoUsuario.getUsrPersona());
        usrService.save(usr);

        return new ResponseEntity<>(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login (@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Error en datos ingresados"), HttpStatus.BAD_REQUEST);
        }

        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginUsuario.getUsrName(), loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(auth);
        
        String jwt = jwtProvider.generateToken(auth);

        UserDetails usrDetails = (UserDetails) auth.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, usrDetails.getUsername(),usrDetails.getAuthorities());

        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }
}

package com.miporfoliobackend.bar.security.jwt;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.miporfoliobackend.bar.security.entity.UsuarioPrincipal;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtProvider.class);
    private static final long EXPIRE_DURATION = 1*60*60*1000;

    @Value("${jwt.secret}")
    private String secret;  

    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
        .setExpiration(new Date(new Date().getTime()+EXPIRE_DURATION))
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
    }

    public String getUsrNameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try{
            
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e){
            LOGGER.error("Token mal formado");
        } catch (UnsupportedJwtException e){
            LOGGER.error("Token no soportado");
        } catch (ExpiredJwtException e){
            LOGGER.error("Token expirado");
        } catch (IllegalArgumentException e){
            LOGGER.error("Token vacio");
        } catch (SignatureException e){
            LOGGER.error("Firma no valida");
        }
        return false;
    }
}

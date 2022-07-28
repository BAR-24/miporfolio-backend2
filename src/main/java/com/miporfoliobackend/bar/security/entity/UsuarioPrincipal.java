package  com.miporfoliobackend.bar.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioPrincipal implements UserDetails  {

    private String usrNombrePrin;
    private String usrNamePrin;
    private String usrEmailPrin;
    private String usrPassPrin;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(String usrNombrePrin, String usrNamePrin, String usrEmailPrin, String usrPassPrin,
            Collection<? extends GrantedAuthority> authorities) {
        this.usrNombrePrin = usrNombrePrin;
        this.usrNamePrin = usrNamePrin;
        this.usrEmailPrin = usrEmailPrin;
        this.usrPassPrin = usrPassPrin;
        this.authorities = authorities;
    }
    
    public static  UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                                .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
                                .collect(Collectors.toList());
    
        return new UsuarioPrincipal(usuario.getUsrNombre(),usuario.getUsrName(),usuario.getUsrEmail(),usuario.getUsrPass(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        return authorities;
    }

    @Override
    public String getPassword() {
        
        return usrPassPrin;
    }

    @Override
    public String getUsername() {
        
        return usrNamePrin;
    }

    public String getNombre() {
        
        return usrNombrePrin;
    }

    public String getEmail() {
        
        return usrEmailPrin;
    }

    @Override
    public boolean isAccountNonExpired() {
        
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
     
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      
        return true;
    }

    @Override
    public boolean isEnabled() {
        
        return true;
    }

    


}
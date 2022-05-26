package br.ufmt.web.curso.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.ufmt.web.curso.usuario.Usuario;
import br.ufmt.web.curso.usuario.UsuarioRepository;

@Component
public class CustomUserDetailsService 
  implements UserDetailsService {

  @Autowired
  private UsuarioRepository rep;

  @Override
  public UserDetails loadUserByUsername(
      String username) 
      throws UsernameNotFoundException 
  {
    Usuario user = rep.findByUsername(username);
    return new User(
      user.getUsername(), 
      user.getPassword(), 
      Collections.emptyList()
    );
  }

}

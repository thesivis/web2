package br.ufmt.web.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufmt.web.curso.dtos.JwtResponse;
import br.ufmt.web.curso.dtos.LoginDTO;
import br.ufmt.web.curso.security.TokenAuthenticationService;
import br.ufmt.web.curso.usuario.Usuario;
import br.ufmt.web.curso.usuario.UsuarioRepository;

@RestController
@RequestMapping("/login")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  private UsuarioRepository rep;

  @PostMapping
  public ResponseEntity<JwtResponse> autenticarUsuario(@RequestBody LoginDTO login) {
    String username = login.getUsername();
    String password = login.getPassword();
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(username, password));
    Usuario user = rep.findByUsername(username);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = TokenAuthenticationService.gerarJWTToken(username);
    return ResponseEntity.ok(new JwtResponse(jwt, user.getId(), user.getUsername()));
  }
}
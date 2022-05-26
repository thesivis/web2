package br.ufmt.web.curso.usuario;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface UsuarioRepository 
  extends JpaRepositoryImplementation
  <Usuario, Long>
{
  public Usuario findByUsername(
    String username);
}

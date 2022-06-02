package br.ufmt.web.curso.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
  private String token;
  private Long id;
  private String username;
}

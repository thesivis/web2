package br.ufmt.web.curso.dtos;

import lombok.Data;

@Data
public class LoginDTO {
  private String username;
  private String password;
}

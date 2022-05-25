package br.ufmt.web.curso.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class DisciplinaDTO {

  @NotEmpty
  @Size(max = 100)
  private String nome;

}

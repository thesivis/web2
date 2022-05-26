package br.ufmt.web.curso.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Usuario  {

  @Id
  @GenericGenerator(name = "seq_gen", 
    strategy = "increment")
  @GeneratedValue(
    strategy = GenerationType.AUTO, 
    generator = "seq_gen")
  private Long id;
  private String username;
  private String password;
}

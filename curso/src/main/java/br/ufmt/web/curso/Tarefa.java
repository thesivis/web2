package br.ufmt.web.curso;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tarefa")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tarefa {
  @Id
  @EqualsAndHashCode.Include
  private Long id;
  private String descricao;
  @Column(name = "finalizacao")
  private boolean finalizado;
  @Temporal(TemporalType.DATE)
  @Column(name="data_finalizacao",
   nullable = true)
  private Calendar dataFinalizacao;

  @ManyToOne(cascade = CascadeType.ALL)
  @JsonIgnoreProperties("tarefas")
  private Disciplina disciplina;

}

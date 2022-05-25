package br.ufmt.web.curso;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@SequenceGenerator(
  name = "id_seq",
  sequenceName = "seq_id_disciplina",
  allocationSize = 1
)
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Disciplina implements Serializable {

  @Id
  @GeneratedValue(
    generator = "id_seq",
    strategy = GenerationType.SEQUENCE
  )
  @EqualsAndHashCode.Include
  private Long id;
  private String nome;

  @OneToMany(
    mappedBy = "disciplina"
  )
  @JsonIgnoreProperties("disciplina")
  private List<Tarefa> tarefas;
}

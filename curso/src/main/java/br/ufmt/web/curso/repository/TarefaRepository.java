package br.ufmt.web.curso.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.ufmt.web.curso.Tarefa;

public interface TarefaRepository 
  extends JpaRepositoryImplementation<Tarefa, Long> {
  
}

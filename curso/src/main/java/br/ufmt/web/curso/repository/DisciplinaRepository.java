package br.ufmt.web.curso.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.ufmt.web.curso.Disciplina;

public interface DisciplinaRepository
  extends JpaRepositoryImplementation
    <Disciplina,Long> {
  
}

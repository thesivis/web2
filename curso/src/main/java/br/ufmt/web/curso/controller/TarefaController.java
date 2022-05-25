package br.ufmt.web.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufmt.web.curso.Tarefa;
import br.ufmt.web.curso.repository.TarefaRepository;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {
  @Autowired
  private TarefaRepository rep;

  @GetMapping
  public List<Tarefa> index(){
    return rep.findAll();
  }
}

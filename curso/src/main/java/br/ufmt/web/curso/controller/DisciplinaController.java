package br.ufmt.web.curso.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufmt.web.curso.Disciplina;
import br.ufmt.web.curso.dtos.DisciplinaDTO;
import br.ufmt.web.curso.repository.DisciplinaRepository;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {
  
  @Autowired
  private DisciplinaRepository rep;

  @GetMapping
  public List<Disciplina> index(){
    return rep.findAll();
  }

  @PostMapping
  public ResponseEntity<Disciplina> salvar(
      @RequestBody @Valid DisciplinaDTO dto
    ){
      Disciplina novo = new Disciplina();
      novo.setNome(dto.getNome());
      novo = rep.save(novo);
      return ResponseEntity.ok().body(novo);
  }
}

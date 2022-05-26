package br.ufmt.web.curso.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public List<Disciplina> index() {
    return rep.findAll();
  }

  @PostMapping
  public ResponseEntity<Disciplina> salvar(
      @RequestBody @Valid DisciplinaDTO dto) {
    Disciplina novo = new Disciplina();
    novo.setNome(dto.getNome());
    novo = rep.save(novo);
    return ResponseEntity.ok().body(novo);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(
      @RequestBody @Valid DisciplinaDTO dto,
      @PathVariable Long id) {
    Optional<Disciplina> opDisc = rep.findById(id);
    if (opDisc.isPresent()) {
      Disciplina disc = opDisc.get();
      disc.setNome(dto.getNome());
      disc = rep.save(disc);
      return ResponseEntity.ok().body(disc);
    }
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body("Entidade não encontrada!");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(
    @PathVariable Long id) {
    Optional<Disciplina> opDisc = rep.findById(id);
    if (opDisc.isPresent()) {
      try {
        rep.deleteById(id);
        return ResponseEntity.ok()
          .body("Removido com sucesso!");
      } catch (Exception e) {
        return ResponseEntity
          .status(HttpStatus.BAD_REQUEST)
          .body("Entidade não removida!");
      }
    }
    return ResponseEntity
      .status(HttpStatus.NOT_FOUND)
      .body("Entidade não encontrada!");
  }
}

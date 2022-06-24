using System.Collections.Generic;
using Br.Ufmt.Web.Curso.Repository;
using Microsoft.AspNetCore.Mvc;

namespace Br.Ufmt.Web.Curso.Controller
{
  [ApiController]
  [Route("api/[controller]")]
  public class DisciplinaController
  {
    private IDisciplinaRepository rep;

    public DisciplinaController(IDisciplinaRepository rep)
    {
      this.rep = rep;
    }

    [HttpGet]
    public ActionResult<List<Disciplina>> index()
    {
      return rep.findAll();
    }

    [HttpGet("{id}")]
    public ActionResult<Disciplina> get(int id)
    {
      return rep.findById(id);
    }

        [HttpPost]
    public ActionResult<Disciplina> add([FromBody] Disciplina disciplina)
    {
      return rep.adicionar(disciplina);
    }

    [HttpPut("{id}")]
    public ActionResult<Disciplina> edit(int id, [FromBody] Disciplina disciplina)
    {
      return rep.atualizar(disciplina);
    }

    [HttpDelete("{id}")]
    public ActionResult<bool> delete(int id)
    {
      rep.deleteById(id);
      return true;
    }
  }
}
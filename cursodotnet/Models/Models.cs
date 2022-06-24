using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace Br.Ufmt.Web.Curso
{
  public class Disciplina
  {
    [Key]
    [Column("id")]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public long Id { get; set; }

    [Column("nome")]
    public string Nome { get; set; }
    public List<Tarefa> Tarefas { get; set; }
  }


  public class Tarefa
  {
    [Key]
    [Column("id")]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public long Id { get; set; }

    [Column("descricao")]
    public string Descricao { get; set; }

    [Column("finalizacao")]
    public bool Finalizado { get; set; }

    [Column("data_finalizacao")]
    public DateTime DataFinalizacao { get; set; }

    [Column("disciplina_id")]
    public long DisciplinaId { get; set; }
    [JsonIgnore]
    public Disciplina Disciplina { get; set; }
  }

  public class Usuario
  {
    [Key]
    [Column("id")]
    public long Id { get; set; }

    [Column("username")]
    public string Username { get; set; }

    [Column("password")]
    public string Password { get; set; }
  }
}
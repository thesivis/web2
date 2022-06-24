using Microsoft.EntityFrameworkCore;

namespace Br.Ufmt.Web.Curso
{
  public class CursoContext : DbContext
  {
    public DbSet<Disciplina> Disciplinas { get; set; }
    public DbSet<Tarefa> Tarefas { get; set; }
    public DbSet<Usuario> Usuarios { get; set; }

    public CursoContext(DbContextOptions<CursoContext> op) : base(op)
    {
    }
    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
      modelBuilder.UseHiLo("seq_id_disciplina");
      modelBuilder.Entity<Disciplina>().ToTable("disciplina");
      modelBuilder.Entity<Tarefa>().ToTable("tarefa");
      modelBuilder.Entity<Usuario>().ToTable("usuario");
    }
  }
}
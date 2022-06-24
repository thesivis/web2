namespace Br.Ufmt.Web.Curso.Repository
{
  public interface ITarefaRepository : IRepository<Tarefa, long>
  {  }

  public class TarefaRepository : Repository<Tarefa, long>, ITarefaRepository
  {
    public TarefaRepository(CursoContext context) : base(context)
    {
    }
  }
}
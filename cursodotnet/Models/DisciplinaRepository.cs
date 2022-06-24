namespace Br.Ufmt.Web.Curso.Repository
{
  public interface IDisciplinaRepository : IRepository<Disciplina, long>
  { }

  public class DisciplinaRepository : Repository<Disciplina, long>, IDisciplinaRepository
  {
    public DisciplinaRepository(CursoContext context) : base(context)
    {
    }
  }
}
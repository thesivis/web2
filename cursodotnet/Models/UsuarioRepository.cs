using System.Linq;

namespace Br.Ufmt.Web.Curso.Repository
{
  public interface IUsuarioRepository : IRepository<Usuario, long>
  {
    public Usuario findByName(string username);
    public Usuario findByNameAndPassword(string username, string password);
  }

  public class UsuarioRepository : Repository<Usuario, long>, IUsuarioRepository
  {
    public UsuarioRepository(CursoContext context) : base(context)
    {
    }
    public Usuario findByName(string username)
    {
      return db.First(u => u.Username == username);
    }

    public Usuario findByNameAndPassword(string username, string password)
    {
      var user = this.findByName(username);
      if (BCrypt.Net.BCrypt.Verify(password, user.Password,false,BCrypt.Net.HashType.SHA256))
      {
        return user;
      }
      return null;
    }
  }
}
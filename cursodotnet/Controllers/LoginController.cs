using System.Threading.Tasks;
using Br.Ufmt.Web.Curso.Repository;
using Br.Ufmt.Web.Curso.Security;
using Microsoft.AspNetCore.Mvc;
using Br.Ufmt.Web.Curso.DTO;

namespace Br.Ufmt.Web.Curso.Controller
{
  [ApiController]
  public class LoginController
  {
    private IUsuarioRepository rep;
    public LoginController(IUsuarioRepository rep)
    {
      this.rep = rep;
    }

    [HttpPost]
    [Route("login")]
    public async Task<ActionResult<dynamic>> index([FromBody] User user)
    {
      var usuario = rep.findByNameAndPassword(user.username, user.password);
      if (usuario == null)
        return new NotFoundObjectResult(new { message = "Usuário ou senha inválidos" });

      var token = TokenService.GenerateToken(usuario);
      return new { token = token };
      }
    }
}
using System;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using Microsoft.IdentityModel.Tokens;

namespace Br.Ufmt.Web.Curso.Security
{
  public class Settings
  {
    public static string SECRET;
    public static long EXPIRATION;
  }

    public class TokenService
  {
    public static string GenerateToken(Usuario usuario)
    {
      var tokenHandler = new JwtSecurityTokenHandler();
      var key = Encoding.UTF8.GetBytes(Settings.SECRET);
      var tokenDescriptor = new SecurityTokenDescriptor
        {
          Subject = new ClaimsIdentity(new Claim[]
            {
              new Claim(ClaimTypes.Name, usuario.Username.ToString())
            }),
            Expires = DateTime.Now.AddMilliseconds(Settings.EXPIRATION),
            SigningCredentials = new SigningCredentials(new SymmetricSecurityKey(key), SecurityAlgorithms.HmacSha256Signature)
        };
      var token = tokenHandler.CreateToken(tokenDescriptor);
      return tokenHandler.WriteToken(token);
    }
  }

}
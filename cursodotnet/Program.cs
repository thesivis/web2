using Br.Ufmt.Web.Curso;
using Br.Ufmt.Web.Curso.Repository;
using Microsoft.EntityFrameworkCore;
using System.Text;
using Br.Ufmt.Web.Curso.Security;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.IdentityModel.Tokens;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
builder.Services.AddDbContext<CursoContext>(op => 
  op.UseNpgsql(builder.Configuration.GetConnectionString("ldbCon")));

builder.Services.AddScoped<IDisciplinaRepository, DisciplinaRepository>();
builder.Services.AddScoped<ITarefaRepository, TarefaRepository>();
builder.Services.AddScoped<IUsuarioRepository, UsuarioRepository>();

// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle

Settings.SECRET = builder.Configuration["jwtConfig:secret"];
Settings.EXPIRATION = long.Parse(builder.Configuration["jwtConfig:expiration"]);

builder.Services.AddAuthentication(x =>
  {
    x.DefaultAuthenticateScheme = JwtBearerDefaults.AuthenticationScheme;
    x.DefaultChallengeScheme = JwtBearerDefaults.AuthenticationScheme;
  })
  .AddJwtBearer(x =>
    {
      x.RequireHttpsMetadata = false;
      x.SaveToken = true;
      x.TokenValidationParameters = new TokenValidationParameters
        {
          ValidateIssuerSigningKey = true,
          IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(Settings.SECRET)),
          ValidateIssuer = false,
          ValidateAudience = false
        };
    });

var app = builder.Build();

//app.UseHttpsRedirection();

//No metodo Configure
app.UseRouting();
app.UseCors(x => x
    .AllowAnyOrigin()
    .AllowAnyMethod()
    .AllowAnyHeader());
app.UseAuthentication();

app.UseAuthorization();

app.MapControllers();

app.Run();

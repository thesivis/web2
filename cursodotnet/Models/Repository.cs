using System.Collections.Generic;
using System.Linq;
using Microsoft.EntityFrameworkCore;

namespace Br.Ufmt.Web.Curso.Repository
{
  public interface IRepository<E, Id>
  {
    public E adicionar(E e);
    public E atualizar(E e);
    public E findById(Id id);
    public void deleteById(Id id);
    public List<E> findAll();
  }

  public class Repository<E, Id> : IRepository<E, Id> where E : class
  {
    protected CursoContext context;
    protected DbSet<E> db;

    public Repository(CursoContext context)
    {
      this.context = context;
      this.db = context.Set<E>();
    }
        public void deleteById(Id id)
    {
      db.Remove(db.Find(id));
      context.SaveChanges();
    }
    public List<E> findAll()
    {
      return db.ToList();
    }
    public E findById(Id id)
    {
      return db.Find(id);
    }
    public E adicionar(E e)
    {
      var ret = db.Add(e);
      context.SaveChanges();
      return ret.Entity;
    }
    public E atualizar(E e)
    {
      var ret = db.Update(e);
      context.SaveChanges();
      return ret.Entity;
    }
  }
}
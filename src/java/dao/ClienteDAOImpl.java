package dao;

import cdi.DAOQualifier;
import entidades.Cliente;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@DAOQualifier
public class ClienteDAOImpl implements ClienteDAO {

    @Inject
    private EntityManagerFactory fabrica;

    public void save(Cliente cliente) {
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        System.out.println(cliente.getClass().getSimpleName());
        if (cliente.getId() > 0) {
            em.merge(cliente);
        } else {
            em.persist(cliente);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Cliente cliente){
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        if(!em.contains(cliente)){
            cliente = em.merge(cliente);
        }
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();
    }
    
    public Cliente find(int id){
        EntityManager em = fabrica.createEntityManager();
        return em.find(Cliente.class, id);
    }
    
    public List<Cliente> list(){
        EntityManager em = fabrica.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Cliente c");
        return q.getResultList();
    }

}

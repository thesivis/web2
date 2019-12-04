package dao;

import entidades.Cliente;
import java.util.List;

public interface ClienteDAO {
    
    public void save(Cliente cliente);

    public void delete(Cliente cliente);

    public Cliente find(int id);

    public List<Cliente> list();
    
}

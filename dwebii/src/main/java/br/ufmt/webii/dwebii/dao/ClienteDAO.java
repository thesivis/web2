
package br.ufmt.webii.dwebii.dao;

import br.ufmt.webii.dwebii.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
    
}

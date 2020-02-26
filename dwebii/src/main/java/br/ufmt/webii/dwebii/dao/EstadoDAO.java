package br.ufmt.webii.dwebii.dao;

import br.ufmt.webii.dwebii.entidades.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoDAO extends CrudRepository<Estado, Integer>{
    
    public Estado findBySigla(String sigla);
    
}

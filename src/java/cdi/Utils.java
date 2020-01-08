
package cdi;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utils {
    
    @Produces
    public EntityManagerFactory criarFabrica(){
        EntityManagerFactory factory 
            = Persistence
                .createEntityManagerFactory("jarewebPU");
        return factory;
    }
    
}

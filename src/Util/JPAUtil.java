
package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Junnio
 */
public class JPAUtil {
    private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoPDSDesktopPU");
    
    public static EntityManager getEntityManager() {
        return emf.createEntityManager(); 
    }
}

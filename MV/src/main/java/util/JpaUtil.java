package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Cleiton
 *
 *	A classe JPAUtil tem a funcionalidade de disponibilizar as EntityManager(conex�es com o banco de dados)
 *Tamb�m � uma classe sington, s� vai existir uma instancia dessa classe no projeto todo 
 *
 */

public class JpaUtil {

	private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("MV");
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void close() {
        factory.close();
    }
}

package utilities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 794473
 */
public class DBUtil {
   

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("CPU");

    /**
     *
     * @return
     */
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}

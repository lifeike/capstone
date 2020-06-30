package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Roles;
import utilities.DBUtil;
/**
 * @author 794473 - Amitoj Singh
 * @author 798125 - Ram Odedara
 */
public class RoleDB {

    /**
     *
     * @param roleID
     * @return Role by id
     */
    public Roles getRole(int roleID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Roles role = em.find(Roles.class, roleID);
            return role;
        } finally {
            em.close();
        }
    }
    
    /**
     *
     * @return All Roles list
     * @throws Exception
     */
    public List<Roles> getAll() throws Exception 
      {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            
            List<Roles> roless = em.createNamedQuery("Roles.findAll", Roles.class).getResultList();
            return roless;
            
        } finally {
            em.close();
        }

    }
}

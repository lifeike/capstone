package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Provinces;
import utilities.DBUtil;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class ProvinceListDB {

    /**
     *
     * @return All province list
     * @throws Exception
     */
    public List<Provinces> getAll() throws Exception {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Provinces> prov = em.createNamedQuery("Provinces.findAll", Provinces.class).getResultList();
            return prov;

        } finally {
            em.close();
        }

    }

    /**
     *
     * @param id
     * @return Province by id
     */
    public Provinces getProvince(int id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Provinces prov = em.find(Provinces.class, id);
            return prov;
        } finally {
            em.close();
        }
    }
}

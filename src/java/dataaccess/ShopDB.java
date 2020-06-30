package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Item;
import utilities.DBUtil;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class ShopDB {

    /**
     *
     * @return All Items
     * @throws Exception
     */
    public List<Item> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Item> item = em.createNamedQuery("Item.findAll", Item.class).getResultList();
            return item;
        } finally {
            em.close();
        }

    }
}

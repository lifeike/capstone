package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Item;
import utilities.DBUtil;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class ItemsDB {

    /**
     *
     * @return All Active Inventory
     * @throws Exception
     */
    public List<Item> getAllActive() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Item> item = em.createNamedQuery("Item.findByStatus", Item.class)
                    .setParameter("status", true).getResultList();
            return item;
        } finally {
            em.close();
        }

    }

    /**
     *
     * @return All Inactive Inventory
     * @throws Exception
     */
    public List<Item> getAllInactive() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Item> item = em.createNamedQuery("Item.findByStatus", Item.class)
                    .setParameter("status", false).getResultList();
            return item;
        } finally {
            em.close();
        }

    }

    /**
     *
     * @param upsc
     * @return Item by upsc
     */
    public Item getItem(String upsc) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Item item = em.find(Item.class, upsc);
            return item;
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param item
     */
    public void insert(Item item) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();
        try {
            em.persist(item);
            trans.commit();

        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }

    }

    /**
     *
     * Will update Item
     *
     *
     * @param item
     * @throws Exception
     */
    public void update(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(item);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

}

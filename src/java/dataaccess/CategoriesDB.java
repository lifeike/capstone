package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Category;
import utilities.DBUtil;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class CategoriesDB {

    /**
     *
     * @return the list of all categories
     * @throws Exception
     */
    public List<Category> getAll() throws Exception {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Category> cat = em.createNamedQuery("Category.findAll", Category.class).getResultList();
            return cat;

        } finally {
            em.close();
        }

    }

    /**
     *
     * @param category
     */
    public void insert(Category category) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();
        try {
            em.persist(category);
            trans.commit();

        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }

    }

    /**
     *
     * @param CategoryID
     * @return Category from id
     */
    public Category getCategory(int CategoryID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Category category = em.find(Category.class, CategoryID);
            return category;
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param category
     * @throws Exception
     */
    public void update(Category category) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(category);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

}

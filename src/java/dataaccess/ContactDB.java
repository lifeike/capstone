package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Contact;
import utilities.DBUtil;

/**
 *
 * @author 794473 - Amitoj Singh
 *
 */
public class ContactDB {

    /**
     *
     * @return The contact messages
     * @throws Exception
     */
    public List<Contact> getAll() throws Exception {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Contact> c = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
            return c;

        } finally {
            em.close();
        }

    }

    /**
     *
     * @param c
     */
    public void insert(Contact c) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();
        try {
            em.persist(c);
            trans.commit();

        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
}

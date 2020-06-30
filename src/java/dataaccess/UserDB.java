package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Provinces;
import models.Roles;
import models.User;
import utilities.DBUtil;

/**
 *
 * @author 794473 - Amitoj Singh
 * @author 798125 - Ram Odedara
 */
public class UserDB {

    /**
     *
     * @return All Users
     * @throws Exception
     */
    public List<User> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<User> users = em.createNamedQuery("User.findAll", User.class).getResultList();
            return users;
        } finally {
            em.close();
        }
    }

    /**
     *
     * @return All inactive Users
     * @throws Exception
     */
    public List<User> getAllInactive() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<User> users = em.createNamedQuery("User.findByStatus", User.class)
                    .setParameter("status", false).getResultList();
            return users;
        } finally {
            em.close();
        }

    }

    /**
     *
     * @param email
     * @return User by email
     * @throws Exception
     */
    public User getUser(String email) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }
    }

    /**
     * Will insert user
     *
     * @param user
     */
    public void insert(User user) {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            Roles role = user.getRole();
            role.getUserList().add(user);

            Provinces prov = user.getProvince();
            prov.getUserList().add(user);

            trans.begin();

            em.persist(user);

            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }

    }

    /**
     * Will update user
     *
     * @param user
     * @throws Exception
     */
    public void update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param uuid
     * @return User by uuid
     */
    public User getByUUID(String uuid) {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {

            User u = em.createNamedQuery("User.findByResetpassworduuid", User.class)
                    .setParameter("passwordResetUUID", uuid).getSingleResult();

            return u;
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param uuid
     * @return Find user by activation uuid
     */
    public User getByUUIDactivate(String uuid) {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {

            User u = em.createNamedQuery("User.findByActivationUUID", User.class)
                    .setParameter("activationUUID", uuid).getSingleResult();

            return u;
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param uuid
     * @return Find user by reset uuid
     */
    public User getByUUIDreset(String uuid) {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {

            User u = em.createNamedQuery("User.findByPasswordResetUUID", User.class)
                    .setParameter("passwordResetUUID", uuid).getSingleResult();

            return u;
        } finally {
            em.close();
        }
    }

}

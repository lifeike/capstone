package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Item;
import models.OrderItem;
import models.Orders;
import models.Provinces;
import models.User;
import utilities.DBUtil;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class OrdersDB {

    /**
     *
     * @return All orders
     * @throws Exception
     */
    public List<Orders> getAll() throws Exception {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Orders> orders = em.createNamedQuery("Orders.findAll", Orders.class).getResultList();
            return orders;

        } finally {
            em.close();
        }

    }

    /**
     *
     * @param orderNumder
     * @return
     */
    public Orders getOrder(String orderNumder) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Orders order = em.find(Orders.class, orderNumder);
            return order;
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param order
     */
    public void Add(Orders order) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {

            Provinces prov = order.getShipProvince();
            prov.getOrdersList().add(order);

            User user = order.getCustomer();
            user.getOrdersList().add(order);

            Item item = new Item();
            List<OrderItem> list = order.getOrderItemList();

            for (int i = 0; i < list.size(); i++) {
                item = list.get(i).getItem();
                item.getOrderItemList().add(list.get(i));
            }

            trans.begin();

            em.merge(item);

            em.persist(order);

            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }

    }

    /**
     *
     * @param order
     * @throws Exception
     */
    public void update(Orders order) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(order);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

}

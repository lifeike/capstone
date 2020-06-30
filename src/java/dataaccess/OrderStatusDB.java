package dataaccess;

import javax.persistence.EntityManager;
import models.OrderStatus;
import utilities.DBUtil;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class OrderStatusDB {

    /**
     *
     * @param id
     * @return Status by id
     */
    public OrderStatus getStatus(int id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            OrderStatus status = em.find(OrderStatus.class, id);
            return status;
        } finally {
            em.close();
        }
    }

}

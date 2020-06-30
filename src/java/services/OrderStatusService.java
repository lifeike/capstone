package services;

import dataaccess.OrderStatusDB;
import models.OrderStatus;

/**
 *
 * @author 794473
 */
public class OrderStatusService {
    
    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public OrderStatus getStatus(int id) throws Exception {
        OrderStatusDB db = new OrderStatusDB();

       OrderStatus status = db.getStatus(id);
        return status;

        }
    
}

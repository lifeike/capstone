package services;

import dataaccess.OrderStatusDB;
import dataaccess.OrdersDB;
import java.util.List;
import models.OrderStatus;
import models.Orders;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class OrderService {

    /**
     *
     * @return @throws Exception
     */
    public List<Orders> getAll() throws Exception {

        OrdersDB db = new OrdersDB();
        List<Orders> orderList;
        orderList = db.getAll();

        return orderList;
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Orders getOrder(String id) throws Exception {
        OrdersDB db = new OrdersDB();
        Orders order = db.getOrder(id);
        return order;
    }

    /**
     *
     * @param order
     * @throws Exception
     */
    public void AddOrder(Orders order) throws Exception {
        OrdersDB odb = new OrdersDB();
        OrderStatusDB odcb = new OrderStatusDB();

        OrderStatus orderstat = odcb.getStatus(1);
        order.setOrderstat(orderstat);

        odb.Add(order);

    }

    /**
     *
     * @param id
     * @param comapny
     * @param tno
     * @throws Exception
     */
    public void AddShip(String id, String comapny, String tno) throws Exception {
        OrdersDB odb = new OrdersDB();

        OrderStatusDB os = new OrderStatusDB();

        Orders order = odb.getOrder(id);
        order.setShipCompany(comapny);
        order.setTrackingnumber(tno);

        OrderStatus stat = os.getStatus(3);

        order.setOrderstat(stat);

        odb.update(order);

    }

    /**
     *
     * @param id
     * @throws Exception
     */
    public void Cancel(String id) throws Exception {
        OrdersDB odb = new OrdersDB();

        OrderStatusDB os = new OrderStatusDB();

        Orders order = odb.getOrder(id);

        OrderStatus stat = os.getStatus(2);

        order.setOrderstat(stat);

        odb.update(order);

    }

}

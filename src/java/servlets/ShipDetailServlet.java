package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Provinces;
import services.ProvinceListService;
import java.util.List;
import javax.servlet.http.HttpSession;
import models.OrderItem;
import models.OrderStatus;
import models.Orders;
import models.User;
import services.OrderStatusService;
import services.UserService;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class ShipDetailServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProvinceListService ps = new ProvinceListService();

        try {
            List<Provinces> provs = ps.getAll();
            request.setAttribute("provList", provs);

        } catch (Exception ex) {
            //to be handeled later
        }

        getServletContext().getRequestDispatcher("/WEB-INF/shippingdetails.jsp").forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProvinceListService ps = new ProvinceListService();
        OrderStatusService oss = new OrderStatusService();
        UserService us = new UserService();

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        HttpSession session = request.getSession();

        switch (action) {

            case "confirm": {
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String postalcode = request.getParameter("postalcode");
                String city = request.getParameter("city");
                String sprovince = request.getParameter("province");
                int province = Integer.parseInt(sprovince);
                int stat = 1;

                Orders order = (Orders) session.getAttribute("order");

                if (order == null) {
                    order = new Orders();
                }

                order.setPhone(phone);
                order.setShipCity(city);
                order.setShipfname(fname);
                order.setShiplname(lname);
                order.setShipPostalCode(postalcode);
                order.setShipAddress(address);

                try {
                    Provinces prov = ps.getProvince(province);
                    order.setShipProvince(prov);
                } catch (Exception ex) {
                    // to be handled later
                }

                try {
                    OrderStatus stats = oss.getStatus(stat);
                    order.setOrderstat(stats);
                } catch (Exception ex) {
                    //tbhl
                }

                order.setOrderDate(new Date());

                Date date = Calendar.getInstance().getTime();
                DateFormat formatter = new SimpleDateFormat("yyMMddhhmmssSSSSSSS");
                String orderid = formatter.format(date);

                order.setOrderNumber(orderid);

                String customer = (String) session.getAttribute("email");
                User user;
                try {
                    user = us.get(customer);
                    order.setCustomer(user);
                } catch (Exception ex) {
                    //tbhl
                }

                double pretax = (Double) session.getAttribute("pre");

                double shipcost = 0;
                if (pretax < 100) {
                    shipcost = 15;
                }

                order.setShipCost(shipcost);

                double taxp = order.getShipProvince().getTaxPercentage();

                double tax = pretax / 100 * taxp;

                double afterTaxAndShipping = pretax + tax + shipcost;

                order.setOrderTotal(afterTaxAndShipping);

                List<OrderItem> oilist = (List<OrderItem>) session.getAttribute("cart");

                for (int i = 0; i < oilist.size(); i++) {
                    {
                        oilist.get(i).setOrderNumber(order);
                        oilist.get(i).setOrderItemRef(order.getOrderNumber() + i);
                    }
                }

                order.setOrderItemList(oilist);

                session.setAttribute("order", order);

            }
        }

        response.sendRedirect("orderConfirmation");

    }

}

package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Orders;
import services.OrderService;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class OrderListServlet extends HttpServlet {

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

        OrderService os = new OrderService();
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        boolean transfer = false;
        switch (action) {

            case "moreDetails": {
                String id = request.getParameter("idValue");

                if (id == null) {
                    response.sendRedirect("orderlist");
                }

                session.setAttribute("oid", id);
                transfer = true;
            }
        }

        List<Orders> orders;

        try {

            orders = os.getAll();
            request.setAttribute("orderList", orders);
        } catch (Exception ex) {
            //To be handled later
        }

        if (transfer == true) {
            response.sendRedirect("orderdetail");

        } else {

            getServletContext()
                    .getRequestDispatcher("/WEB-INF/orderlist.jsp").forward(request, response);
        }
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
        OrderService os = new OrderService();
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        action = action == null ? "" : action;
        List<Orders> orders;

        switch (action) {

            case "cancel": {
                String id = request.getParameter("idValue");

                if (id == null) {
                    response.sendRedirect("orderlist");
                }

            try {
                if(os.getOrder(id).getOrderstat().getStatID().equals(3))
                {
                    request.setAttribute("error", "Cannot Cancel Order, Order Has Been Shipped");
                    break;
                }
            } catch (Exception ex) {
               //
            }
            try {
                os.Cancel(id);
            } catch (Exception ex) {
                //
            }
            }
        }

        try {

            orders = os.getAll();
            request.setAttribute("orderList", orders);
        } catch (Exception ex) {
            //To be handled later
        }
        getServletContext()
                .getRequestDispatcher("/WEB-INF/orderlist.jsp").forward(request, response);

    }

}

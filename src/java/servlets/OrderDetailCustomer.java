package servlets;

import java.io.IOException;
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
public class OrderDetailCustomer extends HttpServlet {

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
        HttpSession session = request.getSession();

        String orderID = (String) session.getAttribute("cid");

        OrderService os = new OrderService();

        if (orderID == "" || orderID == null) {
            response.sendRedirect("customerOrder");

        }

        try {

            Orders order = os.getOrder(orderID);

            request.setAttribute("orderDetail", order);
        } catch (Exception ex) {
            // to be handled later
        }

        getServletContext().getRequestDispatcher("/WEB-INF/orderdetailcustomer.jsp").forward(request, response);
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

    }

}

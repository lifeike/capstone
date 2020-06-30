package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.OrderItem;
import models.Orders;
import services.AccountService;
import services.InventoryService;
import services.OrderService;

/**
 *
 * @author 794473 - Amitoj Singh
 */

public class CheckoutServlet extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/WEB-INF/checkout.jsp").forward(request, response);

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
        InventoryService ins = new InventoryService();
        AccountService as = new AccountService();

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        HttpSession session = request.getSession();

        switch (action) {

            case "placeOrder": {
                Orders order = (Orders) session.getAttribute("order");
                if (order == null) {
                    response.sendRedirect("/shop");
                }

                try {
                    os.AddOrder(order);
                    as.oce(order.getCustomer().getEmail(), order.getOrderDate().toString(),
                            order.getOrderNumber(),Double.toString(order.getOrderTotal()),getServletContext().getRealPath("/WEB-INF"));
                    
                               
                } catch (Exception ex) {
                    //tbhl
                }
                
              order=null;
              session.setAttribute("order",order);
              List<OrderItem> oilist = (List<OrderItem>) session.getAttribute("cart");
              oilist=null;
              session.setAttribute("cart",oilist);
              
              double pretax = (double) session.getAttribute("pre");
              pretax=0;
              session.setAttribute("pre",pretax);
              
              String count =  "0";
              session.setAttribute("cartcount", count);
              
              
              
            }
        }
        
        response.sendRedirect("/shop");

    }
}

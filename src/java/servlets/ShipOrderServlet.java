package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.OrderStatus;
import services.OrderService;
import services.OrderStatusService;

/**
 *
 * @author 794473
 */
public class ShipOrderServlet extends HttpServlet {

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
        OrderStatusService oss = new OrderStatusService();
        OrderStatus des;

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {

            case "ship": {

                String id = request.getParameter("on");
                request.setAttribute("edit", true);
                request.setAttribute("sval", id);
                break;
            }
        }

        try {
            des = oss.getStatus(1);
            request.setAttribute("var", des);
        } catch (Exception ex) {
            //
        }

        getServletContext().getRequestDispatcher("/WEB-INF/ship.jsp").forward(request, response);
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

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        OrderService os = new OrderService();

        switch (action) {
            case "ship-order": {
                String on = request.getParameter("onn");
                String comname = request.getParameter("company");
                String tno = request.getParameter("tn");

                try {
                    os.AddShip(on, comname, tno);
                } catch (Exception ex) {
                    //tbhl
                }

            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/ship.jsp").forward(request, response);
    }

}

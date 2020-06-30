package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.UserService;

/**
 *
 * @author 794473
 */
public class OrderListCustomer extends HttpServlet {

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

        UserService us = new UserService();
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        boolean transfer = false;

        switch (action) {

            case "moreDetails": {
                String id = request.getParameter("idValue");

                if (id == null) {
                    response.sendRedirect("corderlist");
                }

                session.setAttribute("cid", id);
                transfer = true;
            }
        }

        String email = (String) session.getAttribute("email");
        User user;
        try {
            user = us.get(email);
            request.setAttribute("user", user);

        } catch (Exception ex) {
            //tbhl
        }
        if (transfer == true) {
            response.sendRedirect("corderdetail");

        } else {
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/orderlistcustomer.jsp").forward(request, response);
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

    }

}

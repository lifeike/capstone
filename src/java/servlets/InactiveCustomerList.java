package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.UserService;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class InactiveCustomerList extends HttpServlet {

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
        try {
            List<User> iausers = us.getAllInactive();
            request.setAttribute("iausers", iausers);
        } catch (Exception ex) {

        }

        getServletContext().getRequestDispatcher("/WEB-INF/inactive.jsp")
                .forward(request, response);
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

        String email = request.getParameter("email");

        UserService us = new UserService();

        switch (action) {
            case "setactive":
                try {
                    us.activate(email);
                } catch (Exception e) {
                }
                break;
        }

        try {
            List<User> iausers = us.getAllInactive();
            request.setAttribute("iausers", iausers);
        } catch (Exception ex) {

        }
        getServletContext().getRequestDispatcher("/WEB-INF/inactive.jsp")
                .forward(request, response);
    }

}

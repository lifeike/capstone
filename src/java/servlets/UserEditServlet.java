package servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.UserService;
import static utilities.PasswordUtil.getSalt;
import static utilities.PasswordUtil.hashAndSaltPassword;

/**
 *
 * @author 794473
 */
public class UserEditServlet extends HttpServlet {

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
        String email = (String) session.getAttribute("email");

        String action = request.getParameter("action");
        action = action == null ? "" : action;
        
        boolean direct=false;

        switch (action) {

            case "deactivate":

                try {
                    us.deactivate(email);
                    session.invalidate();

                } catch (Exception ex) {

                }
                response.sendRedirect("login");
               direct=true;
                break;

        }

        if (direct = false) {
            getServletContext().getRequestDispatcher("/WEB-INF/useraccountedit.jsp").forward(request, response);
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
        UserService us = new UserService();

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        try {
            request.setAttribute("user", us.get(email));
        } catch (Exception ex) {
            request.setAttribute("error", "An unexpected error occured !");
        }

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {
            case "up":
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String pcode = request.getParameter("pcode");
                String city = request.getParameter("city");
                String password = request.getParameter("password");
                String provid = request.getParameter("prov");

                String value = " ";
                String newpassword = "";

                 {
                    try {
                        if (!password.equals(us.get(email).getPassword())) {
                            try {
                                value = getSalt();
                                newpassword = hashAndSaltPassword(password, value);
                            } catch (NoSuchAlgorithmException ex) {
                                //tbhl
                            }
                            password = newpassword;
                        }
                    } catch (Exception ex) {

                    }
                }

                try {
                    us.updateProfile(email, fname, lname, password, value, phone, address, pcode, city, provid);

                    response.sendRedirect("profile");
                    return;
                } catch (Exception ex) {
                    //tbhl
                }
                break;

        }

        getServletContext().getRequestDispatcher("/WEB-INF/customerProfile.jsp").forward(request, response);
    }

}

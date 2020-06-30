package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Provinces;
import models.Roles;
import models.User;
import services.ProvinceListService;
import services.RoleService;
import services.UserService;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class CustomerServlet extends HttpServlet {

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
        RoleService rs = new RoleService();
        ProvinceListService pls = new ProvinceListService();

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {

            case "modify": {

                String email = request.getParameter("modifyID");

                request.setAttribute("edit", true);

                try {
                    request.setAttribute("pc", us.get(email));
                    
                } catch (Exception ex) {
                    // To be handled later
                }
            }
        }

        List<User> users;
        try {

            users = us.getAll();
            request.setAttribute("userList", users);
        } catch (Exception ex) {
            //To be handled later
        }

        try {
            List<Roles> roles = rs.getAll();
            request.setAttribute("role", roles);
        } catch (Exception e) {

        }

        try {
            List<Provinces> prov = pls.getAll();
            request.setAttribute("provinces", prov);
        } catch (Exception e) {
            // to be handled later
        }

        getServletContext().getRequestDispatcher("/WEB-INF/customerlist.jsp").forward(request, response);

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

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {

            case "modify": {

                String email = request.getParameter("email");
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String pcode = request.getParameter("pcode");
                String city = request.getParameter("city");
                String provid = request.getParameter("prov");
                String rid = request.getParameter("roles");

                try {
                    us.updateByAdmin(email, fname, lname, phone, address, pcode, city, provid, rid);
                } catch (Exception ex) {
                    // To be handled later
                }
            }
        }

        List<User> users;
        try {

            users = us.getAll();
            request.setAttribute("userList", users);
        } catch (Exception ex) {
            //To be handled later
        }

        getServletContext().getRequestDispatcher("/WEB-INF/customerlist.jsp").forward(request, response);
    }

}

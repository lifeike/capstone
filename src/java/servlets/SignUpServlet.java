package servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Provinces;
import services.AccountService;
import services.ProvinceListService;
import services.UserService;
import static utilities.PasswordUtil.getSalt;
import static utilities.PasswordUtil.hashAndSaltPassword;

/**
 *
 * @author 794473
 */
public class SignUpServlet extends HttpServlet {

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

        String uuid = null;
        AccountService as = new AccountService();

        uuid = request.getParameter("uuid");

        if (uuid != null) {

            try {
                as.welcome(uuid, getServletContext().getRealPath("/WEB-INF"));
            } catch (Exception ex) {
            }

            as.activate(uuid);

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }
        
        
        try {
            List<Provinces> provs = ps.getAll();
            request.setAttribute("provList", provs);

        } catch (Exception ex) {
            //to be handeled later
        }

        getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp")
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

                
        UserService us = new UserService();

        String action = request.getParameter("action");
        action = action == null ? "" : action;
        
        AccountService as = new AccountService();

        switch (action) {
            case "add": {
                String newpassword = " ";
                String value = " ";
                String email = request.getParameter("email");
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String password = request.getParameter("password");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String postalcode = request.getParameter("postalcode");
                String city = request.getParameter("city");
                String province = request.getParameter("province");
                
                int iprovince = Integer.parseInt(province);

                value = getSalt();
                try {
                    newpassword = hashAndSaltPassword(password, value);
                } catch (NoSuchAlgorithmException ex) {
                    //tbhl
                }
                us.insert(email, fname, lname, newpassword, value, phone, address, postalcode, city, iprovince);
                
                String url = request.getRequestURL().toString();
            try {
                as.activateaccountlink(email, getServletContext().getRealPath("/WEB-INF"), url);
            } catch (Exception ex) {
                //tbhl
            }
            
            request.setAttribute("error", "Account Successfully Created, "
                      + "An activation link will be sent please confirm email to access account");

                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }

        }
    }

}

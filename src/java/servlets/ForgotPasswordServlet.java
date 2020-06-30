package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;
import static utilities.PasswordUtil.getSalt;
import static utilities.PasswordUtil.hashAndSaltPassword;

/**
 *
 * @author 794473
 */
public class ForgotPasswordServlet extends HttpServlet {

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

        String uuid = null;
        uuid = request.getParameter("uuid");
        if (uuid == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/forgotpassword.jsp").forward(request, response);
        } else {
            request.setAttribute("uuid", uuid);
            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
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

        AccountService as = new AccountService();

       

        String url = request.getRequestURL().toString();

        String email = request.getParameter("email");
        String action = request.getParameter("action");

        String hashedPassword = "";
        String salt = "";

        if (action.equals("reset")) {
            try {
                as.resetPassword(email, getServletContext().getRealPath("/WEB-INF"), url);
            } catch (Exception ex) {
                
            }
        }
        if (action.equals("resp")) {
            String newpassword = request.getParameter("respassword");
             String uuid = request.getParameter("uuid");
            try {
                salt = getSalt();
                hashedPassword = hashAndSaltPassword(newpassword, salt);
                as.changePassword(uuid, hashedPassword, salt);
            } catch (Exception ex) {
                
            }

        }
        request.setAttribute("error", "Further instruction will be sent via email if account "
                + "exists");
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}

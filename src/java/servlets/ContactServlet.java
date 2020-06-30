package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ContactService;

/**
 *
 * @author 794473
 */
public class ContactServlet extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/WEB-INF/contact.jsp")
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

        ContactService cs = new ContactService();

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String message = request.getParameter("message");

        switch (action) {
            case "add": {
                cs.add(name, email, message);

                break;
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/contact.jsp")
                .forward(request, response);
    }

}

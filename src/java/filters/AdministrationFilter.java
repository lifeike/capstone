package filters;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import models.Roles;
import models.User;
import services.UserService;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class AdministrationFilter implements Filter {

    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest hsr = (HttpServletRequest) request;
        HttpSession session = hsr.getSession();

        String email = (String) session.getAttribute("email");

        UserService us = new UserService();

        try {
            User u = us.get(email);
            Roles r = u.getRole();

            String roledes = r.getRoleDescription();

            if (!roledes.contains("Admin")) {

                HttpServletResponse hsre = (HttpServletResponse) response;

                hsre.sendRedirect("shop");

                return;
            }
        } catch (Exception ex) {

        }

        chain.doFilter(request, response);
    }

    /**
     * Nor Used
     */
    public void destroy() {
        //not used
    }

    /**
     * Not used
     *
     * @param filterConfig
     */
    public void init(FilterConfig filterConfig) {
        // not used
    }
}

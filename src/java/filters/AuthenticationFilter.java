package filters;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class AuthenticationFilter implements Filter {

    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest h = (HttpServletRequest) request;
        HttpSession session = h.getSession();

        if (session.getAttribute("email") == null) {

            HttpServletResponse hsre = (HttpServletResponse) response;

            hsre.sendRedirect("login");

            return;
        }
        chain.doFilter(request, response);

    }

    /**
     * Not Used
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //not used
    }

    /**
     * Not Used
     */
    @Override
    public void destroy() {
        //not used
    }

}

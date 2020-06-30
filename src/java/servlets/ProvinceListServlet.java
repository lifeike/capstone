package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Provinces;
import services.ProvinceListService;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class ProvinceListServlet extends HttpServlet {

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
        
        ProvinceListService pls =  new ProvinceListService();
        
         try {
            List<Provinces> prov = pls.getAll();
            request.setAttribute("provinces", prov);
        } catch (Exception e) {
            // to be handled later
        }
        getServletContext().getRequestDispatcher("/WEB-INF/provincelist.jsp").forward(request, response);
        
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

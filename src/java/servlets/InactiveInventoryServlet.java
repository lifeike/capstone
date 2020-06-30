
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Item;
import services.InventoryService;

/**
 *
 * @author 794473
 */
public class InactiveInventoryServlet extends HttpServlet {

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
   
         InventoryService ins = new InventoryService();
       
            try {
            List<Item> ia = ins.getAllInactive();
            request.setAttribute("iainventory", ia);
        } catch (Exception ex) {

        }
            
              getServletContext().getRequestDispatcher("/WEB-INF/inactiveInventory.jsp")
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

        String id = request.getParameter("id");

        InventoryService ins = new InventoryService();

        switch (action) {
            case "setactive":
                try {
                    ins.activate(id);
                } catch (Exception e) {
                }
                break;
        }

        try {
          List<Item> ia = ins.getAllInactive();
            request.setAttribute("iainventory", ia);
        } catch (Exception ex) {

        }
        getServletContext().getRequestDispatcher("/WEB-INF/inactiveInventory.jsp")
                .forward(request, response);
    }

}

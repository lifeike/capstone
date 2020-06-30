package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Category;
import services.CategoryService;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class CategoryServlet extends HttpServlet {

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
        
        CategoryService cns = new CategoryService();
        
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        
        
        switch (action) {
            
            case "clear": {
                request.setAttribute("edit", false);
                break;
            }
            
            case "editcategory": {
                int id = Integer.parseInt(request.getParameter("categoryselected"));

                request.setAttribute("edit", true);

                try {
                    request.setAttribute("catid", cns.getCategory(id));
                } catch (Exception e) {
                    // to be handled later
                }

                break;
            }
        }
        
        
     try {
            List<Category> cat = cns.getAll();
            request.setAttribute("categories", cat);
        } catch (Exception e) {
            // to be handled later
        }
        getServletContext().getRequestDispatcher("/WEB-INF/category.jsp").forward(request, response);
           
      
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
        
        CategoryService cns = new CategoryService();
        
        String newcatname = request.getParameter("newcatname");
        String catname = request.getParameter("addcategoryname");

        String action = request.getParameter("action");
        action = action == null ? "" : action;
        
        switch (action) {
            case "addcategory": {
                cns.add(catname);
                break; // to be handled later
            }
            
            case "editcategory": {
                String stringid = request.getParameter("editcategoryidval");
                int id = Integer.parseInt(stringid);
                try {
                    cns.update(id, newcatname);
                } catch (Exception ex) {
                    //to be handled later
                }
                break;
            }
        }
        
        try {
            List<Category> cat = cns.getAll();
            request.setAttribute("categories", cat);
        } catch (Exception e) {
            // to be handled later
        }
        getServletContext().getRequestDispatcher("/WEB-INF/category.jsp").forward(request, response);
       
    }

}

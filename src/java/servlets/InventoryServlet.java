package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Category;
import models.Item;
import services.CategoryService;
import services.InventoryService;
import services.Search;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class InventoryServlet extends HttpServlet {

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

        CategoryService cas = new CategoryService();

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {

            case "modify": {

                String id = request.getParameter("modifyID");

                request.setAttribute("edit", true);

                try {
                    request.setAttribute("pc", ins.get(id));

                } catch (Exception ex) {
                    // To be handled later
                }
            }
            case "de": {
                String product = request.getParameter("deid");
                try {
                    ins.deactivate(product);
                } catch (Exception ex) {
                    //tbhl
                }
            }

        }

        try {

            List<Item> item = ins.getAllActive();
            request.setAttribute("itemList", item);

            List<Category> cate = cas.getAll();
            request.setAttribute("cateList", cate);

        } catch (Exception e) {
            // To be handled later
        }

        getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp")
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

        InventoryService ins = new InventoryService();
        CategoryService cas = new CategoryService();
        
        boolean list =false;

        String imageLink = request.getParameter("imageLink");
        String link = "products/" + imageLink;
        String upsc = request.getParameter("upsc");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        String strcost = request.getParameter("cost");
        double cost = 0;
        if (strcost != null) {
            cost = Double.parseDouble(strcost);
        }

        String strretailcost = request.getParameter("retail");
        double retailcost = 0;
        if (strretailcost != null) {
            retailcost = Double.parseDouble(strretailcost);
        }
        String strquantity = request.getParameter("quantity");
        int quantity = 0;
        if (strquantity != null) {
            quantity = Integer.parseInt(strquantity);
        }

        String strcategoryID = request.getParameter("category");
        int categoryID = 0;
        if (strcategoryID != null) {
            categoryID = Integer.parseInt(strcategoryID);
        }

        String action = request.getParameter("action");
        action = action == null ? "" : action;
        
        List<Item> searchResult = null;

        switch (action) {
            case "add": {
                ins.add(upsc, name, description, cost, retailcost, categoryID, link, quantity);

                break;
            }

            case "modify": {

                try {
                    if (link.equals("products/")) {

                        link = ins.get(upsc).getImageLink();
                    }
                    ins.update(upsc, name, description, cost, retailcost, categoryID, link, quantity);
                    list=false;
                } catch (Exception ex) {
                    // To be Handled Later
                }
                break;
            }

            case "search": {
                // call search method from item service
                Search search = new Search();
                try {
                    searchResult = search.searchResult(request.getParameter("searchItem"));
                    request.setAttribute("itemList", searchResult);
                    list = true;
                } catch (Exception ex) {
                    //tbhl
                }

            }
        }

        if (list == false) {
            try {

                List<Item> items = ins.getAllActive();
                request.setAttribute("itemList", items);
                List<Category> cate = cas.getAll();
                request.setAttribute("cateList", cate);

            } catch (Exception e) {
                // To be handled later
            }
        }

        // set result to display on the jsp 
        getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp")
                .forward(request, response);

    }

}

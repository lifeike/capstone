package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Item;
import models.OrderItem;
import services.ShopItemService;
import services.ShopService;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class ShopServlet extends HttpServlet {

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
 
        ShopService ss = new ShopService();
        
         HttpSession session = request.getSession();
        
        String count = (String)  session.getAttribute("cartcount");
        if (count == null)
        {
            count="0";
            session.setAttribute("cartcount", count);
        }
        

        try {

            List<Item> item = ss.getAll();
            request.setAttribute("shop", item);

        } catch (Exception e) {
            // To be handled later
        }

        getServletContext()
                .getRequestDispatcher("/WEB-INF/shop.jsp")
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
        HttpSession session = request.getSession();

        ShopService ss = new ShopService();

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        double pretax = 0;

        switch (action) {
            case "add": {

                int quantity = 0;

                String upsc = request.getParameter("itemcode");

                String squantity = request.getParameter("quantity");
                quantity = Integer.parseInt(squantity);

                ShopItemService sis = new ShopItemService();

                OrderItem oi = new OrderItem();

                Item i = new Item();

                try {
                    i = sis.getItem(upsc);
                } catch (Exception ex) {
                    //to be handled later
                }

                oi.setItem(i);

                List<OrderItem> oilist = (List<OrderItem>) session.getAttribute("cart");

                if (oilist == null) {
                    oilist = new ArrayList<>();

                    double price = i.getCost() * quantity;

                    oi.setQuantity(quantity);
                    oi.setCost(i.getCost());
                    oi.setOrdertotal(price);

                    oilist.add(oi);

                    pretax += price;

                } else {
                    boolean changed = false;
                    for (int b = 0; b < oilist.size(); b++) {
                        if (oilist.get(b).getItem().getUpsc().equals(oi.getItem().getUpsc())) {

                            int preQuantity = oilist.get(b).getQuantity();
                            int newQuantity = preQuantity + quantity;
                            oilist.get(b).setQuantity(newQuantity);

                            double price = i.getCost() * (newQuantity - preQuantity);

                            double orderPrice = i.getCost() * newQuantity;

                            oilist.get(b).setOrdertotal(orderPrice);

                            pretax = (double) session.getAttribute("pre");
                            pretax += price;
                            changed = true;

                        }
                    }
                    if (changed != true) {
                        pretax = (double) session.getAttribute("pre");
                        double price = i.getCost() * quantity;

                        oi.setQuantity(quantity);
                        oi.setOrdertotal(price);
                        oi.setCost(i.getCost());

                        oilist.add(oi);

                        pretax += price;
                    }

                }
                String count =  String.valueOf(oilist.size());

                session.setAttribute("cartcount", count);
                session.setAttribute("pre", pretax);
                session.setAttribute("cart", oilist);
                

            }

        }

        try {

            List<Item> item = ss.getAll();
            request.setAttribute("shop", item);

        } catch (Exception e) {
            // To be handled later
        }

        getServletContext().getRequestDispatcher("/WEB-INF/shop.jsp")
                .forward(request, response);
    }

}

package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Item;
import models.OrderItem;
import services.ShopService;

/**
 *
 * @author 794473 - Amitoj Singh
 */
public class ShoppingCartServlet extends HttpServlet {

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

        HttpSession session = request.getSession();
        ShopService ss = new ShopService();

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {
            case "remove": {
                double pre;
                String upsc = request.getParameter("removeid");

                List<OrderItem> oilist = (List<OrderItem>) session.getAttribute("cart");

                OrderItem oi = new OrderItem();

                Item i = new Item();

                i.setUpsc(upsc);
                oi.setItem(i);

                double ex = 0;

                for (int b = 0; b < oilist.size(); b++) {
                    if (oilist.get(b).getItem().getUpsc().equals(oi.getItem().getUpsc())) {
                        ex = oilist.get(b).getOrdertotal();
                        oilist.remove(b);
                    }
                }
                pre = (double) session.getAttribute("pre");

                pre -= ex;

                String count = String.valueOf(oilist.size());

                session.setAttribute("cartcount", count);

                session.setAttribute("pre", pre);

            }
        }

        try {

            List<Item> item = ss.getAll();
            request.setAttribute("shop", item);

        } catch (Exception e) {
            // To be handled later
        }

        getServletContext()
                .getRequestDispatcher("/WEB-INF/cart.jsp")
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

    }

}

package servlets;

import cupcake.Cake_bottoms;
import cupcake.Cake_toppings;
import cupcake.Cupcake;
import cupcake.CupcakeList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import usersearch.Searcher;
import databaseConnect.DAO;
import datasource.DataSource1;
import entity.Users;
import static java.lang.System.out;

import shoppingCart.ShoppingCart;

@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    Searcher search;
    DataSource1 ds1 = new DataSource1();
    DAO dao = new DAO(ds1.getDataSource());
    int amount = 0;
    String bottom;
    String topping;
    Users user;
    CupcakeList cl;
    ShoppingCart cart = new ShoppingCart();
    int price = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(request.getParameter("origin"));

        switch (request.getParameter("origin")) {
            case "login": {
                {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    Users user = dao.validateUser(username, password);

                    request.getSession().setAttribute("user", user);

                    //request.getRequestDispatcher("user.jsp").forward(request, response);
                    this.user = user;
                    user.setCart(cart);
                    price = user.getCart().getTotalPrice();
                    response.sendRedirect("validatelogin.jsp");

                }
            }
            break;
            case "registration": {
                System.out.println("registration");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String balance = request.getParameter("balance");
                System.out.println(balance);

                int number = Integer.parseInt(balance);
                //String email = request.getParameter("email");
                //Boolean.parseBoolean(request.getParameter("admin"));
                //search.alreadyExist(username);
                dao.createUser(new Users(username, password, number));

                response.sendRedirect("index.jsp");

            }
            break;
            case "products": {

                System.out.println("products");
                Cake_bottoms bottom = new Cake_bottoms(request.getParameter("cake_bottom"));
                Cake_toppings topping = new Cake_toppings(request.getParameter("cake_topping"));
                this.topping = request.getParameter("cake_topping");
                this.bottom = request.getParameter("cake_bottom");
                amount = Integer.parseInt(request.getParameter("amount"));
                price += (dao.getCakeBottomPrice(bottom.toString()) + dao.getCakeBottomPrice(topping.toString())) * amount;
                Cupcake cake = new Cupcake(topping, bottom, price, amount);
                user.getCart().cupcakeList.add(new CupcakeList(topping.toString(), bottom.toString(), price, amount));
                user.getCart().shoppingCartAdd(cake, amount);

                System.out.println(user.getCart().getShoppingCart());
                if (request.getParameter("add") != null) {
                    response.sendRedirect("products.jsp");
                }
                //  else response.sendRedirect("confirmation.jsp");
            }
            break;
            case "confirmation": {
                System.out.println("confirmation");

            }
        }
        try (PrintWriter out = response.getWriter()) {

            user.setCart(cart);
            // System.out.println(user.getCart().printCart());
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");
            out.println("<link href=\"stylesheet.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Order info " + request.getContextPath() + "</h1>");
            out.println("<center>");
            out.println("Amount: " + amount);;
            out.println("<br>");
            out.println("Topping: " + topping);
            out.println("<br>");
            out.println("Bottom: " + bottom);
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("Shoppingcart: <br>");
            for (Cupcake cake : user.getCart().getShoppingCart()) {
                out.print("<table border = " + 1 + ">");
                out.print("<tr>");
                out.print("<td>" + cake.getTopping() + "</td>");
                out.print("<td>" + cake.getBottom() + "</td>");
                out.print("<td>" + cake.getAmount() + "</td>");
                out.print("<td>" + cake.getTotalPrice() + "</td>");
                out.print("</tr>");
                //out.print("/table");
            }
            out.print("Total:" + user.getCart().getTotalPrice());
            //out.println(user.getCart().getShoppingCart() +"<br><br><br><br><br>");

            out.println("</center>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

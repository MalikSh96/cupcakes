package servlets;

import calculator.Calculator;
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
import databaseConnect.DAO;
import datasource.DataSource1;
import entity.Users;

import shoppingCart.ShoppingCart;

@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    DataSource1 ds1 = new DataSource1();
    DAO dao = new DAO(ds1.getDataSource());
    String bottom;
    String topping;
    Users u;
    CupcakeList cl;
    ShoppingCart cart = new ShoppingCart();
    Calculator calc = new Calculator();
    int price = 0;
    int amount = 0;

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

                    this.u = user;
                    if (user != null) {
                        user.setCart(cart);
                    }

                    response.sendRedirect("validatelogin.jsp");

                }
            }
            break;
            case "registration": {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String balance = request.getParameter("balance");

                int number = Integer.parseInt(balance);
                //String email = request.getParameter("email");
                Users u;

                dao.createUser(u = new Users(username, password, number));
                System.out.println(u.getId());
                u.setId(u);
                System.out.println(u.getId());
                response.sendRedirect("login.jsp");

            }
            break;
            case "products": {

                price = 0;
                Cake_bottoms bottom = new Cake_bottoms(request.getParameter("cake_bottom"));
                Cake_toppings topping = new Cake_toppings(request.getParameter("cake_topping"));
                this.topping = request.getParameter("cake_topping");
                this.bottom = request.getParameter("cake_bottom");
                amount = Integer.parseInt(request.getParameter("amount"));
                price += (dao.getCakeBottomPrice(bottom.toString()) + dao.getCakeToppingPrice(topping.toString()));
                Cupcake cake = new Cupcake(topping, bottom, price, amount);

                System.out.println(u.getCart().getShoppingCart());
                if (request.getParameter("add") != null) {
                    u.getCart().cupcakeList.add(new CupcakeList(topping.toString(), bottom.toString(), price, amount));
                    u.getCart().cupcakeAdd(cake);
                    response.sendRedirect("products.jsp");
                }
            }
            break;
            case "delete": {

                String username = request.getParameter("username");
                dao.deleteUser(username);
                response.sendRedirect("admin.jsp");

            }
        }
        try (PrintWriter out = response.getWriter()) {
            if (u != null) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Servlet</title>");
                out.println("<link href=\"stylesheet.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("</head>");
                out.println("<body>");

                out.println("<div class=\"navbar\">");
                out.println("<a href=\"index.jsp\">Home</a>");
                out.println("<a href=\"userpage.jsp\">Your profile</a>");
                out.println("<a href=\"products.jsp\">Products</a>");
                out.println("</div>");

                out.println("<h1>Order info " + request.getContextPath() + "</h1>");
                out.println("<center>");
                out.println("Shoppingcart: <br>");
                for (Cupcake cake : u.getCart().getShoppingCart()) {
                    out.print("<table border = " + 1 + ">");
                    out.print("<tr>");
                    out.print("<td>" + cake.getTopping() + "</td>");
                    out.print("<td>" + cake.getBottom() + "</td>");
                    out.print("<td>" + cake.getAmount() + "</td>");
                    out.print("<td>" + cake.getPrice() * cake.getAmount() + "</td>");
                    out.print("</tr>");
                }
                out.println("<br>");

                out.println("</center>");
                out.println("<form action=\"calculator.jsp\">");
                out.println("<input type=\"submit\" value=\"Confirm Order\"/>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

            }
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

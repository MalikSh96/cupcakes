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
    Calculator calc = new Calculator();
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
                Users u;
                
                dao.createUser(u = new Users(username, password, number));
                u.setId(u);
                response.sendRedirect("index.jsp");

            }
            break;
            case "products": {

                price = 0;
                System.out.println("products");
                Cake_bottoms bottom = new Cake_bottoms(request.getParameter("cake_bottom"));
                Cake_toppings topping = new Cake_toppings(request.getParameter("cake_topping"));
                this.topping = request.getParameter("cake_topping");
                this.bottom = request.getParameter("cake_bottom");
                amount = Integer.parseInt(request.getParameter("amount"));
                price += (dao.getCakeBottomPrice(bottom.toString()) + dao.getCakeToppingPrice(topping.toString()));
                Cupcake cake = new Cupcake(topping, bottom, price, amount);

                System.out.println(user.getCart().getShoppingCart());
                if (request.getParameter("add") != null) {
                    user.getCart().cupcakeList.add(new CupcakeList(topping.toString(), bottom.toString(), price, amount));
                    user.getCart().shoppingCartAdd(cake, amount);
                    response.sendRedirect("products.jsp");

                }
                //  else response.sendRedirect("confirmation.jsp");
            }
            break;
            case "confirmation": {
                System.out.println("confirmation");
        //        dao.updateUserBalance(user);
                calc.calculatePrice(user);
       //         dao.updateUserBalance(user);
                break;
            }
            case "calculator": {          
                System.out.println("calculator");   
                dao.updateUserBalance(user);
                System.out.println(user.getBalance());
                response.sendRedirect("confirmation.jsp");
                break;
            }
        }
        try (PrintWriter out = response.getWriter()) {
if(user != null) {
           // user.setCart(cart);
            //System.out.println(user.getCart().printCart());
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");
            out.println("<link href=\"stylesheet.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Order info " + request.getContextPath() + "</h1>");
            out.println("<center>");
            out.println("Shoppingcart: <br>");
            for (Cupcake cake : user.getCart().getShoppingCart()) {
                out.print("<table border = " + 1 + ">");
                out.print("<tr>");
                out.print("<td>" + cake.getTopping() + "</td>");
                out.print("<td>" + cake.getBottom() + "</td>");
                out.print("<td>" + cake.getAmount() + "</td>");
                out.print("<td>" + cake.getPrice() * cake.getAmount() + "</td>");
                out.print("</tr>");
            }
            //     out.print("Total:" + user.getCart().getTotalPrice());
            //out.println(user.getCart().getShoppingCart() +"<br><br><br><br><br>");

            out.println("</center>");
            out.println("<div id=\"footer\">" + "Total:" + user.getCart().getTotalPrice() + "</div>");
            if (calc.calculatePrice(user)) {
//                calc.calculatePrice(user);
//                dao.updateUserBalance(user);
                out.println("<form action=\"calculator.jsp\">");
                out.println("<input type=\"submit\" value=\"Confirm Order\"/>");
                out.println("</form>");
            } else {
                out.println("<form action=\"insufficient Funds.jsp\">");
                out.println("<input type=\"submit\" value=\"Confirm Order\"/>");
                out.println("</form>");
            }

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

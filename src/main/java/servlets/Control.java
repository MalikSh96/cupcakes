package servlets;

import cupcake.Cake_bottoms;
import cupcake.Cake_toppings;
import cupcake.Cupcake;
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

@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {
    Searcher search;
    DataSource1 ds1 = new DataSource1();
    DAO dao = new DAO(ds1.getDataSource());
    
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
                
                int number= Integer.parseInt(balance);
                //String email = request.getParameter("email");
                //Boolean.parseBoolean(request.getParameter("admin"));
                //search.alreadyExist(username);
                dao.createUser(new Users(username, password, number));
                
                response.sendRedirect("index.jsp");
            
            }
            break;
            case "products": {
                System.out.println("products");
            String bottom = request.getParameter("cake_bottom");
            String topping = request.getParameter("cake_topping");
            
            int amount = Integer.parseInt(request.getParameter("amount"));
            int bottomPrice = dao.getCakeBottomPrice(bottom);
            int toppingPrice = dao.getCakeToppingPrice(topping);
            Cupcake cake = new Cupcake(bottomPrice, toppingPrice, amount);
                System.out.println(cake);
            response.sendRedirect("confirmation.jsp");
            
            
            
            }
            break;
            case "confirmation": {
                System.out.println("confirmation");
                
                
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

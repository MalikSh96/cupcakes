package servlets;

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
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                search.getUsername(username, password);

            }
            break;
            case "registration": {
                System.out.println("registration");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                //String email = request.getParameter("email");
                //Boolean.parseBoolean(request.getParameter("admin"));
                //search.alreadyExist(username);
                dao.createUser(new Users(username, password));
                
                response.sendRedirect("index.jsp");
            
            }
            break;
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

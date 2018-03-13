<%@page import="datasource.DataSource1"%>
<%@page import="calculator.Calculator"%>
<%@page import="entity.Users"%>
<%@page import="databaseConnect.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                   <div class="navbar">
  <a href="index.jsp">Home</a>
  <a href="login.jsp">Log In</a>
  <a href="registration.jsp">Registration</a>
  <a href="userpage.jsp">Your profile</a>
  <a href="products.jsp">Products</a>
</div>
        
        <h1>Calculating...</h1>
        
 <%
            Users user = (Users) session.getAttribute("user");
            Calculator calc = new Calculator();
            DataSource1 ds1 = new DataSource1();
            DAO dao = new DAO(ds1.getDataSource());
            if (calc.calculatePrice(user))
            {
                
                dao.updateUserBalance(user);
                System.out.println(dao.getUserBalance(user));
                response.sendRedirect("confirmation.jsp");               
            }
            else
            {
                out.print("Insufficient Funds");
                response.sendRedirect("insufficient Funds.jsp");
                //user = new Users("Anonymous", "none");
            }
        %>
        
        
        
        
                <form action="Control" method="post">
        <input type="hidden" name="origin" value="calculator" />
        <input type="submit" value="Calc" />
                </form>
        

        
        
        
    </body>
</html>

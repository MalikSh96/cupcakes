<%@page import="entity.Users"%>
<%@page import="databaseConnect.DAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
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
    <center>
        <h1>Order Confirmation</h1>
        
        <form>
        <input type="hidden" name="origin" value="confirmation" />
        </form>
                <%
            Users user = (Users) session.getAttribute("user");
        %>
        <form>
            <p>
                Balance: <%= user.getBalance() %> <br>
            </p>
        </form>
    </center>
        </body>
</html>

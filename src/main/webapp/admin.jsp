<%@page import="entity.Admin"%>
<%@page import="entity.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>Cupcake Shop</title>
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
        <h1>Admin page</h1>
        <%
            Users user = (Users) session.getAttribute("user");
            user.setId(user);
            Admin admin = new Admin();
            admin.nameList();
        %>
        <p>
        
            Logged in as: <%= user.getUsername() %><br>
            Id: <%= user.getId() %><br>
            Password: <%= user.getPassword() %><br>
            Balance: <%= user.getBalance() %> <br>
            
            Admin: <%= user.isAdmin() %><br>
            
            Users: <br><br><%= admin.usernames.toString().replace("[","").replace("]","").replace(",","")%><br>
            
        </p>
    </center>
    </body>
</html>

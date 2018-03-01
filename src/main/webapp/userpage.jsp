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
        <h1>USERPAGE</h1>
        
        <%
            Users user = (Users) session.getAttribute("user");
        %>
        <p>
        
            Logged in as: <%= user.getUsername() %><br>
            Id: <%= user.getId() %><br>
            Password: <%= user.getPassword() %><br>
            Balance: <%= user.getBalance() %> <br>
            Admin: <%= user.isAdmin() %><br>
            
        </p>
    </body>
</html>

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
        </body>
</html>

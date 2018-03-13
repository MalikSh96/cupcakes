<%@page import="datasource.DataSource1"%>
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
            DataSource1 ds1 = new DataSource1();
            DAO dao = new DAO(ds1.getDataSource()); 
            dao.orderID(user);
            user.getCart().setTotalPrice(0);
            user.getCart().shoppingCart.clear();
        %>
        <form>
            <p>
                New balance: <%= dao.getUserBalance(user)%> <br>                
            </p>
            <h2>Return to your profile</h2>
            <div class="order-section">
                <a href ="userpage.jsp"> Profile </a>
            </div>
        </form>
    </center>
</body>
</html>

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
    <body class="prod">
        
        <div class="navbar">
  <a href="index.jsp">Home</a>
  <a href="login.jsp">Log In</a>
  <a href="registration.jsp">Registration</a>
  <a href="userpage.jsp">Your profile</a>
  <a href="products.jsp">Products</a>
</div>
        
        <h1>Products: </h1>

        <%
            Users user = (Users) session.getAttribute("user");
        %>


        <form action="Control" method="post">
            <input type="hidden" name="origin" value="products" />

            <div class="Cake_toppings">
                <label>Select Top</label>
                <select name="cake_topping">
                    <option value="Chocolate"> Chocolate </option>
                    <option value="Blueberry"> Blueberry </option> 
                    <option value="Raspberry"> Raspberry </option> 
                    <option value="Crispy"> Crispy </option> 
                    <option value="Strawberry"> Strawberry </option> 
                    <option value="Rum/Raisin"> Rum/Raisin </option> 
                    <option value="Orange"> Orange </option> 
                    <option value="Lemon"> Lemon </option> 
                    <option value="Blue cheese"> Blue cheese </option> 
                </select>
            </div>
            <div class="Cake_bottoms">
                <label>Select Bottom </label>
                <select name="cake_bottom">
                    <option value="Chocolate">Chocolate</option>
                    <option value="Vanilla">Vanilla</option>
                    <option value="Nutmeg">Nutmeg</option>
                    <option value="Pictacio">Pictacio</option>
                    <option value="Almond">Almond</option>
                </select>
            </div>
            <div class="amount">
                <label> Amount</label><input type="number" name="amount" max="999" required value="0"/>
            </div>

            <div class="submit-button" action="/products.jsp">
                <input type="hidden" name="origin" value="products" />
                <input type ="submit" name="add" value="Add to cart">
            </div>
            <br />
            <div class="submit-button">
                <input type ="submit" value="Checkout">
            </div>
        </form>
    </body>
</html>

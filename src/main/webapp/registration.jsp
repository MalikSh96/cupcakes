
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
        <h1>Registration</h1>
        <h2>Register as user</h2>
        <div class="reg">
        <form id="formCreate" action="Control" method="post">
            <label id="labelUsername" for="username">Username</label>
            <input type="text" name="username" />
            <br />
            <label id="labelPassword" for="password">Password</label>
            <input type="text" name="password" />
            <br />
            <label id="labelBalance" for="Balance">Balance</label>
            <input type="text" name="balance" />
            <br />
            <input type="hidden" name="origin" value="registration" />
            <input type="submit" value="CREATE USER" />
        </div>
        </form>
    </center>
    </body>
</html>

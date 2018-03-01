<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>Cupcake Shop</title>
    </head>
    <body>
        <h1> Home Page</h1>
        
        <h2>Log In</h2>
        
        <form action="Control" method="post">
            <input type="text" name="username" value="" placeholder="Username" />
            <input type="password" name="password" value="" placeholder="Password" />
            <input type="hidden" name="origin" value="login" />
            <input type="submit" value="Log in" />
        </form>
        <div class="order-section">
            
            <a href ="registration.jsp"> Click here to register </a>
        </div>
    </body>
</html>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registration</h1>
        <h2>Register as user</h2>
        
        <form id="formCreate" action="Control" method="post">
            <label id="labelUsername" for="username">Username</label>
            <input type="text" name="username" />
            <label id="labelPassword" for="password">Password</label>
            <input type="text" name="password" />
            
            <label id="labelBalance" for="Balance">Balance</label>
            <input type="text" name="balance" />
            
            <input type="hidden" name="origin" value="registration" />
            <input type="submit" value="CREATE USER" />
        </form>
    </body>
</html>

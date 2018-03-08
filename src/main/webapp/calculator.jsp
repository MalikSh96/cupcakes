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
        <h1>Calculator</h1>
        

        
        
                <form action="Control" method="post">
        <input type="hidden" name="origin" value="calculator" />
        <input type="submit" value="Log in" />
                </form>
        

        
        
        
    </body>
</html>

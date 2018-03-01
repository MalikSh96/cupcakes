<%@page import="entity.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebProject - User</title>
    </head>
    <body>
        
        <h1>USER</h1>
            
        <%
            Users user = (Users) session.getAttribute("user");
            
            if (user != null)
            {
                out.print("Login worked");
                response.sendRedirect("userpage.jsp");
                
                
            }
            else
            {
                out.print("Login failed");
                response.sendRedirect("loginfailed.jsp");
                //user = new Users("Anonymous", "none");
            }
        %>



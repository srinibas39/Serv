

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello JSP Directives</h1>
        <%@include file="./header.jsp" %>
        <%
            Random r = new Random();
            int n = r.nextInt(10); //higher limit
            
        %>
        <p>Random No is <%=n %></p>
 
    </body>
</html>

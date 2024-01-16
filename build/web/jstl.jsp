<%--
    Document   : jstl
    Created on : 15-Jan-2024, 9:18:12 pm
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Hello JSTL</h1>  
    <c:set var='name' value='I am a software engineer'></c:set>
    <c:set var='x' value='10'></c:set>
    <c:set var='country' value='India'></c:set>
    <c:out value='${name}'></c:out>
    <c:out value='${x}'></c:out>
    <c:out value="${country}"></c:out>
    <c:if test="${3>2}">
        <p>Condition is true</p>
    </c:if>
   
    
  
</body>
</html>

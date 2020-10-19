<%-- 
    Document   : register
    Created on : Oct 18, 2020, 3:02:02 AM
    Author     : kornk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="POST">
            Username:
            <input type="text" name="username">
            <input type="hidden" name="action" value="register">            
            <input type="submit" value="Register name">
        </form>
        <c:if test="${logout == true}">
            <p>The user has successfully logged out.</p>
        </c:if>
    </body>
</html>

<%-- 
    Document   : logout
    Created on : 27-okt-2009, 15:45:07
    Author     : practicum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
    </head>
    <body>
        <%session.removeAttribute("username");%>
        <jsp:forward page="index.jsp"/>
    </body>
</html>

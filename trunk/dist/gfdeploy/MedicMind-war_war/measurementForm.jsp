<%-- 
    Document   : measurementForm
    Created on : 12-dec-2009, 13:47:40
    Author     : Birger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MedicMind - Measurement</title>
    </head>
    <body>
        <h2>Measurement</h2>

        <form name="loginform" method="get"  action="<%=request.getContextPath()%>/measurement.jsp">
            Measurement type: <input type="text" name="measurementtype" size="20"/>
            <br/>
            Measurement value: <input type="text" name="measurementvalue" size="20"/>
            <br/>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>

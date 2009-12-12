<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MedicMind - Register</title>
    </head>
    <body>
        <h2>MedicMind</h2>

        <form name="loginform" method="get"  action="<%=request.getContextPath()%>/register.jsp">
            User name: <input type="text" name="username" size="20"/>
            <br/>
            Password: <input type="password" name="password" size="20"/>
            <br/>
            SSN: <input type="text" name="ssn" size="20"/>
            <br/>
            First Name: <input type="text" name="firstname" size="20"/>
            <br/>
            Last Name: <input type="text" name="lastname" size="20"/>
            <br/>
            <input type="submit" value="submit"/>
            <br/>
        </form>
    </body>
</html>

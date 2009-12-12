<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register page</title>
    </head>
    <body>
        <%@ page import="javax.naming.*, ejb.GpRemote" %>

        <%!

        GpRemote gp;

        public void jspInit(){
            try {
                InitialContext ic = new InitialContext();
                gp = (GpRemote) ic.lookup(GpRemote.class.getName());
            }
            catch (Exception e){}
        }
        %>
        <%
            int created = gp.create((String)request.getParameter("ssn"),
                (String)request.getParameter("username"),
                (String)request.getParameter("password"),
                (String)request.getParameter("firstname"),
                (String)request.getParameter("lastname"));
            switch(created){
                case 0: session.setAttribute("username", (String)request.getParameter("username"));
        %>
            <jsp:forward page="main.jsp"/>
        <%
                        break;
                case 1:
        %>
                        <jsp:forward page="index.jsp?error=invalid%20ssn"/>
        <%
                        break;
                case 2:
        %>
                        <jsp:forward page="index.jsp?error=invalid%20username"/>
        <%
                        break;
                case 3:
        %>
                        <jsp:forward page="index.jsp?error=invalid%20password"/>
        <%
                        break;
                case 4:
        %>
                        <jsp:forward page="index.jsp?error=invalid%20firstname"/>
        <%
                        break;
                case 5:
        %>
                        <jsp:forward page="index.jsp?error=invalid%20lastname"/>
        <%
                        break;
            }
        %>
    </body>
</html>
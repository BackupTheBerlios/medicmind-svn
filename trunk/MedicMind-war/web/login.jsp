<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
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
            int authed = gp.authenticate((String)request.getParameter("username"),
                (String)request.getParameter("password"));
            switch(authed){
                case 0: session.setAttribute("username", (String)request.getParameter("username"));
        %>
            <jsp:forward page="main.jsp"/>
        <%
                        break;
                case 1:
        %>
            <jsp:forward page="index.jsp?error=invalid%20user"/>
        <%
                        break;
                case 2:
        %>
            <jsp:forward page="index.jsp?error=invalid%20password"/>
        <%
                        break;
            }
        %>
    </body>
</html>

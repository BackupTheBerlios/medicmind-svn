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
            String username = (String)request.getParameter("username");
            String password = (String)request.getParameter("password");
            int authed = gp.authenticate(username,password);
            switch(authed){
                case 0: session.setAttribute("username", (String)request.getParameter("username"));
                        if(gp.isGp(username,password)){
        %>
                            <jsp:forward page="gp/main.jsp"/>
        <%
                        } else {
        %>
                            <jsp:forward page="patient/main.jsp"/>
        <%
                        }
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

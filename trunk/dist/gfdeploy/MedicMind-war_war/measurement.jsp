<%-- 
    Document   : measurement
    Created on : 12-dec-2009, 13:47:54
    Author     : Birger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medication page</title>
    </head>
    <body>
        <%@ page import="javax.naming.*, ejb.MeasurementRemote" %>

        <%!

        MeasurementRemote mr;

        public void jspInit(){
            try {
                InitialContext ic = new InitialContext();
                mr = (MeasurementRemote) ic.lookup(MeasurementRemote.class.getName());
            }
            catch (Exception e){}
        }
        %>
        <%
            int authed = mr.create((String)request.getParameter("measurementtype"),
                    Integer.parseInt((String)request.getParameter("measurementvalue")),
                    (String)request.getParameter("currentpatient"));
            switch(authed){
                case 0: session.setAttribute("medicationname", (String)request.getParameter("medicationname"));
        %>
            <jsp:forward page="main.jsp"/>
        <%
                        break;
                case 1:
        %>
            <jsp:forward page="medicationForm.jsp?error=invalid%20medicationname"/>
        <%
                        break;
            }
        %>
    </body>
</html>

<%-- 
    Document   : Task
    Created on : 12-dec-2009, 21:54:10
    Author     : Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task</title>
    </head>
    <body>
        <h1>Task</h1>
        <%@ page import="javax.naming.*, ejb.PatientRemote" %>
        <%@ page import="javax.naming.*, ejb.PrescriptionRemote" %>
        <%@ page import= "java.util.List"%>
        <%@ page import= "java.util.ListIterator"%>
        <%
        PatientRemote patient;
        InitialContext ic = new InitialContext();
        patient = (PatientRemote) ic.lookup(PatientRemote.class.getName());
        //patient.getnexttask?
        %>
        <br<a href="patient/Main.jsp">main page</a>
        <a href="logout.jsp">log out</a>
    </body>
</html>

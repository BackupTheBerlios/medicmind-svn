<%-- 
    Document   : PatientList
    Created on : 12-dec-2009, 17:09:57
    Author     : Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PatientList</title>
    </head>
    <body>
        <%@ page import="javax.naming.*, ejb.GpRemote" %>
        <%@ page import="javax.naming.*, ejb.PatientRemote" %>
        <%@ page import= "java.util.List"%>
        <%@ page import= "java.util.ListIterator"%>
        <h1>Lijst van patienten:</h1>
        <%
        GpRemote gp;
        InitialContext ic = new InitialContext();
        gp = (GpRemote) ic.lookup(GpRemote.class.getName());
        List<PatientRemote> patients = (gp.getPatients());
        ListIterator list = patients.listIterator();
        while(list.hasNext()){
            PatientRemote next = (PatientRemote) list.next();%>
            <br/><a href="patient.jsp"> <%= (next.getLastname + " " + next.getFirstname); %></a>
        <%  }%>
        
        <p/>
         <a href="patient.jsp">add new patient</a>
         <p/>
        <a href="gp/Main.jsp">main page</a>
         <a href="logout.jsp">log out</a>
    </body>
</html>

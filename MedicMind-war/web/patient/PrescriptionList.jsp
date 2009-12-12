<%-- 
    Document   : PrescriptionList
    Created on : 12-dec-2009, 21:42:44
    Author     : Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PrescriptionList</title>
    </head>
    <body>
        <h1>Prescriptions for patient</h1>
        <%@ page import="javax.naming.*, ejb.PatientRemote" %>
        <%@ page import="javax.naming.*, ejb.PrescriptionRemote" %>
        <%@ page import= "java.util.List"%>
        <%@ page import= "java.util.ListIterator"%>
        <%
        PatientRemote patient;
        InitialContext ic = new InitialContext();
        patient = (PatientRemote) ic.lookup(PatientRemote.class.getName());
        List<PrescriptionRemote> prescr =patient.getPrescriptions();
        ListIterator listb = prescr.listIterator();
        while(listb.hasNext()){
            PrescriptionRemote next = (PrescriptionRemote) listb.next();
            //printen prescr
          }


        %>
        <br<a href="patient/Main.jsp">main page</a>
        <a href="logout.jsp">log out</a>
    </body>
</html>

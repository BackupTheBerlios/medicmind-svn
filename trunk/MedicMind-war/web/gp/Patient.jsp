<%-- 
    Document   : Patient
    Created on : 12-dec-2009, 20:03:26
    Author     : Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient</title>
    </head>
    <body>
        <%@ page import="javax.naming.*, ejb.PatientRemote" %>
        <%@ page import="javax.naming.*, ejb.MeasurementRemote" %>
        <%@ page import="javax.naming.*, ejb.PrescriptionRemote" %>
        <%@ page import= "java.util.List"%>
        <%@ page import= "java.util.ListIterator"%>
        <%PatientRemote patient = null;// krijg van vorige pagina%>
        <h1>gegevens van <%= patient.getLastname + " " + patient.getFirstname;%></h1>

        SSN:
        <%= patient.getSsn();%>
        Birthday:
        <%= patient.getBirthDay();%>
        Birthday:
        <%= patient.getBirthDay();%>
        Bloodgroup:
        <%= patient.getBloodgroup();%>
        LastConsult:
        <%= patient.getLastconsult();%>
        NextConsult:
        <%= patient.getNextconsult();%>
        Location:
        <%= patient.getLocation();%>

        <%
        List<MeasurementRemote> measurements =patient.getMeasurements;
        ListIterator list = measurements.listIterator();
        while(list.hasNext()){
            MeasurementRemote next = (MeasurementRemote) list.next();
            //printen Measurement
          }
        %>
        <br><a href="/gp/Prescriptions.jsp">prescriptions</a>
        <a href="gp/Main.jsp">main page</a>
        <a href="logout.jsp">log out</a>



        <% // if nieuwe patient: add %>
    </body>
</html>

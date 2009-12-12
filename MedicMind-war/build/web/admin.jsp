<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admininstration</title>
    </head>
    <body>
        <jsp:include page="authenticate.jsp"/>
        <%
            String admin = (String)session.getAttribute("admin");
            if (admin == "false"){
        %>
            <jsp:forward page="main.jsp"/>
        <%}else{%>
        <a href="main.jsp">index</a><br/>
        <h2>Administer here</h2>
        <%
        String mpu = (String)request.getParameter("marksperuser");
        String mpp = (String)request.getParameter("marksperpicture");
        if(mpu != null){
            business.Marks.setMaxMarksPerUser(Integer.parseInt(mpu));
        }
        if(mpp != null){
            business.Marks.setMaxMarksPerPicture(Integer.parseInt(mpp));
        }
      %>
        <form action="admin.jsp" method="post">
            <table>
                <tr>
                    <td>Number of marks to be given per user: </td>
                    <td><input type="text" name="marksperuser" value="<%= business.Marks.getMaxMarksPerUser() %>"/></td>
                </tr>
            
                <tr>
                    <td>Number of marks to be given per picture: </td>
                    <td><input type="text" name="marksperpicture" value="<%= business.Marks.getMaxMarksPerPicture() %>"/></td>
                </tr>
                
            </table>
            <br/>
            <input type="submit" value="submit"/>
        </form>
        
        <p/><a href="logout.jsp">logout</a>
        <%}%>
    </body>
</html>

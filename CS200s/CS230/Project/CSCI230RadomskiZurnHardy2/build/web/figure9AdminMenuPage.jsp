<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginAdmin.jsp"%>
<html>
    <head>
        <title>Administrator Menu</title>
    </head>
        <%
    String un = (String) session.getAttribute("currentUser");
    User currentUser = AdminController.getSpecificUser(un);
    %>
    <body background="Images/cmc3.jpg"><center>
       <h1>Welcome <%=currentUser.getFirstName()%>!</h1><br>
        <a href="figure10ManageUniversitiesOption.jsp">Manage Universities</a><br>
        <a href="figure13ManageUsersOption.jsp">Manage Users</a><br>
        </center>
    </body>
</html>
<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginAdmin.jsp"%>
<html>
    <head>
       <title>Deactivate User Action Page</title>
    </head>
    <body>
        <%
        String deacUser = request.getParameter("User");
        AdminController.deactivateUser(deacUser);
        response.sendRedirect("figure13ManageUsersOption.jsp");
        %>
    </body>
</html>

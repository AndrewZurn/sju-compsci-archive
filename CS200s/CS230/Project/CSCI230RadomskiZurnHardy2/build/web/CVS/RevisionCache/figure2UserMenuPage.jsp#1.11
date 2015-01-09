<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginUser.jsp"%>
<html>
<head>
<title>User Menu</title>
</head>
<body background="Images/cmc3.jpg" style="height: 72px;"><center>
    <%
    String un = (String)session.getAttribute("currentUser");
    User currentUser1 = AdminController.getSpecificUser(un);
    %>
    <h1>Welcome <%=currentUser1.getFirstName()%>!</h1><br>
<a href="figure6SchoolSearchMenu.jsp">Search for Schools</a><br>
<a href="figure4ManageSavedSchoolsPage.jsp">Manage My Saved Schools</a><br>
<a href="figure3ViewEditUser.jsp">Manage My Profile</a><br>
<%
    String anyErrors = request.getParameter("Error");
    if(anyErrors!=null){
        if (anyErrors.equals("-2")){
            out.println("<h3>YOU HAVE NO SAVED SCHOOLS</h3>");
        }
        if (anyErrors.equals("3")){
            out.println("User Information Updated");
        }
    }
%>
<br>
</center>
</body>
</html>

<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginUser.jsp"%>
<html>
    <head>
        <title>Remove Action</title>
    </head>
    <body>
        <%
            String fromwho = request.getParameter("From2");

            String schoolName = request.getParameter("School");
            String userName = (String) session.getAttribute("currentUser");
            UserController.removeUserSchool(DatabaseController.getID(userName), schoolName);


            if (fromwho != null && fromwho.equals("2")) {
                response.sendRedirect("figure4ManageSavedSchoolsPage.jsp?Error=2&Name=" + schoolName);
                return;
            } else {
                response.sendRedirect("figure4ManageSavedSchoolsPage.jsp?Error=3&Name=" + schoolName);
            }


        %>
    </body>
</html>

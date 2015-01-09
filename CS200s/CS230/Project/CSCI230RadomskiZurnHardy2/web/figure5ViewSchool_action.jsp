<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginUser.jsp"%>
<%
    String fromwho = request.getParameter("From5");
    String username = (String) session.getAttribute("currentUser");
    int id = DatabaseController.getID(username);
    UserController.addUserSchool(id, request.getParameter("school"));


    if (fromwho != null && fromwho.equals("5")) {
        response.sendRedirect("figure4ManageSavedSchoolsPage.jsp?Error=5&Name=" + request.getParameter("school"));
    } else {
        response.sendRedirect("figure4ManageSavedSchoolsPage.jsp?Error=4&Name=" + request.getParameter("school"));

    }
%>
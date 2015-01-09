<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginAdmin.jsp"%>

<%
    try {
        String firstname = request.getParameter("Firstname");
        String lastname = request.getParameter("Lastname");
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        Character type = new Character(request.getParameter("Type").charAt(0));
        AdminController.addUser(firstname, lastname, username, password, type);
        response.sendRedirect("figure13ManageUsersOption.jsp");
    }
    catch(Exception ie){
        response.sendRedirect("figure13ManageUsersOption.jsp?Error=1");
    }
    %>

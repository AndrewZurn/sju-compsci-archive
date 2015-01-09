<%@page import="csci230radomskizurnhardy.*"%>
<%@page language="java"%>
<%@include file = "verifyLoginAdmin.jsp"%>

<%
try{
String username = request.getParameter("Username");
String firstname = request.getParameter("Firstname");
String lastname = request.getParameter("Lastname");
String password = request.getParameter("Password");
Character type = new Character(request.getParameter("Type").charAt(0));
Character status = new Character(request.getParameter("Status").charAt(0));

AdminController.editUserByAdmin(username, firstname, lastname, password, type, status);
response.sendRedirect("figure13ManageUsersOption.jsp");
}
catch(Exception ie){
    response.sendRedirect("figure13ManageUsersOption.jsp?Error=2");
}    
        %>

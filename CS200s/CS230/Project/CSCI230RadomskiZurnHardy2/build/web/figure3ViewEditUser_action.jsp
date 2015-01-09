<%@page import="csci230radomskizurnhardy.*"%>
<%@page language="java"%>
<%@include file = "verifyLoginUser.jsp"%>

<%
String username = request.getParameter("username");
String firstname = request.getParameter("firstname");
String lastname = request.getParameter("lastname");
String password = request.getParameter("password");
String password2 = request.getParameter("password2");
if(password.equals(password2)){
UserController.editUser(username, firstname, lastname, password);
response.sendRedirect("figure2UserMenuPage.jsp?Error=3");
}
else {
    response.sendRedirect("figure3ViewEditUser.jsp?Error=2");
}
%>

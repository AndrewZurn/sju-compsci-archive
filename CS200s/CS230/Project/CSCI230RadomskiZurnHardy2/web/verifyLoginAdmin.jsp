<%@page language="java" import="csci230radomskizurnhardy.*"%>
<%
    String userName44 = (String) session.getAttribute("currentUser");
    if(userName44==null ||
            new Character(AdminController.getSpecificUser(userName44).getType()).equals('u')
            || new Character(DatabaseController.getSpecificUser(userName44).getStatus()).equals('N')){
     response.sendRedirect("figure1Login.jsp?Error=-4");
     return;
    }
%>

<%@page language="java" import="csci230radomskizurnhardy.*"%>
<%
    String userName33 = (String) session.getAttribute("currentUser");
    if(userName33==null ||
            new Character(DatabaseController.getSpecificUser(userName33).getType()).equals('a')
            || new Character(DatabaseController.getSpecificUser(userName33).getStatus()).equals('N')){
     response.sendRedirect("figure1Login.jsp?Error=-4");
     return;
    }
 %>

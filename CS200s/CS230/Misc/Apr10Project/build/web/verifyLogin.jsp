<%@page language="java" import="edu.csbsju.csci230.*"%>

<% 
try{
UserController uc1 = (UserController) session.getAttribute("uc");
if(uc1.isLoggedIn() == false){
    response.sendRedirect("index.jsp?Error=-4");
       }
}
catch(Exception ie){
    response.sendRedirect("index.jsp?Error=-4");
       }
%>


<%@page language="java" import="edu.csbsju.csci230.*"%>
<%  
    UserController uc = new UserController();
    int loginStatus = uc.login(request.getParameter("Username"), request.getParameter("Password"));
    if (loginStatus!=0){
        response.sendRedirect("index.jsp?Error="+loginStatus);
    }
    else{
        session.setAttribute("uc", uc);
        response.sendRedirect("Menu.jsp");
    }
%>


<%@page language="java" import="edu.csbsju.csci230.*"%>
<%  
    UserController uc = (UserController) session.getAttribute("uc");
    String username = request.getParameter("Username");
    String[][] deletedUser = uc.getSpecificUser(username);
    User newUser = new User(deletedUser[0][0], deletedUser[0][1],deletedUser[0][2],Integer.parseInt(deletedUser[0][3]),deletedUser[0][4], deletedUser[0][5]);
    uc.deleteUser(newUser);
    response.sendRedirect("Menu.jsp");    
%>
<%@page language="java" import="edu.csbsju.csci230.*"%>
<%  
    UserController uc = (UserController) session.getAttribute("uc");
    String fullName = request.getParameter("FullName");
    String username = request.getParameter("Username");
    String password = request.getParameter("Password");
    int age = Integer.parseInt(request.getParameter("Age"));
    String city = request.getParameter("City");
    String state = request.getParameter("State");
    User newUser = new User(fullName, username,password,age,city, state);
    uc.addUser(newUser);
    response.sendRedirect("Menu.jsp");    
%>
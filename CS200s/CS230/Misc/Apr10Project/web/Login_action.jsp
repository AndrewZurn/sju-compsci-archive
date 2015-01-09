<%@page language="java" import="edu.csbsju.csci230.*"%>
    <%String username = request.getParameter("Username");
      String password = request.getParameter("Password");
      UserController uc = new UserController();
      int loginReturn = uc.login(username, password);
      if(loginReturn == 0){
          session.setAttribute("uc", uc);
          response.sendRedirect("Menu.jsp");
          }
      else {
          response.sendRedirect("index.jsp?Error=" + loginReturn );
          }
%>


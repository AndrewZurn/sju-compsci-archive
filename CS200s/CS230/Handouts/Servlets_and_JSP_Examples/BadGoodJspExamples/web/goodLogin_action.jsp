
<%@page language="java" import="java.util.*,universities.*"%>

<%  
 UserController uc = new UserController();
 if(uc.login(request.getParameter("Username"), request.getParameter("Password"))){%>
     <h1>  <%=uc.getUsername()%> and <%=uc.getPassword()%> are valid credentials for a CMC <%=uc.getType()%> </h1>
      
 <%
 }else {
     response.sendRedirect("index.jsp?Error=1");
}
%>

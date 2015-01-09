<%@page language="java" import="java.util.*"%>

<%  
 String u = request.getParameter("Username");
 String p = request.getParameter("Password");
 if(!u.equals("imad") || !p.equals("rahal"))
     response.sendRedirect("index.jsp");
 else{
     out.println("Username = " + u);
     out.println("Password = " + p);
                         }
%>

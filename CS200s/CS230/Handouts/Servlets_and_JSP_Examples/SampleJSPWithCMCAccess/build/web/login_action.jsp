<%@page language="java" import="java.util.*,universities.*"%>

<%  
 String u = request.getParameter("Username");
 String p = request.getParameter("Password");
 String[][] users = UniversityDBLibrary.getAllUsers();
 boolean match =false;
 int i=-1;
 for(i=0;i<users.length;i++){
    if(u.equals(users[i][3]) && p.equals(users[i][4])){
        match=true;
        break;
    }
 }
 if(match){
     if(users[i][5].equals("a")){
        out.println("Username = " + u + " and Password = " + p + " are valid credentials for a CMC ADMIN");
      }
     else{
        out.println("Username = " + u + " and Password = " + p + " are valid credentials for a CMC USER");
      }
 }
 else{
    response.sendRedirect("index.jsp?Error=1");
 }
%>

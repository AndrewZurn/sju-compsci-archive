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
     if(users[i][5].equals("a")){%>
        <h1>  <%=u%> and <%=p%> are valid credentials for a CMC ADMIN </h1>
      <%}
     else{%>
        <h1>  <%=u%> and <%=p%> are valid credentials for a CMC USER </h1>
      <%}
 }
 else{
    response.sendRedirect("index.jsp?Error=1");
 }
%>
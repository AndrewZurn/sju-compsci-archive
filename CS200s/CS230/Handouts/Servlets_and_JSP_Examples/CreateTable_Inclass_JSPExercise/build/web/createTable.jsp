<%@page language="java" import="java.util.*"%>

<%  
 int rows = Integer.parseInt(request.getParameter("NumRows"));
 int cols = Integer.parseInt(request.getParameter("NumCols"));
 if(rows<1){
     response.sendRedirect("index.jsp?Error=1");
 }else if(cols<1){
     response.sendRedirect("index.jsp?Error=2");
 }
 
 out.println("Hello " + request.getParameter("YourName") + ". Here is your table:");
%>
 <table border="2">
     <tbody>
         <%for(int i=1;i<=rows;i++){%>
         <tr>
             <%for(int j=1;j<=cols;j++){%>
                <td><%=i+" , " +j%></td>
             <%}%>
         </tr>
         <%}%>
         
     </tbody>
 </table>

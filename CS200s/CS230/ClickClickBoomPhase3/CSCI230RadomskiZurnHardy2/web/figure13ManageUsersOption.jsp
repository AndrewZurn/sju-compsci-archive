<%-- 
    Document   : index
    Created on : Apr 7, 2012, 12:45:25 PM
    Author     : pghardy
--%>



<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>figure13ManageUsersOption</title>
</head>
<body>
<a href="figure9AdminMenuPage.jsp">Back to Menu</a><br>
<table style="text-align: left; width: 100%;" border="4" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<td colspan="9" rowspan="1"
style="vertical-align: top; text-align: center; width: 97px;"><a
href="figure14AddNewUser.jsp">Add a new User</a><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; width: 166px;"><br>
</td>
<td style="vertical-align: top; width: 233px;">ID<br>
</td>
<td style="vertical-align: top;">First<br>
</td>
<td style="vertical-align: top;">Last<br>
</td>
<td style="vertical-align: top;">Username<br>
</td>
<td style="vertical-align: top;">Password<br>
</td>
<td style="vertical-align: top;">Type<br>
</td>
<td style="vertical-align: top; width: 132px;">Status<br>
</td>
<td style="vertical-align: top; width: 97px;"><br>
</td>
</tr>

<%
ArrayList<User> allUsers = null;
User temp;
try{
    allUsers = DatabaseController.getAllUsers();
}
catch(Exception e){
    out.println("Exception: " + e);
}
for(int i = 0; i < allUsers.size(); i++){
    temp= allUsers.get(i);
    
    out.println("<tr>");
    out.println("<td style=\"vertical-align: top; width: 166px;\">DEACTIVATE BUTTON<br>");
    out.println("</td>");
    out.println("<td style=\"vertical-align: top; width: 233px;\">"+DatabaseController.getID(temp.getUserName())+"<br>");
    out.println("</td>");
    out.println("<td style=\"vertical-align: top;\">"+temp.getFirstName()+"<br>");
    out.println("</td>");
    out.println("<td style=\"vertical-align: top;\">"+temp.getLastName()+"<br>");
    out.println("</td>");
    out.println("<td style=\"vertical-align: top;\">"+temp.getUserName()+"<br>");
    out.println("</td>");
    out.println("<td style=\"vertical-align: top;\">"+temp.getPassword()+"<br>");
    out.println("</td>");
    out.println("<td style=\"vertical-align: top;\">"+temp.getType()+"<br>");
    out.println("</td>");
    out.println("<td style=\"vertical-align: top; width: 132px;\">"+temp.getStatus()+"<br>");
    out.println("</td>");
    out.println("<td style=\"vertical-align: top; width: 97px;\">EDIT BUTTON<br>");
    out.println("</td>");
    out.println("</tr>");
}
%>



</tbody>
</table>
&nbsp;<br>
</body>
</html>
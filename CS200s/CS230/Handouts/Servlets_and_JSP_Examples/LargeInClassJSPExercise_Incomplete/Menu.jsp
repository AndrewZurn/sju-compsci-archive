
<%@page language="java" import="edu.csbsju.csci230.*"%>

<html>
<head>
<title></title>
</head>
<body>
<br>
<br>
<%
    UserController uc = (UserController) session.getAttribute("uc");
%>
Hello User <%=uc.getCurrentUser().getUsername()%>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">

<td colspan="8" rowspan="1" style="vertical-align: top;"><a
href="Add.jsp">ADD A USER</a><br>
</td>

</tr>
<tr>
<td style="vertical-align: top;"><br>
</td>
<td style="vertical-align: top; text-align: center;">Full name<br>
</td>
<td style="vertical-align: top; text-align: center;">Username<br>
</td>
<td style="vertical-align: top; text-align: center;">Password<br>
</td>
<td style="vertical-align: top; text-align: center;">Age<br>
</td>
<td style="vertical-align: top; text-align: center;">City<br>
</td>
<td style="vertical-align: top; text-align: center;">State<br>
</td>
<td style="vertical-align: top;"><br>
</td>
</tr>
<% 
    String[][] allUsers = uc.getAllUsers();
    for (int r=0;r<allUsers.length;r++){        
%>
<tr>
<td style="vertical-align: top;">
<form method="post" action="Edit.jsp" name="Edit">
    <input name="Edit" value="Edit" type="submit"><br>
    <input name="Username" value="<%=allUsers[r][1]%>" type="hidden"><br>
</form>
<br>
</td>
<td style="vertical-align: top;"><br><%=allUsers[r][0]%>
</td>
<td style="vertical-align: top;"><br><%=allUsers[r][1]%>
</td>
<td style="vertical-align: top;"><br><%=allUsers[r][2]%>
</td>
<td style="vertical-align: top;"><br><%=allUsers[r][3]%>
</td>
<td style="vertical-align: top;"><br><%=allUsers[r][4]%>
</td>
<td style="vertical-align: top;"><br><%=allUsers[r][5]%>
</td>
<td style="vertical-align: top;">
<form method="post" action="Delete.jsp" name="Delete">
    <input name="Delete" value="Delete" type="submit"><br>
    <input name="Username" value="<%=allUsers[r][1]%>" type="hidden">
</form>
<br>
</td>
</tr>
<%}%>
</tbody>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</body>
</html>


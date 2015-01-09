<%@include file="verifyLogin.jsp"%>
<html>
<head>

<title>Add User Form</title>
</head>
<body>
<br>

<%
    out.println("Edit user : " + request.getParameter("Username"));
    UserController uc = (UserController) session.getAttribute("uc");
%>
<br>
<form method="post" action="Edit_action.jsp" name="editUser"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;">Full Name<br>
</td>
<td style="vertical-align: top;"><input name="FullName" value=" <% uc.getCurrentUser().getFullName(); %> "><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Username<br>
</td>
<td style="vertical-align: top;"><input name="Username" readonly value=" <% uc.getCurrentUser().getUsername(); %> "> </td>
</tr>
<tr>
<td style="vertical-align: top;">Password<br>
</td>
<td style="vertical-align: top;"><input name="Password" value=" <% uc.getCurrentUser().getPassword(); %> "> </td>
</tr>
<tr>
<td style="vertical-align: top;">Age<br>
</td>
<td style="vertical-align: top;"><input name="Age" value=" <% uc.getCurrentUser().getAge(); %> "> </td>
</tr>
<tr>
<td style="vertical-align: top;">City<br>
</td>
<td style="vertical-align: top;"><input name="City" value=" <% uc.getCurrentUser().getCity(); %> "> </td>
</tr>
<tr>
<td style="vertical-align: top;">State<br>
</td>
<td style="vertical-align: top;"><input name="State" value=" <% uc.getCurrentUser().getState(); %> "></td>
</tr>
<tr>
<td style="vertical-align: top;"><input value="Edit"
name="Edit" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset"></td>

</tr>
</tbody>
</table>
<br>
</form>
<br>
</body>
</html>


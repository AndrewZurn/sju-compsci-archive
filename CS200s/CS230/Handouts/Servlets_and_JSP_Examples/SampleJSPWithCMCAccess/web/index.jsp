<%@page language="java"%>
<html>
<head>
<title>Sample Login Page</title>
</head>
<body>
<br>
<br>
<%
        String anyErrors = request.getParameter("Error");
        if(anyErrors!=null && anyErrors.equals("1")){
            out.println("PLEASE PROVIDE A VALID USERNAME AND PASSWORD");
        }
%>

<form method="post" action="login_action.jsp">
    Username <input name="Username"><br>
    Password<input name="Password" type="password"><br>
    <input value="Login" type="submit"> 
    <input value="Reset" type="reset"><br>
</form>
</body>
</html>


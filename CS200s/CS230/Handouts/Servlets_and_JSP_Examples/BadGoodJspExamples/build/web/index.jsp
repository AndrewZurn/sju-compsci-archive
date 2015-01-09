
<html>
<head>
<title>Sample Login Page</title>
</head>
<body>
    <%
        String anyErrors = request.getParameter("Error");
        if(anyErrors!=null && anyErrors.equals("1")){
            out.println("PLEASE PROVIDE A VALID USERNAME AND PASSWORD");
        }
%>
    <br><br><a href="badLogin.jsp"> The bad one </a>
    <br><br><a href="goodLogin.jsp"> The good one </a>
    
</body>
</html>


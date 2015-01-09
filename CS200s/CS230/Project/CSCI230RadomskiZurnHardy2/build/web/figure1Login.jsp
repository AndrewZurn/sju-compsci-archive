<%@page language="java"%>
<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<html>
    <head>
        <title>CMC Login</title>
    </head>
    <body background="Images/cmc3.jpg">
        <%
        String anyErrors = request.getParameter("Error");
        if(anyErrors!=null){
            if (anyErrors.equals("-1")){
                out.println("<center><h3>INVALID USERNAME/PASSWORD COMBINATION</h3></center>");
            }
        }
        %>
        <br><br><br><br><br><br><br><br><br><br>
    <center>
        <img style="border: 0px solid ; width: 400px; height: 200px;" alt="CMC"
                src="Images/cmc2.jpg">
    </center>
        <div style="text-align: center;">
        <form method="post" action="figure1Login_action.jsp" name="l">
        Username: <input name="Username" type="text"><br>
        Password: <input name="Password" type="password"><br>
        <input name="Submit" value="Login" type="submit"><br>
        </form>
        </div>
    </body>
</html>

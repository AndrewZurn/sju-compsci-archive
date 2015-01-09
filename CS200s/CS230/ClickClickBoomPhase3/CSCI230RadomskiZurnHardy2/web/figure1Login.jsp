<%-- 
    Document   : figure1Login
    Created on : Apr 9, 2012, 5:01:31 PM
    Author     : wjradomski
--%>

<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
    <form method="post" action="figure2UserMenu.jsp">
    Username <input type=text username=username%><br>
    Password <input type=password password=password %><br>
 
    </form>
    <p>
        <a href="figure2UserMenuPage.jsp"><input type=submit> 
         <a href="figure9AdminMenuPage.jsp"><input type=submit>   
    </p>
    </body>
</html>

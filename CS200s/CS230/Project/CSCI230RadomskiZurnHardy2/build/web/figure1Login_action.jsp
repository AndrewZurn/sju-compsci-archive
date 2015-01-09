<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<html>
    <head>
        <title>Login Action Page</title>
    </head>
    <body>
        <%
        
        
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        
        if(AdminController.login(username,password) 
                && new Character(AdminController.getSpecificUser(username).getType()).equals('a')){
            session.setAttribute("currentUser", username);
            response.sendRedirect("figure9AdminMenuPage.jsp");
        }
        else if(UserController.login(username,password) 
                && new Character(DatabaseController.getSpecificUser(username).getType()).equals('u')){
            session.setAttribute("currentUser", username);
            response.sendRedirect("figure2UserMenuPage.jsp");
        }
        else{
            response.sendRedirect("figure1Login.jsp?Error=-1");
        }
        %>
    </body>
</html>

<%@page import="csci230radomskizurnhardy.*"%>
<%@page language="java"%>
<%@include file = "verifyLoginUser.jsp"%>
<html>
    <head>
        <title>View/Edit Personal Information</title>
    </head>
    <body background="Images/cmc3.jpg">

        <a href="figure2UserMenuPage.jsp"><img
                style="border: 0px solid ; width: 30px; height: 20px;" alt="Back"
                src="Images/back.jpg"></a> Back to User Menu

        <br>
        <%
            String un = (String) session.getAttribute("currentUser");
            User currentUser = AdminController.getSpecificUser(un);
        %>
        <form method="post" action="figure3ViewEditUser_action.jsp">
            <table style="text-align: left; width: 500px;" border="2" cellpadding="2"
                   cellspacing="2">
                <tbody>
                    <tr>
                        <td style="vertical-align: top;">User ID Number<br>
                        </td>
                        <td style="vertical-align: top;"><input name="ID" value ="<%=DatabaseController.getID(currentUser.getUserName())%>" readonly="readonly"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Username<br>
                        </td>
                        <td style="vertical-align: top;"><input name="username" value ="<%=currentUser.getUserName()%>" readonly="readonly"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">First Name<br>
                        </td>
                        <td style="vertical-align: top;"><input name="firstname" value ="<%=currentUser.getFirstName()%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Last Name<br>
                        </td>
                        <td style="vertical-align: top;"><input name="lastname" value ="<%=currentUser.getLastName()%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Password<br>
                        </td>
                        <td style="vertical-align: top;" ><input name="password" value ="<%=currentUser.getPassword()%>" type="password"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Re-Enter Password        <%
                            String anyErrors = request.getParameter("Error");
                            if (anyErrors != null) {
                                if (anyErrors.equals("2")) {
                                    out.println("<h3><i>Please Re-Enter Password</i></h3>");
                                }
                            }
                            %><br>
                        </td>
                        <td style="vertical-align: top;" ><input name="password2" value ="" type="password"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Type<br>
                        </td>
                        <td style="vertical-align: top;"><input name="type" value ="<%=currentUser.getType()%>" readonly="readonly"><br>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p><input name="Submit" value="Apply Changes" type="submit"><br>
            </p>
        </form>
        <br>
        <br>
    </body>
</html>
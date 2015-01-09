<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginAdmin.jsp"%>
<html>
    <head>
        <title>Manage Users Option</title>
    </head>
    <body background="Images/cmc3.jpg">

        <a href="figure9AdminMenuPage.jsp"><img
                style="border: 0px solid ; width: 30px; height: 20px;" alt="Back"
                src="Images/back.jpg"></a> Back to Menu

        <%
            String errors = request.getParameter("Error");
            if (errors != null) {
                if (errors.equals("1")) {
                    out.println("<h4>There was an error in adding the user to the database.");
                }
                if (errors.equals("2")) {
                    out.println("<h4>There was an error in editing the user in the database.");
                }
            }
        %>
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
                    try {
                        allUsers = DatabaseController.getAllUsers();
                    } catch (Exception e) {
                        out.println("Exception: " + e);
                    }
                    for (int i = 0; i < allUsers.size(); i++) {
                        temp = allUsers.get(i);%>

                        <tr>
                        <td style="vertical-align: top; width: 166px;">
                        <form method="post" action="figure13ManageUsersOption_deacAction.jsp" name="Deactivate">
                        <input name="A" value="Deactivate" type="submit"><br>
                        <input name="User" value="" <%=temp.getUserName()%> type="hidden"><br>
                        </form><br>
                        </td>
                        <td style="vertical-align: top; width: 233px;"> <%=DatabaseController.getID(temp.getUserName())%><br>
                        </td>
                        <td style="vertical-align: top;"><%=temp.getFirstName()%><br>
                        </td>
                        <td style="vertical-align: top;"><%=temp.getLastName()%><br>
                        </td>
                        <td style="vertical-align: top;"><%=temp.getUserName()%><br>
                        </td>
                        <td style="vertical-align: top;"><%=temp.getPassword()%><br>
                        </td>
                        <td style="vertical-align: top;"><%=temp.getType()%><br>
                        </td>
                        <td style="vertical-align: top; width: 132px;"><%=temp.getStatus()%><br>
                        </td>

                        <td style="vertical-align: top;">
                        <form method="post" action="figure15ViewEditUser.jsp" name="Edit">
                        <input name="B" value="Edit" type="submit"><br>
                        <input name="EditThisUser" value="<%=temp.getUserName()%>" type="hidden"><br>
                        </form><br>


                        </td>
                        </tr>
                    <%}%>



            </tbody>
        </table>
        &nbsp;
        <br>
    </body>
</html>
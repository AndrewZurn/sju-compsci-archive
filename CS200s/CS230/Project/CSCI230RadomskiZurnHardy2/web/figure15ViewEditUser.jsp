<%@page import="csci230radomskizurnhardy.*"%>
<%@page language="java"%>
<%@include file = "verifyLoginAdmin.jsp"%>
<html>
    <head>
        <title>Administrator: View Edit User</title>
    </head>
    <%
        String userName = request.getParameter("EditThisUser");
        User user = AdminController.getSpecificUser(userName);
        int ID = DatabaseController.getID(userName);
        String firstname = user.getFirstName();
        String lastname = user.getLastName();
        String password = user.getPassword();
        Character type = user.getType();
        Character status = user.getStatus();
    %>
    <body background="Images/cmc3.jpg">
        <form method="post" action="figure15ViewEditUser_action.jsp">
            <table style="text-align: left; width: 739px; height: 228px;" border="1" cellpadding="2" cellspacing="2">
                <tbody>
                    <tr>
                        <td style="vertical-align: top; width: 518px;">ID<br>
                        </td>
                        <td style="vertical-align: top; width: 201px;">
                            <input name="ID" value ="<%=ID%>" readonly="readonly"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 518px;">First Name<br>
                        </td>
                        <td style="vertical-align: top; width: 201px;"><input name="Firstname" value ="<%=firstname%>"></td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 518px;">Last Name<br>
                        </td>
                        <td style="vertical-align: top; width: 201px;"><input name="Lastname" value ="<%=lastname%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 518px;">Username<br>
                        </td>
                        <td style="vertical-align: top; width: 201px;"><input name="Username" value ="<%=userName%>" readonly="readonly"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 518px;">Password<br>
                        </td>
                        <td style="vertical-align: top; width: 201px;"><input name="Password" value ="<%=password%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 518px;">Type<br>
                        </td>
                        <td style="vertical-align: top; width: 201px;"><input name="Type" value ="<%=type%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 518px;">Status<br>
                        </td>
                        <td style="vertical-align: top; width: 201px;"><input name="Status" value ="<%=status%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 518px;"><input name="Submit" value="Submit" type="submit">
                            &nbsp; <input name="Reset" value="Reset" type="reset"><br>

                        </td>
                        <td style="vertical-align: top; width: 201px;"><br>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>

        <a href="figure13ManageUsersOption.jsp"><img
                style="border: 0px solid ; width: 30px; height: 20px;" alt="Back"
                src="Images/back.jpg"></a> Back to Menu            
    </body>
</html>

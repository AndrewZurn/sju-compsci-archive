<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "verifyLoginAdmin.jsp"%>
<html><head>
        <title>Admin: New User</title>
    </head>
    <body background="Images/cmc3.jpg">
        <form method="post" action="figure14AddNewUser_action.jsp">
            <table style="text-align: left; width: 737px; height: 144px;" border="1" cellpadding="2" cellspacing="2">
                <tbody>
                    <tr>
                        <td style="vertical-align: top; width: 533px;">First Name<br>
                        </td>
                        <td style="vertical-align: top; width: 184px;"><input name="Firstname"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 533px;">Last Name<br>
                        </td>
                        <td style="vertical-align: top; width: 184px;"><input name="Lastname"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 533px;">Username<br>
                        </td>
                        <td style="vertical-align: top; width: 184px;"><input name="Username"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 533px;">Password<br>
                        </td>
                        <td style="vertical-align: top; width: 184px;"><input name="Password"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 533px;">Type<br>
                        </td>
                        <td style="vertical-align: top; width: 184px;"><input name="Type"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;"><input name="Submit" value="Submit" type="submit">
                            &nbsp;
                            <input name="Reset" value="Reset" type="reset"><br>
                        </td>
                        <td style="vertical-align: top;"><br>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br>
        </form>

        <a href="figure9AdminMenuPage.jsp"><img
                style="border: 0px solid ; width: 30px; height: 20px;" alt="Back"
                src="Images/back.jpg"></a> Back to Menu
    </body>
</html>

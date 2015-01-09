<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginUser.jsp"%>
<html>
    <head>
        <title>Manage Saved Schools</title>
    </head>
    <body background="Images/cmc3.jpg">
        <%
            String un = (String) session.getAttribute("currentUser");
            ArrayList<String> list = UserController.getAllSavedSchools(DatabaseController.getID(un));
            if (list == null || list.size()==0) {
                response.sendRedirect("figure2UserMenuPage.jsp?Error=-2");
                return;
            }
            String temp = "";
        %>

        <a href="figure2UserMenuPage.jsp"><img
                style="border: 0px solid ; width: 30px; height: 20px;" alt="Back"
                src="Images/back.jpg"></a> Back To Menu

        <table style="width: 750px;" border="2"
               cellpadding="2" cellspacing="2">
            <tbody>
                <tr align="center">
                    <td colspan="3" rowspan="1"
                        style="vertical-align: middle;">School<br>
                    </td>
                </tr>

                <%
                for (int i = 0; i < list.size(); i++) {
                    temp = list.get(i);
                %>
                <tr>
                    <td style="vertical-align: middle; width: 125px; text-align: center;">

                        <form method="post" action="figure4ManageSavedSchoolPage_removeAction.jsp?From2=2" name="Edit">
                            <input name="Remove" value="Remove" type="submit">
                            <input name="School" value="<%=temp%>" type="hidden">
                        </form>
                        <img style="width: 30px; height: 35px;" alt="Remove"
                        src="Images/down.jpg">

                    </td>
                    <td style="vertical-align: middle; width: 500px; text-align: center;"><%=temp%><br>
                    </td>
                    <td style="vertical-align: middle; width: 125px; text-align: center;">

                        <form method="post" action="figure5ViewSchool.jsp" name="ViewButton">
                            <input name="View" value="View" type="submit">
                            <input name="School" value="<%=temp%>" type="hidden">
                        </form>
                        <img style="width: 52px; height: 32px;" alt="View"
                        src="Images/bino.jpg"><br>    

                    </td>
                </tr>
                <%}%>

            </tbody>
        </table>
        <%
            String anyErrors = request.getParameter("Error");
            if (anyErrors != null) {
                if (anyErrors.equals("1")) {
                    out.println("<h3>There was an error in processing your saved school!</h3>");
                } else if (anyErrors.equals("2")) {
                    out.println("<h3>" + request.getParameter("Name") + " Removed from Saved Schools</h3>");
                } else if (anyErrors.equals("3")) {
                    out.println("<h3>" + request.getParameter("Name") + " Removed from Saved Schools</h3>");
                    out.println("<a href=\"figure7SearchResults.jsp\">Back to Matched Schools</a>");
                } else if (anyErrors.equals("4")) {
                    out.println("<h3>" + request.getParameter("Name") + " Added to Saved Schools</h3>");
                    out.println("<a href=\"figure7SearchResults.jsp\">Back to Matched Schools</a>");
                } else if (anyErrors.equals("5")) {
                    out.println("<h3>" + request.getParameter("Name") + " Added to Saved Schools</h3>");
                } 
            }
        %>
        <br>
        <br>
    </body>
</html>


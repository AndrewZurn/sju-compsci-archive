<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginAdmin.jsp"%>
<html>
    <head>
        <title>Manage Universities Option</title>
    </head>
    <body background="Images/cmc3.jpg">

        <a href="figure9AdminMenuPage.jsp"><img
                style="border: 0px solid ; width: 30px; height: 20px;" alt="Back"
                src="Images/back.jpg"></a> Back to Menu

        <%
            String errors = request.getParameter("Error");
            if (errors != null) {
                if (errors.equals("1")) {
                    out.println("<h4>There was an error in adding the university to the database.</h4>");
                }
                if (errors.equals("2")) {
                    out.println("<h4>There was an error in editing the university within the datebase.</h4>");
                }
            }
        %>
        <table style="text-align: left; width: 100%;" border="1" cellpadding="2"
               cellspacing="2">
            <tbody>
                <tr>
                    <td colspan="18" rowspan="1"
                        style="vertical-align: top; text-align: center;"><a
                            href="figure11AddUniversity.jsp">Add a new University</a><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top; text-align: center;">School<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">State<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">Location<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">Control<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;"># of Students<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">% Females<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">SAT Verbal<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">SAT Math<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">Expenses<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">% Financial Aid<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;"># of Applicants<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">% Admitted<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">% Enrolled<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">Academic
                        Scale(1-5)<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">Social Life
                        Scale(1-5)<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">Quality of
                        Life Scale(1-5)<br>
                    </td>
                    <td style="vertical-align: top; text-align: center;">Emphases<br>
                    </td>
                    <td></td>
                </tr>


                <%
                    ArrayList<University> allSchools = null;
                    University temp;
                    try {
                        allSchools = DatabaseController.getAllUniversities();
                    } catch (Exception e) {
                        out.println("Exception: " + e);
                    }
                    for (int i = 0; i < allSchools.size(); i++) {
                        temp = allSchools.get(i);%>
                <tr>
                    <td style="vertical-align: top;"> <%=temp.getSchool()%> <br></td>
                    <td style="vertical-align: top;">
                        <%
                        if (temp.getState().equals("MN") || temp.getState().equals("Minnesota")) {%>
                        <img style="border: 0px solid ; width: 30px; height: 30px;" alt="MN"
                             src="Images/mn.jpg"><%}%>

                        <%=temp.getState()%> <br></td>
                    <td style="vertical-align: top;"> <%=temp.getLocation()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getControl()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getNumberOfStudents()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getPercentFemales()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getSATVerbal()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getSATMath()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getExpenses()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getPercentFinancialAid()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getNumberOfApplicants()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getPercentAdmitted()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getPercentEnrolled()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getAcademicsScale()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getSocialScale()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getQualityOfLifeScale()%><br></td>
                    <td style="vertical-align: top;"> <%=temp.getEmphases()%><br></td>

                    <td style="vertical-align: top;">
                        <form method="post" action="figure12ViewEditUniversity.jsp" name="Edit">
                            <input name="Edit" value="Edit" type="submit"><br>
                            <input name="School" value="<%=temp.getSchool()%>" type="hidden"><br>
                        </form><br></td></tr>
                        <%}%>



            </tbody>
        </table>
        <br>
        <br>
    </body>
</html>

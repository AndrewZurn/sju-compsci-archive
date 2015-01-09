<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginUser.jsp"%>
<% try{ %>
<html>
    <head>
        <title><%=request.getParameter("School")%></title>
    </head>
    <body background="Images/cmc3.jpg">
        <%

            String chosenSchoolName = request.getParameter("School");
            University chosenSchool = DatabaseController.getSpecificUniversity(chosenSchoolName);
            //FiveRecSchoolsController frsc = new FiveRecSchoolsController(chosenSchool);
            //ArrayList<University> rec = frsc.getFiveMatches();
        %>

        <a href="figure4ManageSavedSchoolsPage.jsp"><img
        style="border: 0px solid ; width: 30px; height: 20px;" alt="Back"
        src="Images/back.jpg"></a> Back To Saved Schools
        
        <table style="text-align: left; width: 800px;" border="2"
               cellpadding="2" cellspacing="2">
            <tbody>
                <tr>
                    <td style="vertical-align: top;">School<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getSchool()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">State<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getState()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Location<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getLocation()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Control<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getControl()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Number Of Students<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getNumberOfStudents()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Percent Female<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getPercentFemales()%>%<br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">SAT Verbal<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getSATVerbal()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">SAT Math<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getSATMath()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Expenses<br>
                    </td>
                    <td style="vertical-align: top;">$<%=chosenSchool.getExpenses()%>0<br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Percent Receiving Financial Aid<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getPercentFinancialAid()%>%<br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Number of Applicants<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getNumberOfApplicants()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Percent Admitted<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getPercentAdmitted()%>%<br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Percent Enrolled<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getPercentEnrolled()%>%<br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Academic Scale (1-5)<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getAcademicsScale()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Social Scale (1-5)<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getSocialScale()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Quality of Life Scale (1-5)<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getQualityOfLifeScale()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">Emphases<br>
                    </td>
                    <td style="vertical-align: top;"><%=chosenSchool.getEmphases()%><br>
                    </td>
                </tr>
            </tbody>
        </table>
        <br>
        <%--
            String temp = chosenSchool.getSchool();
        %>
        
        <form method="post" action="figure5ViewSchool_action.jsp?From5=5" name="AddSavedSchool">
            <img style="width: 20px; height: 24px;" alt="Add"  src="Images/up.jpg">
            <input name="AddSchool" value="Add To Saved Schools" type="submit">
            <input name="school" value="<%=temp%>" type="hidden">
        </form>
        <br>
        <br>
        
        Based on your interest in the <%=temp%>, we recommend these other Schools.
        <br>
        <table style="text-align: left; width: 500px;" border="2"
               cellpadding="2" cellspacing="2">
            <% for (int i = 0; i < 5; i++) {%>
            <tr>
                <td>
                    <%String reco = rec.get(i).getSchool();%>
            <center>
                    <%=reco%>
            </center>
                </td>

                <td style="vertical-align: middle; width: 125px; text-align: center;">
                    <form method="post" action="figure5ViewSchool.jsp" name="ViewButton">
                        <input name="View" value="View" type="submit">
                        <input name="School" value="<%=reco%>" type="hidden">
                    </form>  
                </td>

            </tr>
            <% }%>
        </table>
        <br>--%>
    </body>
</html>
<% }
 catch(Exception ie){
     response.sendRedirect("figure4ManageSavedSchoolsPage.jsp?Error=1");
 }
%>

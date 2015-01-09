<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@include file = "verifyLoginAdmin.jsp"%>
<html>
    
    <head>
        
        <title>Admin: View Edit University</title>
        
    </head>
    <body background="Images/cmc3.jpg">

    <%
        String schoolName = request.getParameter("School");
        University uni = DatabaseController.getSpecificUniversity(schoolName);
        String state = uni.getState();
        String location = uni.getLocation();
        String control = uni.getControl();
        Integer numberOfStudents = uni.getNumberOfStudents();
        Double percentageFemales = uni.getPercentFemales();
        Double SATVerbal = uni.getSATVerbal();
        Double SATMath = uni.getSATMath();
        Double expenses = uni.getExpenses();
        Double percentageFinAid = uni.getPercentFinancialAid();
        Integer numberOfApplicants = uni.getNumberOfApplicants();
        Double percentageAdmitted = uni.getPercentAdmitted();
        Double percentageEnrolled = uni.getPercentEnrolled();
        Integer academics = uni.getAcademicsScale();
        Integer social = uni.getSocialScale();
        Integer quality = uni.getQualityOfLifeScale();
        ArrayList<String> empList = uni.getEmphases();
    %>
    <form method="post" action="figure12ViewEditUniversity_action.jsp">
    <table style="text-align: left; width: 735px; height: 172px;" border="2" cellpadding="2" cellspacing="2">
        <tbody>
        

            <tr>
                <td style="vertical-align: top; width: 512px;">SCHOOL<br>
                </td>
                <td style="vertical-align: top; width: 203px;"><input name="School" value="<%=schoolName%>" readonly="readonly"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top; width: 512px;">STATE<br>
                </td>
                <td style="vertical-align: top; width: 203px;"><input name="State" value="<%=state%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top; width: 512px;">LOCATION<br>
                </td>
                <td style="vertical-align: top; width: 203px;"><input name="Location" value="<%=location%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top; width: 512px;">CONTROL<br>
                </td>
                <td style="vertical-align: top; width: 203px;"><input name="Control" value="<%=control%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top; width: 512px;">NUMBER OF STUDENTS<br>
                </td>
                <td style="vertical-align: top; width: 203px;"><input name="NumberOfStudents" value="<%=numberOfStudents%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top; width: 512px;">% FEMALES<br>
                </td>
                <td style="vertical-align: top; width: 203px;"><input name="PercentageFemales" value="<%=percentageFemales%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top;">SAT VERBAL<br>
                </td>
                <td style="vertical-align: top;"><input name="SATVerbal" value="<%=SATVerbal%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top;">SAT MATH<br>
                </td>
                <td style="vertical-align: top;"><input name="SATMath" value="<%=SATMath%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top;">EXPENSES<br>
                </td>
                <td style="vertical-align: top;"><input name="Expenses" value="<%=expenses%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top;">% FINANCIAL AID<br>
                </td>
                <td style="vertical-align: top;"><input name="PercentageFinAid" value="<%=percentageFinAid%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top;">NUMBER OF APPLICANTS<br>
                </td>
                <td style="vertical-align: top;"><input name="NumberOfApplicants" value="<%=numberOfApplicants%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top;">% ADMITTED<br>
                </td>
                <td style="vertical-align: top;"><input name="PercentageAdmitted" value="<%=percentageAdmitted%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top;">% ENROLLED<br>
                </td>
                <td style="vertical-align: top;"><input name="PercentageEnrolled" value="<%=percentageEnrolled%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top;">ACADEMICS SCALE (1-5)<br>
                </td>
                <td style="vertical-align: top;"><input name="AcademicsScale" value="<%=academics%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top;">SOCIAL SCALE (1-5)<br>
                </td>
                <td style="vertical-align: top;"><input name="SocialScale" value="<%=social%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top;">QUALITY OF LIFE SCALE(1-5)<br>
                </td>
                <td style="vertical-align: top;"><input name="QualityScale" value="<%=quality%>"><br>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top;">EMPHASIS<br>
                    <br>
                    <br>
                    <br>
                    <br>
                </td>
                <td style="vertical-align: top;">
                    <%
                        try {
                            int count = 0;
                            for (int i = 0; i < empList.size(); i++) {
                                count++;
                                out.println("<input name=\"Emphasis" + i + "\" value=\"" + empList.get(i) + "\"><br>");
                            }
                            for(int j = 4; j >= count; j--){
                                out.println("<input name=\"Emphasis" + j + "\" value=\"" + "" + "\"><br>"); 
                                
                            }

                        } catch (Exception ie) {
                            response.sendRedirect("figure12ViewEditUniversity.jsp");
                            return;
                        }
                    %>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top;"><input name="APPLY CHANGES" value="APPLY CHANGES" type="submit">&nbsp;
                    <input name="CANCEL CHANGES" value="CANCEL CHANGES" type="reset"><br>
                </td>
                <td style="vertical-align: top;"><br>
                </td>
            </tr>
            </tbody>
    </table>
</form>
<br>

<a href="figure10ManageUniversitiesOption.jsp"><img
                style="border: 0px solid ; width: 30px; height: 20px;" alt="Back"
                src="Images/back.jpg"></a> Back to Menu
</body></html>

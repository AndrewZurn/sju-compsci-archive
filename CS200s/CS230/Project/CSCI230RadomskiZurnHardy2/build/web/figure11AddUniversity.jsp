<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginAdmin.jsp"%>
<html>
    <head>

        <title>Admin Add University</title>


        <%
            String school = "";
            String state = "";
            String location = "";
            String control = "";
            Integer numberOfStudents = 0;
            Double percentageFemales = 0.0;
            Double SATVerbal = 0.0;
            Double SATMath = 0.0;
            Double expenses = 0.0;
            Double percentageFinAid = 0.0;
            Integer numberApplicants = 0;
            Double percentageAdmitted = 0.0;
            Double percentageEnrolled = 0.0;
            Integer academicScale = 0;
            Integer socialScale = 0;
            Integer qualityScale = 0;
            ArrayList<String> emphasesList = new ArrayList<String>();
            emphasesList.add("");
            emphasesList.add("");
            emphasesList.add("");
            emphasesList.add("");
            emphasesList.add("");
            String anyErrors = request.getParameter("Error");
            if (anyErrors != null) {
                if (anyErrors.equals("1")) {
                    University u = (University) session.getAttribute("u");
                    ArrayList<String> l = (ArrayList<String>) session.getAttribute("l");
                    school = u.getSchool();
                    state = u.getState();
                    location = u.getLocation();
                    control = u.getControl();
                    numberOfStudents = u.getNumberOfStudents();
                    percentageFemales = u.getPercentFemales();
                    SATVerbal = u.getSATVerbal();
                    SATMath = u.getSATMath();
                    expenses = u.getExpenses();
                    percentageFinAid = u.getPercentFinancialAid();
                    numberApplicants = u.getNumberOfApplicants();
                    percentageAdmitted = u.getPercentAdmitted();
                    percentageEnrolled = u.getPercentEnrolled();
                    academicScale = u.getAcademicsScale();
                    socialScale = u.getSocialScale();
                    qualityScale = u.getQualityOfLifeScale();
                    emphasesList.clear();
                    emphasesList.add(l.get(0));
                    emphasesList.add(l.get(1));
                    emphasesList.add(l.get(2));
                    emphasesList.add(l.get(3));
                    emphasesList.add(l.get(4));
                }
            }


        %>

    </head>
    <body background="Images/cmc3.jpg">
        Welcome Admin ID: <%String un = (String) session.getAttribute("currentUser");
            out.println(DatabaseController.getID(un));%> <br>
        <form method="post" action="figure11AddUniversity_action.jsp">
            <table style="text-align: left; width: 100%;" border="1" cellpadding="2" cellspacing="2">

                <tbody>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">SCHOOL<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="School" value="<% out.println(school);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">STATE<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="State" value="<% out.println(state);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">LOCATION<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="Location" value="<% out.println(location);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">CONTROL<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="Control" value="<% out.println(control);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">NUMBER OF STUDENTS<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="NumberOfStudents" value="<% out.println(numberOfStudents);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">% FEMALE<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="PercentageFemales" value="<% out.println(percentageFemales);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">SAT VERBAL<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="SATVerbal" value="<% out.println(SATVerbal);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">SAT MATH<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="SATMath" value="<% out.println(SATMath);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">EXPENSES<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="Expenses" value="<% out.println(expenses);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">% FINANCIAL AID<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="PercentageFinAid" value="<% out.println(percentageFinAid);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">NUMBER OF
                            APPLICANTS<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="NumberOfApplicants" value="<% out.println(numberApplicants);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">% ADMITTED<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="PercentageAdmitted" value="<% out.println(percentageAdmitted);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">% ENROLLED<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="PercentageEnrolled" value="<% out.println(percentageEnrolled);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">ACADEMIC SCALE
                            (1-5)<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="AcademicScale" value="<% out.println(academicScale);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">SOCIAL SCALE (1-5)<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="SocialScale" value="<% out.println(socialScale);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">QUALITY OF LIFE
                            SCALE (1-5)<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;"><input name="QualityScale" value="<% out.println(qualityScale);%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top; width: 633px;">EMPHASES<br>
                        </td>
                        <td style="vertical-align: top; width: 259px;">
                            <input name="Emphasis1" value="<% out.println(emphasesList.get(0));%>"><br>
                            <input name="Emphasis2" value="<% out.println(emphasesList.get(1));%>"><br>
                            <input name="Emphasis3" value="<% out.println(emphasesList.get(2));%>"><br>
                            <input name="Emphasis4" value="<% out.println(emphasesList.get(3));%>"><br>
                            <input name="Emphasis5" value="<% out.println(emphasesList.get(4));%>"><br>
                        </td>
                    </tr>
                </tbody>
            </table>

            <br>
            <%
                session.removeAttribute("u");
                session.removeAttribute("l");
            %>
            <input name="Submit" value="Add School" type="submit">&nbsp;
            <input name="Reset" value="Cancel Changes" type="reset">
            <br>
            
            <a href="figure9AdminMenuPage.jsp"><img
                style="border: 0px solid ; width: 30px; height: 20px;" alt="Back"
                src="Images/back.jpg"></a> Back to Menu
            <br>
        </form>
    </body></html>

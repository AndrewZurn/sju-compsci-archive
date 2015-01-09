<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@include file = "verifyLoginUser.jsp"%>
<html>
    <head>

        <title>View Matching School With Recommended School</title></head>
    <body background="Images/cmc3.jpg">&nbsp;

        <%
        String univName = request.getParameter("School");
        try {
                String un = (String) session.getAttribute("currentUser");
                University univ = DatabaseController.getSpecificUniversity(univName);
                session.setAttribute("univ", univ);
                FiveRecSchoolsController fiveRec = new FiveRecSchoolsController(univ);
                ArrayList<University> uniList = fiveRec.getFiveMatches();
                University u1 = uniList.get(0);
                session.setAttribute("u1", u1);
                University u2 = uniList.get(1);
                session.setAttribute("u2", u2);
                University u3 = uniList.get(2);
                session.setAttribute("u3", u3);
                University u4 = uniList.get(3);
                session.setAttribute("u4", u4);
                University u5 = uniList.get(4);
                session.setAttribute("u5", u5);
        %>

        <a href="figure7SearchResults.jsp"><img
                style="border: 0px solid ; width: 30px; height: 20px;" alt="Back"
                src="Images/back.jpg"></a> Back To Search

        <form method="post" action="figure8ViewMatchingSchoolWithRecommendedSchools_action.jsp?Univ=0">
            <input name="Submit" value="Save" type="submit"><br>

            <table style="text-align: left; width: 800px;" border="2" cellpadding="2" cellspacing="2">

                <tbody>
                    <tr>
                        <td style="vertical-align: top; width: 350px">SCHOOL<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getSchool()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">STATE<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getState()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">LOCATION<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getLocation()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">CONTROL<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getControl()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">NUMBER OF STUDENTS<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getNumberOfStudents()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">% FEMALE<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getPercentFemales()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">SAT VERBAL<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getSATVerbal()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">SAT MATH<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getSATMath()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">EXPENSES<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getExpenses()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">% FINANCIAL AID<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getPercentFinancialAid()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">NUMBER OF APPLICANTS<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getNumberOfApplicants()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">% ADMITTED<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getPercentAdmitted()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">% ENROLLED<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getPercentEnrolled()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">ACADEMIC SCALE
                            (1-5)<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getAcademicsScale()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">SOCIAL SCALE (1-5)<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getSocialScale()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">QUALITY OF LIFE
                            SCALE (1-5)<br>
                        </td>
                        <td style="vertical-align: top;"><%=univ.getQualityOfLifeScale()%><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">EMPHASES<br>
                        </td>
                        <td style="vertical-align: top;">
                            <%
                                try {
                                    ArrayList<String> empList = univ.getEmphases();
                                    for (int i = 0; i < empList.size(); i++) {
                                        out.println(empList.get(i) + "<br>");
                                    }

                                } catch (Exception ie) {
                                    response.sendRedirect("figure12ViewEditUniversity.jsp");
                                    return;
                                }
                            %>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>

        <hr>
        Might We Also Recommend<br>

        <%for (int j = 1; j <= 5; j++) {
                if (j == 1) {
                    out.println("<form method=\"post\" action=\"figure8ViewMatchingSchoolWithRecommendedSchools_action.jsp?Univ=1\">");
                }
                if (j == 2) {
                    out.println("<form method=\"post\" action=\"figure8ViewMatchingSchoolWithRecommendedSchools_action.jsp?Univ=2\">");
                }
                if (j == 3) {
                    out.println("<form method=\"post\" action=\"figure8ViewMatchingSchoolWithRecommendedSchools_action.jsp?Univ=3\">");
                }
                if (j == 4) {
                    out.println("<form method=\"post\" action=\"figure8ViewMatchingSchoolWithRecommendedSchools_action.jsp?Univ=4\">");
                }
                if (j == 5) {
                    out.println("<form method=\"post\" action=\"figure8ViewMatchingSchoolWithRecommendedSchools_action.jsp?Univ=5\">");
                }
        %>

        <input name="Submit" value="Save" type="submit">
        &nbsp; School #<%=j%><br>

        <table style="text-align: left; width: 800px;" border="2" cellpadding="2" cellspacing="2">
            <tbody>
                <tr>
                    <td style="vertical-align: top; width: 350px">SCHOOL<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getSchool()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">STATE<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getState()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">LOCATION<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getLocation()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">CONTROL<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getControl()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">NUMBER OF STUDENTS<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getNumberOfStudents()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">% FEMALE<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getPercentFemales()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">SAT VERBAL<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getSATVerbal()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">SAT MATH<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getSATMath()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">EXPENSES<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getExpenses()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">% FINANCIAL AID<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getPercentFinancialAid()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">NUMBER OF
                        APPLICANTS<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getNumberOfApplicants()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">% ADMITTED<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getPercentAdmitted()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">% ENROLLED<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getPercentEnrolled()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">ACADEMIC SCALE
                        (1-5)<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getAcademicsScale()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">SOCIAL SCALE (1-5)<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getSocialScale()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">QUALITY OF LIFE
                        SCALE (1-5)<br>
                    </td>
                    <td style="vertical-align: top;"><%=uniList.get(j - 1).getQualityOfLifeScale()%><br>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">EMPHASES<br>
                    </td>
                    <td style="vertical-align: top;">
                        <%
                            try {
                                ArrayList<String> empList = uniList.get(j - 1).getEmphases();
                                for (int i = 0; i < empList.size(); i++) {
                                    out.println(empList.get(i) + "<br>");
                                }

                            } catch (Exception ie) {
                                response.sendRedirect("figure12ViewEditUniversity.jsp");
                                return;
                            }
                        %>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
    <br>
    <%}
            } catch (Exception ex) {
                response.sendRedirect("figure7SearchResults.jsp?Error=1&ErrorSchool="+univName);
            }
        %>
</body>
</html>

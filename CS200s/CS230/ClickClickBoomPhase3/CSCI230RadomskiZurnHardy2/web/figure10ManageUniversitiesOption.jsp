<%-- 
    Document   : figure10ManageUniversitiesOption
    Created on : Apr 9, 2012, 6:59:19 PM
    Author     : pghardy
--%>

<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>figure10ManageUniversitiesOption</title>
</head>
<body>
<a href="figure9AdminMenuPage.jsp">Back to Menu</a><br>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<td colspan="17" rowspan="1"
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
<td style="vertical-align: top; text-align: center;">% Financial
Aid<br>
</td>
<td style="vertical-align: top; text-align: center;"># of
Applicants<br>
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
<td style="vertical-align: top; text-align: center;"><br>
</td>
</tr>


<%
ArrayList<University> allSchools = null;
University temp;

try{
    allSchools = DatabaseController.getAllUniversities();
}
catch(Exception e){
    out.println("Exception: " + e);
}

for(int i = 0; i < allSchools.size(); i++){
    temp= allSchools.get(i);
out.println("<tr>");
out.println("<td style=\"vertical-align: top;\">"+temp.getSchool()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getState()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getLocation()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getNumberOfStudents()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getPercentFemales()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getSATVerbal()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getSATMath()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getExpenses()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getPercentFinancialAid()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getNumberOfApplicants()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getPercentAdmitted()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getPercentEnrolled()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getAcademicsScale()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getSocialScale()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getQualityOfLifeScale()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">"+temp.getEmphases()+"<br></td>");
out.println("<td style=\"vertical-align: top;\">EDIT BUTTONS<br></td>");
out.println("</tr>");
}
%>


</tbody>
</table>
<br>
<br>
</body>
</html>

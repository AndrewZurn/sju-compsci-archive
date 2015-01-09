<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginUser.jsp"%>
<html>
    <head>
        <title>Search Results</title>
    </head>
    <body background="Images/cmc3.jpg">
        <a href="figure6SchoolSearchMenu.jsp?Redo=1"><img
                style="border: 0px solid ; width: 30px; height: 20px;" alt="Back"
                src="Images/back.jpg"></a> Back to Search Criteria

        <table style="text-align: left; width: 750px;" border="2" cellpadding="2"
               cellspacing="2">
            <tbody>
                <%

                    ArrayList<University> search = (ArrayList<University>) session.getAttribute("currentSearch");
                    if (search != null) {
                        for (int i = 0; i < search.size(); i++) {
                            University uni = search.get(i);
                            String temp2 = uni.getSchool();
                %>
                <tr>
                    <td style="vertical-align: middle; width: 125px; text-align: center;">
                        <form method="post" action="figure5ViewSchool_action.jsp" name="AddSavedSchool">
                            <input name="AddSchool" value="Add To Saved Schools" type="submit">
                            <input name="school" value="<%=temp2%>" type="hidden">
                        </form>
                        <img style="width: 30px; height: 35px;" alt="Add"
                        src="Images/up.jpg">
                        <br>
                    </td>
                    <td style="vertical-align: middle;">
                <center><%=temp2%></center>
                    </td>
                    <td style="vertical-align: middle; width: 125px; text-align: center;">

                        <form method="post" action="figure8ViewMatchingSchoolWithRecommendedSchools.jsp" name="ViewButton">
                            <input name="View" value="View" type="submit">
                            <input name="School" value="<%=temp2%>" type="hidden">
                        </form>
                        <img style="width: 52px; height: 32px;" alt="View"
                        src="Images/bino.jpg"> 

                    </td>
                </tr>
                <%}
    } %>
            </tbody>
        </table>
       <%
        String anyErrors = request.getParameter("Error");
    if(anyErrors!=null){
        if (anyErrors.equals("1")){%>
            There was an error processing that specific school.<br>
            Request that an Administrator checks the school: <%=request.getParameter("ErrorSchool")%>
        <%}
    }
       
       
       %>
    </body>
</html>

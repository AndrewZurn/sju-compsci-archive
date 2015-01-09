<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@include file = "verifyLoginAdmin.jsp"%>
<%

        String school = request.getParameter("School");
        String state = request.getParameter("State");
        String location = request.getParameter("Location");
        String control = request.getParameter("Control");
        Integer numberOfStudents = Integer.parseInt(request.getParameter("NumberOfStudents"));
        Double percentageFemales = Double.parseDouble(request.getParameter("PercentageFemales"));
        Double SATVerbal = Double.parseDouble(request.getParameter("SATVerbal"));
        Double SATMath = Double.parseDouble(request.getParameter("SATMath"));
        Double expenses = Double.parseDouble(request.getParameter("Expenses"));
        Double percentageFinAid = Double.parseDouble(request.getParameter("PercentageFinAid"));
        Integer numberApplicants = Integer.parseInt(request.getParameter("NumberOfApplicants"));
        Double percentageAdmitted = Double.parseDouble(request.getParameter("PercentageAdmitted"));
        Double percentageEnrolled = Double.parseDouble(request.getParameter("PercentageEnrolled"));
        Integer academicScale = Integer.parseInt(request.getParameter("AcademicsScale"));
        Integer socialScale = Integer.parseInt(request.getParameter("SocialScale"));
        Integer qualityScale = Integer.parseInt(request.getParameter("QualityScale"));
        ArrayList<String> emphasesList = new ArrayList<String>();
        try {
        //for(int i = 0; i < 5; i++){
        //    String n = Integer.toString(i);
        //    if (!request.getParameter("Emphasis"+n).equals("")) {
        //        emphasesList.add(request.getParameter("Emphasis"+n));
        //    }
        //}
        //Maybe this would work??
        if (!request.getParameter("Emphasis0").equals("")) {
            emphasesList.add(request.getParameter("Emphasis0"));
        }
        if (!request.getParameter("Emphasis1").equals("")) {
            emphasesList.add(request.getParameter("Emphasis1"));
        }
        if (!request.getParameter("Emphasis2").equals("")) {
            emphasesList.add(request.getParameter("Emphasis2"));
        }
        if (!request.getParameter("Emphasis3").equals("")) {
            emphasesList.add(request.getParameter("Emphasis3"));
        }
        if (!request.getParameter("Emphasis4").equals("")) {
           emphasesList.add(request.getParameter("Emphasis4"));
        }
        
        AdminController.editUniversity(school, state, location, control, numberOfStudents, percentageFemales,
                SATVerbal, SATMath, expenses, percentageFinAid, numberApplicants,
                percentageAdmitted, percentageEnrolled, academicScale, socialScale, qualityScale);
        AdminController.editUniversityEmphases(school, emphasesList);
        response.sendRedirect("figure10ManageUniversitiesOption.jsp");
    } catch (Exception ie) {
        response.sendRedirect("figure10ManageUniversitiesOption.jsp?Error="+ie);
    }
%>

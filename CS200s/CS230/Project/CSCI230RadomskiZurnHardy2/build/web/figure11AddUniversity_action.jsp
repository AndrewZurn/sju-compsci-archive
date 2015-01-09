<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<%@include file = "verifyLoginAdmin.jsp"%>
<%
    try {
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
        Integer academicScale = Integer.parseInt(request.getParameter("AcademicScale"));
        Integer socialScale = Integer.parseInt(request.getParameter("SocialScale"));
        Integer qualityScale = Integer.parseInt(request.getParameter("QualityScale"));
        ArrayList<String> emphasesList = new ArrayList<String>();
        //for(int i = 1; i < 6; i++){
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


        AdminController.addUniversity(school, state, location, control, numberOfStudents, percentageFemales,
                SATVerbal, SATMath, expenses, percentageFinAid, numberApplicants,
                percentageAdmitted, percentageEnrolled, academicScale, socialScale, qualityScale);
        for (String str : emphasesList) {
            AdminController.addUniversityEmphasis(school, str);
        }
        response.sendRedirect("figure10ManageUniversitiesOption.jsp");
    } catch (Exception ie) {
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
        Integer academicScale = Integer.parseInt(request.getParameter("AcademicScale"));
        Integer socialScale = Integer.parseInt(request.getParameter("SocialScale"));
        Integer qualityScale = Integer.parseInt(request.getParameter("QualityScale"));
        ArrayList<String> emphasesList = new ArrayList<String>();
        if (!request.getParameter("Emphasis1").equals("")) {
            emphasesList.add(request.getParameter("Emphasis1"));
        } else if (request.getParameter("Emphasis1").equals("")) {
            emphasesList.add("");
        }
        if (!request.getParameter("Emphasis2").equals("")) {
            emphasesList.add(request.getParameter("Emphasis2"));
        } else if (request.getParameter("Emphasis2").equals("")) {
            emphasesList.add("");
        }
        if (!request.getParameter("Emphasis3").equals("")) {
            emphasesList.add(request.getParameter("Emphasis3"));
        } else if (request.getParameter("Emphasis3").equals("")) {
            emphasesList.add("");
        }
        if (!request.getParameter("Emphasis4").equals("")) {
            emphasesList.add(request.getParameter("Emphasis4"));
        } else if (request.getParameter("Emphasis4").equals("")) {
            emphasesList.add("");
        }
        if (!request.getParameter("Emphasis5").equals("")) {
            emphasesList.add(request.getParameter("Emphasis5"));
        } else if (request.getParameter("Emphasis5").equals("")) {
            emphasesList.add("");
        }
        University u = new University(school, state, location, control, numberOfStudents, percentageFemales,
                SATVerbal, SATMath, expenses, percentageFinAid, numberApplicants, percentageAdmitted,
                percentageEnrolled, academicScale, socialScale, qualityScale);
        session.setAttribute("u", u);
        session.setAttribute("l", emphasesList);
        response.sendRedirect("figure11AddUniversity.jsp?Error=1");
    }
%>

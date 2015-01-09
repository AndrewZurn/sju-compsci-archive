<%-- 
    Document   : figure8ViewMatchingSchoolWithRecommendedSchools_action
    Created on : May 1, 2012, 8:15:22 PM
    Author     : awzurn
--%>
<%@page import="org.apache.naming.factory.SendMailFactory"%>
<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@include file = "verifyLoginUser.jsp"%>

<%
    try {
        String un = (String) session.getAttribute("currentUser");
        University univ = (University) session.getAttribute("univ");
        University u1 = (University) session.getAttribute("u1");
        University u2 = (University) session.getAttribute("u2");
        University u3 = (University) session.getAttribute("u3");
        University u4 = (University) session.getAttribute("u4");
        University u5 = (University) session.getAttribute("u5");
        String whichUni = request.getParameter("Univ");
        Integer uniNum = Integer.parseInt(whichUni);
        if (uniNum == 0) {
            UserController.addUserSchool(DatabaseController.getID(un), univ.getSchool());
        } else if (uniNum == 1) {
            UserController.addUserSchool(DatabaseController.getID(un), u1.getSchool());
        } else if (uniNum == 2) {
            UserController.addUserSchool(DatabaseController.getID(un), u2.getSchool());
        } else if (uniNum == 3) {
            UserController.addUserSchool(DatabaseController.getID(un), u3.getSchool());
        } else if (uniNum == 4) {
            UserController.addUserSchool(DatabaseController.getID(un), u4.getSchool());
        } else if (uniNum == 5) {
            UserController.addUserSchool(DatabaseController.getID(un), u5.getSchool());
        }
        session.removeAttribute("univ");
        session.removeAttribute("u1");
        session.removeAttribute("u2");
        session.removeAttribute("u3");
        session.removeAttribute("u4");
        session.removeAttribute("u5");
        response.sendRedirect("figure4ManageSavedSchoolsPage.jsp");
    } catch (Exception ie) {
        session.removeAttribute("univ");
        session.removeAttribute("u1");
        session.removeAttribute("u2");
        session.removeAttribute("u3");
        session.removeAttribute("u4");
        session.removeAttribute("u5");
        response.sendRedirect("figure7SearchResults.jsp?Error=1");
    }

%>

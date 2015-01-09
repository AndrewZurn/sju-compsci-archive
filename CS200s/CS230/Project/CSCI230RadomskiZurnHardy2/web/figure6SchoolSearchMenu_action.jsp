<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@include file = "verifyLoginUser.jsp"%>
<html>
    <head>
        <title>Searching</title>
    </head>
    <body background="Images/cmc3.jpg">
        <%
        String school1 = request.getParameter("school");
        String state1 = request.getParameter("state");
        String location1 = request.getParameter("location");
        String control1 = request.getParameter("control");
        
        Integer lowNumStudents;
        if(!request.getParameter("lowStudents").equals("")){
             lowNumStudents = Integer.parseInt(request.getParameter("lowStudents"));
        }
        else{
            lowNumStudents = null;
        }
        
        Integer highNumStudents;
        if(!request.getParameter("highStudents").equals("")){
            highNumStudents = Integer.parseInt(request.getParameter("highStudents"));
        }
        else{
            highNumStudents = null;
        }
        
        Double lowPercentFemale;
        if(!request.getParameter("lowpercentFemale").equals("")){
            lowPercentFemale = Double.parseDouble(request.getParameter("lowpercentFemale"));
        }
        else{
            lowPercentFemale = null;
        }
        Double highPercentFemale;
        if(!request.getParameter("highpercentFemale").equals("")){
            highPercentFemale = Double.parseDouble(request.getParameter("highpercentFemale"));
        }
        else{
            highPercentFemale = null;
        }
        
        Double lowVerbal;
        if(!request.getParameter("lowverbal").equals("")){
            lowVerbal = Double.parseDouble(request.getParameter("lowverbal"));
        }
        else{
            lowVerbal = null;
        }
        
        Double highVerbal;
        if(!request.getParameter("highverbal").equals("")){
            highVerbal = Double.parseDouble(request.getParameter("highverbal"));
        }
        else{
            highVerbal = null;
        }
        
        Double lowMath;
        if(!request.getParameter("lowmath").equals("")){
            lowMath = Double.parseDouble(request.getParameter("lowmath"));
        }
        else{
            lowMath = null;
        }
        Double highMath;
        if(!request.getParameter("highmath").equals("")){
             highMath = Double.parseDouble(request.getParameter("highmath"));
        }
        else{
             highMath = null;
        }
        Double lowExpenses;
        if(!request.getParameter("lowexpenses").equals("")){
             lowExpenses = Double.parseDouble(request.getParameter("lowexpenses"));
        }
        else{
            lowExpenses = null;
        }
        Double highExpenses;
        if(!request.getParameter("highexpenses").equals("")){
            highExpenses = Double.parseDouble(request.getParameter("highexpenses"));
        }
        else{
            highExpenses = null;
        }
        
        Double lowAid;
        if(!request.getParameter("lowfinancialAid").equals("")){
            lowAid = Double.parseDouble(request.getParameter("lowfinancialAid"));
        }
        else{
            lowAid = null;
        }
        Double highAid;
        if(!request.getParameter("highfinancialAid").equals("")){
           highAid = Double.parseDouble(request.getParameter("highfinancialAid"));
        }
        else{
            highAid = null;
        }
        
        Integer lowApp;
        if(!request.getParameter("lownumberApp").equals("")){
           lowApp = Integer.parseInt(request.getParameter("lownumberApp"));
        }
        else{
           lowApp = null;
        }
        
        Integer highApp;
        if(!request.getParameter("highnumberApp").equals("")){
           highApp = Integer.parseInt(request.getParameter("highnumberApp"));
        }
        else{
            highApp = null;
                  }
        Double lowAdd;
        if(!request.getParameter("lowpercentAdd").equals("")){
           lowAdd = Double.parseDouble(request.getParameter("lowpercentAdd"));
        }
        else{
            lowAdd = null;
        }
        Double highAdd;
        if(!request.getParameter("highpercentAdd").equals("")){
           highAdd = Double.parseDouble(request.getParameter("highpercentAdd"));
        }
        else{
           highAdd = null;
        }
        Double highEnroll;
        if(!request.getParameter("highpercentEn").equals("")){
           highEnroll = Double.parseDouble(request.getParameter("highpercentEn"));
        }
        else{
            highEnroll = null;
        }
        
        Double lowEnroll;
        if(!request.getParameter("lowpercentEn").equals("")){
           lowEnroll = Double.parseDouble(request.getParameter("lowpercentEn"));
        }
        else{
           lowEnroll = null;
        }
        Integer lowAcademic;
        if(!request.getParameter("lowacademicScale").equals("")){
           lowAcademic = Integer.parseInt(request.getParameter("lowacademicScale"));
        }
        else{
            lowAcademic = null;
        }
        Integer highAcademic;
        if(!request.getParameter("highacademicScale").equals("")){
           highAcademic = Integer.parseInt(request.getParameter("highacademicScale"));
        }
        else{
           highAcademic = null;
        }
        Integer lowSocial;
        if(!request.getParameter("lowsocialScale").equals("")){
          lowSocial = Integer.parseInt(request.getParameter("lowsocialScale"));
        }
        else{
            lowSocial = null;
        }
        Integer highSocial;
        if(!request.getParameter("highsocialScale").equals("")){
          highSocial = Integer.parseInt(request.getParameter("highsocialScale"));
        }
        else{
            highSocial = null;
        }
        Integer lowQOL;
        if(!request.getParameter("lowpercentEn").equals("")){
           lowQOL = Integer.parseInt(request.getParameter("lowqolScale"));
        }
        else{
            lowQOL = null;
        }
        Integer highQOL;
        if(!request.getParameter("highqolScale").equals("")){
           highQOL = Integer.parseInt(request.getParameter("highqolScale"));
        }
        else{
           highQOL = null;
        }
        
        ArrayList<String> emphasesList = new ArrayList<String>();
        String emphase1="";
        String emphase2="";
        String emphase3="";
        String emphase4="";
        String emphase5="";
        if(!request.getParameter("emphase1").equals("")){
          emphase1 = request.getParameter("emphase1");
          emphasesList.add(emphase1);
        }
         if(!request.getParameter("emphase2").equals("")){
          emphase2 = request.getParameter("emphase2");
          emphasesList.add(emphase2);
        }
          if(!request.getParameter("emphase3").equals("")){
          emphase3 = request.getParameter("emphase3");
          emphasesList.add(emphase3);
        }
          if(!request.getParameter("emphase4").equals("")){
          emphase4 = request.getParameter("emphase4");
          emphasesList.add(emphase4);
        }
          if(!request.getParameter("emphase5").equals("")){
          emphase5 = request.getParameter("emphase5");
          emphasesList.add(emphase5);
        }
        ArrayList<Object> redo = new ArrayList<Object>();
        redo.add(school1);redo.add(state1);redo.add(location1);redo.add(control1);
        redo.add(request.getParameter("lowStudents"));redo.add(request.getParameter("highStudents"));redo.add(request.getParameter("lowpercentFemale"));redo.add(request.getParameter("highpercentFemale"));
        redo.add(request.getParameter("lowverbal"));redo.add(request.getParameter("highverbal"));redo.add(request.getParameter("lowmath"));redo.add(request.getParameter("highmath"));
        redo.add(request.getParameter("lowexpenses"));redo.add(request.getParameter("highexpenses"));redo.add(request.getParameter("lowfinancialAid"));redo.add(request.getParameter("highfinancialAid"));
        redo.add(request.getParameter("lownumberApp"));redo.add(request.getParameter("highnumberApp"));redo.add(request.getParameter("lowpercentAdd"));redo.add(request.getParameter("highpercentAdd"));
        redo.add(request.getParameter("lowpercentEn"));redo.add(request.getParameter("highpercentEn"));redo.add(request.getParameter("lowacademicScale"));redo.add(request.getParameter("highacademicScale"));
        redo.add(request.getParameter("lowsocialScale"));redo.add(request.getParameter("highsocialScale"));redo.add(request.getParameter("lowqolScale"));redo.add(request.getParameter("highqolScale"));
        redo.add(emphase1);redo.add(emphase2);redo.add(emphase3);redo.add(emphase4);
        redo.add(emphase5);//Info to save for later!
        
        session.setAttribute("redoInfo", redo);
       
        ArrayList<University> searched = SearchController.search(school1, state1,location1, control1, lowNumStudents , highNumStudents , lowPercentFemale , highPercentFemale , lowVerbal , highVerbal , lowMath , highMath , lowExpenses , highExpenses , lowAid, highAid , lowApp , highApp , lowAdd, highAdd, lowEnroll, highEnroll, lowAcademic, highAcademic, lowSocial , highSocial , lowQOL, highQOL , emphasesList);
        session.setAttribute("currentSearch", searched);
        response.sendRedirect("figure7SearchResults.jsp");
%>
        <%
    //        String school = request.getParameter("school");
    //       String state1 = request.getParameter("state");
    //       String location = request.getParameter("location");
    //        String control = request.getParameter("control");
    //        int lowNumStudents = Integer.parseInt(request.getParameter("lowStudents"));
    //        int highNumStudents = Integer.parseInt(request.getParameter("highStudents"));
    //        double lowPercentFemale = Double.parseDouble(request.getParameter("lowpercentFemale"));
    //        double highPercentFemale = Double.parseDouble(request.getParameter("highpercentFemale"));
    //        double lowVerbal = Double.parseDouble(request.getParameter("lowverbal"));
    //        double highVerbal = Double.parseDouble(request.getParameter("highverbal"));
    //        double lowMath = Double.parseDouble(request.getParameter("lowmath"));
    //        double highMath = Double.parseDouble(request.getParameter("highmath"));
    //        double lowExpenses = Double.parseDouble(request.getParameter("lowexpenses"));
   //         double highExpenses = Double.parseDouble(request.getParameter("highexpenses"));
   //         double lowAid = Integer.parseInt(request.getParameter("lowfinancialAid"));
   //         double highAid = Integer.parseInt(request.getParameter("highfinancialAid"));
   //         int lowApp = Integer.parseInt(request.getParameter("lownumberApp"));
   //         int highApp = Integer.parseInt(request.getParameter("highnumberApp"));
   //         double lowAdd = Integer.parseInt(request.getParameter("lowpercentAdd"));
   //         double highAdd = Integer.parseInt(request.getParameter("highpercentAdd"));
   //         double lowEnroll = Integer.parseInt(request.getParameter("lowpercentEn"));
   //         double highEnroll = Integer.parseInt(request.getParameter("highpercentEn"));
   //         int lowAcademic = Integer.parseInt(request.getParameter("lowacademicScale"));
   //         int highAcademic = Integer.parseInt(request.getParameter("highacademicScale"));
   //         int lowSocial = Integer.parseInt(request.getParameter("lowsocialScale"));
   //         int highSocial = Integer.parseInt(request.getParameter("highsocialScale"));
   //         int lowQOL = Integer.parseInt(request.getParameter("lowqolScale"));
   //         int highQOL = Integer.parseInt(request.getParameter("highqolScale"));
   //         String emphases = request.getParameter("emphases");
   //         ArrayList<String> emphasesList = new ArrayList<String>();
   //         ArrayList<University> searched = SearchController.search(school, state1, location, control, lowNumStudents, highNumStudents, lowPercentFemale, highPercentFemale, lowVerbal, highVerbal, lowMath, highMath, lowExpenses, highExpenses, lowAid, highAid, lowApp, highApp, lowAdd, highAdd, lowEnroll, highEnroll, lowAcademic, highAcademic, lowSocial, highSocial, lowQOL, highQOL, emphasesList);
   //         session.setAttribute("currentSearch", searched);
   //         response.sendRedirect("figure7SearchResults.jsp");
        %>

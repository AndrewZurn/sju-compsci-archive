<%@include file="verifyLogin.jsp"%>
<%
    out.println("delete user : " + request.getParameter("Username"));
    UserController uc = (UserController) session.getAttribute("uc");
    String[][] returnUser = uc.getSpecificUser(request.getParameter("Username"));
    User user = new User(returnUser[0][0], returnUser[0][1], returnUser[0][2],
            Integer.parseInt(returnUser[0][3]), returnUser[0][4], returnUser[0][5] );
    uc.deleteUser(user);
    response.sendRedirect("Menu.jsp");
    
%>
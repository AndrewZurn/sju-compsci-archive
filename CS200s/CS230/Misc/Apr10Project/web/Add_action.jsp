<%@include file="verifyLogin.jsp"%>

<% 
String fullName = request.getParameter("FullName");
String userName = request.getParameter("Username");
String password = request.getParameter("Password");
int age = Integer.parseInt(request.getParameter("Age"));
String city = request.getParameter("City");
String state = request.getParameter("State");
User user = new User(fullName,userName,password,age,city,state);
UserController uc = (UserController) session.getAttribute("uc");
uc.addUser(user);
response.sendRedirect("Menu.jsp");



%>
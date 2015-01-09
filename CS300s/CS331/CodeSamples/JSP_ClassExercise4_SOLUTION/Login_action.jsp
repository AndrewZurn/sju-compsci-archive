<%@ page language="java" import="java.sql.*"%>
<%@ page  import="java.util.*"%>

<jsp:useBean id="customer" class="irahal.productdeals.Customer" scope="session"/> 
<jsp:setProperty name="customer" property="*"/> 
<%="CUST: " + customer.getCustomerNumber()%>
<%="LAST: " + customer.getLast()%>

<% if (customer.login())
    response.sendRedirect("Welcome.jsp");
   else
    response.sendRedirect("index.jsp");
%> 



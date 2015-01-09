<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="customer" class="irahal.productdeals.Customer" scope="session"/> 
<% 
    try{
        customer.logout();
    }
    catch(IllegalStateException ise){
        out.println(ise.getMessage());
    }
    response.sendRedirect("index.jsp");
   %> 

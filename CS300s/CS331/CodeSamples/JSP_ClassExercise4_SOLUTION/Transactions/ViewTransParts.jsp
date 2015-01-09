


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="customer" class="irahal.productdeals.Customer" scope="session"/> 

<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title></title>
</head>
<body>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;">PART NUMBER<br>
</td>
<td style="vertical-align: top;">PART DESCRIPTION<br>
</td>
<td style="vertical-align: top;">QUOTED PRICE <br>
</td>
<td style="vertical-align: top;">NUMBER ORDERED <br>
</td>
</tr>
  <% 
    try{
        ResultSet rs = customer.getTransactionParts(request.getParameter("TransNumber"));
     while (rs.next()){%>
<tr>
<td style="vertical-align: top;"><%=rs.getString("PART_NUMBER")%><br>
</td>
<td style="vertical-align: top;"><%=rs.getString("PART_DESCRIPTION")%></td>

<td style="vertical-align: top;"><%= rs.getString("QUOTED_PRICE")%></td> 

<td style="vertical-align: top;"><%= rs.getString("NUMBER_ORDERED")%></td>
</tr>
  <% }
  rs.close();
    }
    catch(IllegalStateException ise){
        out.println(ise.getMessage());
    }

%>
</tbody>
</table>
<form method="post" action="MyTransactions.jsp">  
<input name="Submit" value="Back to my transactions" type="submit"><br>
</form>
<br>
</body>
</html>

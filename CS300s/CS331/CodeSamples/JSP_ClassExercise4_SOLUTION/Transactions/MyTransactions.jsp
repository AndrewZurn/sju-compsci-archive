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
<td style="vertical-align: top;">TRANS DATE<br>
</td>
<td style="vertical-align: top;">TRANS NUMBER<br>
</td>
<td style="vertical-align: top;">TOTAL <br>
</td>
<td style="vertical-align: top;"><br>
</td>
</tr>
  <% 
  try{ 
  ResultSet rs = customer.getAllTransactions();
    while (rs.next()){%>
<tr>
<td style="vertical-align: top;"><%=rs.getString("TRANS_DATE")%><br>
</td>
<td style="vertical-align: top;"><%=rs.getString("TRANS_NUMBER")%></td>

<td style="vertical-align: top;"><%= customer.getTransactionTotalValue(rs.getString("TRANS_NUMBER"))%></td> 

<td style="vertical-align: top;">
<form method="post" action="ViewTransParts.jsp" name="ViewParts">
    <input name="TransNumber" type="hidden" value="<%=rs.getString("TRANS_NUMBER")%>">
    <input name="View" value="View" type="submit"><br>
</form>
<br>
</td>
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

<form method="post" action="../Welcome.jsp">  
<input name="Submit" value="Back to menu" type="submit"><br>
</form>
<br>
</body>
</html>

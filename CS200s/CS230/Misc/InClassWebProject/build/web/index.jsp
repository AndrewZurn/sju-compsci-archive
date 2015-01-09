<%-- 
    Document   : classExercise
    Created on : Apr 3, 2012, 3:04:34 PM
    Author     : awzurn
--%>

<%@page language="java"%>

<html>
    <head>
        <title>classexerise.jsp</title>
    </head>
    <body><br>
<form action="createTable.jsp" name="Information">
  <table style="text-align: left; width: 100%;" border="1" cellpadding="2" cellspacing="2">
    <tbody>
      <tr>
        <td style="vertical-align: top;">Enter Your Name<br>
        </td>
        <td style="vertical-align: top;"><input name="Name"><br>
        </td>
      </tr>
      <tr>
        <td style="vertical-align: top;">Enter Number of Rows<br>
        </td>
        <td style="vertical-align: top;"><input value="1" name="Rows"><br>
        </td>
      </tr>
      <tr>
        <td style="vertical-align: top;">Enter Number of Columns<br>
        </td>
        <td style="vertical-align: top;"><input name="Columns" value="1"></td>
      </tr>
      <tr>
        <td style="vertical-align: top;"><a href="createtable.htm"><input name="Submit" value="Submit" type="submit"></a><br>
        </td>
        <td style="vertical-align: top;"><a href="classexerise.htm"><input name="Reset" value="Reset" type="reset"></a><br>
        </td>
      </tr>
    </tbody>
  </table>
  <br>
</form>


</body>
</html>


<%@page language="java"%>
<html>
<head>
<title>Sample Login Page</title>
</head>
<body>
<br>
<br>
<%
        String anyErrors = request.getParameter("Error");
        if(anyErrors!=null && anyErrors.equals("1")){
            out.println("PLEASE PROVIDE A ROW VALUE >=1");
        }
        else if(anyErrors!=null && anyErrors.equals("2")){
            out.println("PLEASE PROVIDE A COL VALUE >=1");
        }
%>

<form method="post" action="createTable.jsp">
    Your Name <input name="YourName"><br>
    Number of Rows <input name="NumRows" value="1"><br>
    Number of Cols <input name="NumCols" value="1"><br>
    <input value="Create Table" type="submit"> 
    <input value="Reset" type="reset"><br>
</form>
</body>
</html>


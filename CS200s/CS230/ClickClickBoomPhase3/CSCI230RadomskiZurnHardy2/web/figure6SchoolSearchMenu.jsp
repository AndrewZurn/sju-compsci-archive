<%-- 
    Document   : figure6SchoolSearchMenu
    Created on : Apr 9, 2012, 5:05:46 PM
    Author     : wjradomski
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title></title>
</head>
<body>
<a href="figure2UserMenuPage.jsp">Return to User Menu</a>
<form>
<table style="text-align: left; width: 695px; height: 385px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;">School<br>
</td>
<td style="vertical-align: top;"><input type=text school=school%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">State<br>
</td>
<td style="vertical-align: top;"><input type=text state=state%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Location<br>
</td>
<td style="vertical-align: top;"><select>
  <option value ="rural">Rural</option>
  <option value ="urban">Urban</option>
</select>
<br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Control<br>
</td>
<td style="vertical-align: top;"><select>
  <option value ="public">Public</option>
  <option value ="private">Private</option>
</select><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Number Of Students<br>
</td>
<td style="vertical-align: top;">From<input type=integer lowStudents=lowStudents%><br>To<input type=integer highStudents=highStudents%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Percent Female<br>
</td>
<td style="vertical-align: top;">From<input type=integer lowpercentFemale=lowpercentFemale%><br>To<input type=integer highpercentFemale=highpercentFemale%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">SAT Verbal<br>
</td>
<td style="vertical-align: top;">From<input type=integer lowverbal=lowverbal%><br>To<input type=integer highverbal=highverbal%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">SAT Math<br>
</td>
<td style="vertical-align: top;">From<input type=integer lowmath=lowmath%><br>To<input type=integer highmath=highmath%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Expenses<br>
</td>
<td style="vertical-align: top;">From<input type=integer expenses=lowExpenses%><br>To<input type=integer expenses=highExpenses%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Percent Recieving Financial Aid<br>
</td>
<td style="vertical-align: top;">From<input type=integer lowfinancialAid=lowfinancialAid%><br>To<input type=integer highfinancialAid=highfinancialAid%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Number of Applicants<br>
</td>
<td style="vertical-align: top;">From<input type=integer lownumberApp=lownumberApp%><br>To<input type=integer highnumberApp=highnumberApp%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Percent Admitted<br>
</td>
<td style="vertical-align: top;">From<input type=integer lowpercentAdd=lowpercentAdd%><br>To<input type=integer highpercentAdd=highpercentAdd%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Percent Enrolled<br>
</td>
<td style="vertical-align: top;">From<input type=integer lowpercentEn=lowpercentEn%><br>To<input type=integer highpercentEn=highpercentEn%><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Academic Scale (1-5)<br>
</td>
<td style="vertical-align: top;">
    <input type="radio" name="academic" value="one" /> 1 
<input type="radio" name="academic" value="two" /> 2 
<input type="radio" name="academic" value="three" /> 3
<input type="radio" name="academic" value="four" /> 4 
<input type="radio" name="academic" value="five" /> 5 
    <br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Social Scale (1-5)<br>
</td>
<td style="vertical-align: top;">
<input type="radio" name="social" value="one" /> 1 
<input type="radio" name="social" value="two" /> 2 
<input type="radio" name="social" value="three" /> 3 
<input type="radio" name="social" value="four" /> 4 
<input type="radio" name="social" value="five" /> 5 
<br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Quality of Life Scale (1-5)<br>
</td>
<td style="vertical-align: top;">
<input type="radio" name="qols" value="one" /> 1 
<input type="radio" name="qols" value="two" /> 2 
<input type="radio" name="qols" value="three" /> 3 
<input type="radio" name="qols" value="four" /> 4 
<input type="radio" name="qols" value="five" /> 5 
<br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Emphases<br>
</td>
<td style="vertical-align: top;">
<input type="checkbox" name="drinks" value="emphasis1" /> Choice 1 <br>
<input type="checkbox" name="drinks" value="emphasis2" /> Choice 2 <br>
<input type="checkbox" name="drinks" value="emphasis3" /> Choice 3 <br>
</td>
</tr>
</tbody>
</table>
</form>
<br>
<p><input type="submit"> <br>
</p>
<p><input type="reset"><br>
</p>
<br>
</body>
</html>
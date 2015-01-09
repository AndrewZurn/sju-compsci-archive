<%@page language="java"%>
<%@page import="csci230radomskizurnhardy.*"%>
<%@page import="java.util.ArrayList"%>
<%@include file = "verifyLoginUser.jsp"%>
<html>
    <head>
        <title>School Search Menu</title>
    </head>
    <body background="Images/cmc3.jpg">
        
        <a href="figure2UserMenuPage.jsp"><img
        style="border: 0px solid ; width: 30px; height: 20px;" alt="Back"
        src="Images/back.jpg"></a> Back to User Menu
           
        <%
        ArrayList<Object> redoList = (ArrayList<Object>)session.getAttribute("redoInfo");
        if(redoList == null){
            redoList = new ArrayList<Object>();
            for(int i = 0; i < 40; i++){
                redoList.add("");
            }
        }
        %>
        <form method="post" action="figure6SchoolSearchMenu_action.jsp" name="s">
            <table style="text-align: left; width: 900px; height: 385px;"
                   border="1" cellpadding="2" cellspacing="2">
                <tbody>
                    <tr>
                        <td style="vertical-align: top;">School<br></td>
                        <td style="vertical-align: top;"><input type="text" name="school" value="<%=redoList.get(0)%>"><br></td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">State<br>
                        </td>
                        <td style="vertical-align: top;"><select name="state">
                                <option value="<%=redoList.get(1)%>"><%=redoList.get(1)%></option>
                                <option value=""></option>
                                <option value="FOREIGN">Foreign</option>
                                <option value="ALABAMA">Alabama</option>
                                <option value="ALASKA">Alaska</option>
                                <option value="ARIZONA">Arizona</option>
                                <option value="ARKANSAS">Arkansas</option>
                                <option value="CALIFORNIA">California</option>
                                <option value="COLORADO">Colorado</option>
                                <option value="CONNECTICUT">Connecticut</option>
                                <option value="DELAWARE">Delaware</option>
                                <option value="DISTRICT OF COlUMBIA">District of Columbia</option>
                                <option value="FLORIDA">Florida</option>
                                <option value="GEORGIA">Georgia</option>
                                <option value="HAWAII">Hawaii</option>
                                <option value="IDAHO">Idaho</option>
                                <option value="ILLINOIS">Illinois</option>
                                <option value="INDIANA">Indiana</option>
                                <option value="IOWA">Iowa</option>
                                <option value="KANSAS">Kansas</option>
                                <option value="KENTUCKY">Kentucky</option>
                                <option value="LOUISIANA">Louisiana</option>
                                <option value="MAINE">Maine</option>
                                <option value="MARYLAND">Maryland</option>
                                <option value="MASSACHUSETTS">Massachusetts</option>
                                <option value="MICHIGAN">Michigan</option>
                                <option value="MINNESOTA">Minnesota</option>
                                <option value="MISSISSIPPI">Mississippi</option>
                                <option value="MISSOURI">Missouri</option>
                                <option value="MONTANA">Montana</option>
                                <option value="NEBRASKA">Nebraska</option>
                                <option value="NEVADA">Nevada</option>
                                <option value="NEW HAMPSHIRE">New Hampshire</option>
                                <option value="NEW JERSEY">New Jersey</option>
                                <option value="NEW MEXICO">New Mexico</option>
                                <option value="NEW YORK">New York</option>
                                <option value="NORTH CAROLINA">North Carolina</option>
                                <option value="NORTH DAKOTA">North Dakota</option>
                                <option value="OHIO">Ohio</option>
                                <option value="OKLAHOMA">Oklahoma</option>
                                <option value="OREGON">Oregon</option>
                                <option value="PENNSYLVANIA">Pennsylvania</option>
                                <option value="RHODE ISLAND">Rhode Island</option>
                                <option value="SOUTH CAROLINA">South Carolina</option>
                                <option value="SOUTH DAKOTA">South Dakota</option>
                                <option value="TENNESSEE">Tennessee</option>
                                <option value="TEXAS">Texas</option>
                                <option value="UTAH">Utah</option>
                                <option value="VERMONT">Vermont</option>
                                <option value="VIRGINIA">Virginia</option>
                                <option value="WASHINGTON">Washington</option>
                                <option value="WEST VIRGINIA">West Virginia</option>
                                <option value="WISCONSIN">Wisconsin</option>
                                <option value="WYOMING">Wyoming</option>
                            </select><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Location<br>
                        </td>
                        <td style="vertical-align: top;"><select name="location">
                                <option value="<%=redoList.get(2)%>"><%=redoList.get(2)%></option>
                                <option value=""></option>
                                <option value="URBAN">Urban</option>
                                <option value="SUBURBAN">Suburban</option>
                                <option value="SMALL CITY">Small-City</option>
                            </select>
                                <br>
                        </td>
                    <tr>
                        <td style="vertical-align: top;">Control<br>
                        </td>
                        <td style="vertical-align: top;"><select name="control">
                                <option value="<%=redoList.get(3)%>"><%=redoList.get(3)%></option>
                                <option value=""></option>
                                <option value="PRIVATE">Private</option>
                                <option value="STATE">State</option>
                                <option value="CITY">City</option>
                            </select><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Number Of Students<br>
                        </td>
                        <td style="vertical-align: top;">between<input value="<%=redoList.get(4)%>" type="text" name="lowStudents">and<input value="<%=redoList.get(5)%>" type="text" name="highStudents"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Percent Female<br>
                        </td>
                        <td style="vertical-align: top;">between<input value="<%=redoList.get(6)%>" type="text" name="lowpercentFemale">and<input value="<%=redoList.get(7)%>" type="text" name="highpercentFemale"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">SAT Verbal<br>
                        </td>
                        <td style="vertical-align: top;">between<input value="<%=redoList.get(8)%>" type="text" name="lowverbal">and<input value="<%=redoList.get(9)%>" type="text" name="highverbal"><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">SAT Math<br>
                        </td>
                        <td style="vertical-align: top;">between<input value="<%=redoList.get(10)%>" type="text" name="lowmath">and<input value="<%=redoList.get(11)%>" type="text" name="highmath" ><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Expenses<br>
                        </td>
                        <td style="vertical-align: top;">between<input value="<%=redoList.get(12)%>" type="text" name="lowexpenses">and<input value="<%=redoList.get(13)%>" type="text" name="highexpenses" ><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Percent Receiving Financial Aid<br>
                        </td>
                        <td style="vertical-align: top;">between<input value="<%=redoList.get(14)%>" type="text" name="lowfinancialAid" >and<input value="<%=redoList.get(15)%>" type="text" name="highfinancialAid" ><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Number of Applicants<br>
                        </td>
                        <td style="vertical-align: top;">between<input value="<%=redoList.get(16)%>" type="text" name="lownumberApp" >and<input value="<%=redoList.get(17)%>" type="text" name="highnumberApp" ><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Percent Admitted<br>
                        </td>
                        <td style="vertical-align: top;">between<input value="<%=redoList.get(18)%>" type="text" name="lowpercentAdd" >and<input value="<%=redoList.get(19)%>" type="text" name="highpercentAdd" ><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Percent Enrolled<br>
                        </td>
                        <td style="vertical-align: top;">between<input value="<%=redoList.get(20)%>" type="text" name="lowpercentEn" >and<input value="<%=redoList.get(21)%>" type="text" name="highpercentEn" ><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Academic Scale (1-5)<br>
                        </td>
                        <td style="vertical-align: top;">between<input value="<%=redoList.get(22)%>" type="text" name="lowacademicScale" >and<input value="<%=redoList.get(23)%>" type="text" name="highacademicScale" >
                            <br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Social Scale (1-5)<br>
                        </td>
                        <td style="vertical-align: top;">between<input value="<%=redoList.get(24)%>" type="text" name="lowsocialScale" >and<input value="<%=redoList.get(25)%>" type="text" name="highsocialScale" >

                            <br>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Quality of Life Scale (1-5)<br>
                        </td>
                        <td style="vertical-align: top;">between<input value="<%=redoList.get(26)%>" type="text" name="lowqolScale" >and<input value="<%=redoList.get(27)%>" type="text" name="highqolScale" >
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top;">Emphases (up to five)<br>
                        </td>
                        <td style="vertical-align: top;">1.<input value="<%=redoList.get(28)%>" type="text" name="emphase1"><br>
                            2.<input value="<%=redoList.get(29)%>" type="text" name="emphase2"><br>
                            3.<input value="<%=redoList.get(30)%>" type="text" name="emphase3"><br>
                            4.<input value="<%=redoList.get(31)%>" type="text" name="emphase4"><br>
                            5.<input value="<%=redoList.get(32)%>" type="text" name="emphase5">
                        </td>
                    </tr>
                </tbody>
            </table>
            <p><input name="Submit" value="Search" type="submit"> <br>
            </p>
            <br>
        </form>
    </body>

</html>
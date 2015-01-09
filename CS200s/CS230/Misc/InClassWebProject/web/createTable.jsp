<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html><head><title>createTable</title></head><body><br>
        <% String name = request.getParameter("Name");
         int rows = Integer.parseInt(request.getParameter("Rows"));
         int columns = Integer.parseInt(request.getParameter("Columns"));
         if( rows < 1 ){
             out.println("<br> Please insure that the rows are greater than 0.");
                         
         }
                 else if(columns <1){
                     out.println("<br> Please insure that the columns are greater than 0.");
                 }
         else if( name.equals("") || name == null){
             out.println("<br> Please insure that a correct username is entered.");
         }
         out.println("Hello " + name + "! Here is your table.");
                %>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2" cellspacing="2">
    <tbody>
 <% for(int r=0; r <rows;r++){
     out.println("<tr>"); 
     for (int c = 0;c< columns;c ++){
        out.println("<td style=\"vertical-align: top;\">" + r+", " + c + "</td>"); 
     }
     out.println("</tr>");
 }
         %>
<br>


</body></html>
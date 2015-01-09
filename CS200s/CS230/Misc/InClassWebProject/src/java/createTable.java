/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author awzurn
 */
public class createTable extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
out.println("<html>");
out.println("<head>");
out.println("<meta content=\"text/html; charset=ISO-8859-1\"");
out.println("http-equiv=\"content-type\">");
out.println("<title>createtable</title>");
out.println("</head>");
out.println("<body>");
out.println("Hello "+request.getParameter("Name")+". Here is your table<br>");
int rows = Integer.parseInt(request.getParameter("Rows"));
int columns = Integer.parseInt(request.getParameter("Columns"));
out.println("Columns= " + columns);
out.println("<br>Rows= " + rows);
out.println("<table style=\"text-align: left; width: 100%;\" border=\"1\" cellpadding=\"2\"");
out.println("cellspacing=\"2\">");
out.println("<tbody>");
out.println("<tr>");
out.println("<td style=\"vertical-align: top;\"><br>");
out.println("</td>");
out.println("</tr>");
out.println("</tbody>");
out.println("</table>");
out.println("<br>");
out.println("</body>");
out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

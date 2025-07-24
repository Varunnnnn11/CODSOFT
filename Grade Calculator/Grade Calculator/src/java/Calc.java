/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/Calc"})
public class Calc extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
             String sub1 = request.getParameter("sub1");
          String sub2 = request.getParameter("sub2");
           String sub3 = request.getParameter("sub3");
              String sub4 = request.getParameter("sub4");
                 String sub5 = request.getParameter("sub5");

              int no1 =Integer.parseInt(sub1);
                 int no2 =Integer.parseInt(sub2);
                    int no3 =Integer.parseInt(sub3);
                         int no4 =Integer.parseInt(sub4);
                               int no5 =Integer.parseInt(sub5);
                               
                               int total = no1+ no2+ no3+ no4+ no5;
                   double Percent = ((no1+no2+no3+no4+no5)/5.0);
                 
             String grade;
                    
         if (Percent >= 90) grade = "A";
        else if (Percent >= 80) grade = "B";
        else if (Percent >= 70) grade = "C";
        else if (Percent >= 60) grade = "D";
        else grade = "F";
         
           out.println("<html><body>");
        out.println("<h2>Student Grade Report</h2>");
        out.println("<p>Total Marks: " + total + "</p>");
        out.println("<p>Average Percentage: " + String.format("%.2f", Percent) + "%</p>");
        out.println("<p>Grade: " + grade + "</p>");
        out.println("</body></html>");



        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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

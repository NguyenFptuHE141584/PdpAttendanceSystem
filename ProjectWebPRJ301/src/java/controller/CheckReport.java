/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ReportDao;
import entity.TeacherCheckReport;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Foxxy
 */
public class CheckReport extends HttpServlet {

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
        ReportDao rpd = new ReportDao();
        String username = (String) request.getSession().getAttribute("userName");
        List<TeacherCheckReport> listCheckReports = rpd.getListCheckReports(username);
        if (listCheckReports.size() == 0) {
            request.setAttribute("messCheckReport", "Don't have report of student");
        } else {
            request.setAttribute("listCheckReports", listCheckReports);
        }
        request.getRequestDispatcher("TeacherCheckReport.jsp").forward(request, response);

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
        ReportDao rpd = new ReportDao();
        String date = request.getParameter("date");
        String rollNumber = request.getParameter("rollNumber");
        String time = request.getParameter("time");
        if (date != null && rollNumber != null && time != null) {
            try {
                int statusReport = Integer.parseInt(request.getParameter("status"));
                rpd.checkReport(statusReport, date, rollNumber, time);

            } catch (NumberFormatException e) {
                request.getRequestDispatcher("Error").forward(request, response);

            }

        }
        String username = (String) request.getSession().getAttribute("userName");
        List<TeacherCheckReport> listCheckReports = rpd.getListCheckReports(username);
        if (listCheckReports.size() == 0) {
            request.setAttribute("messCheckReport", "Don't have report of student");
        } else {
            request.setAttribute("listCheckReports", listCheckReports);
        }
        request.getRequestDispatcher("TeacherCheckReport.jsp").forward(request, response);
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

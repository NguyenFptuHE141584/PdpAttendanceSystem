/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ReportDao;
import entity.Report;
import entity.Student;
import entity.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Foxxy
 */
public class StudentReport extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentReport</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentReport at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        ReportDao rd = new ReportDao();
        //
        String username = (String) request.getSession().getAttribute("userName");
        List<Teacher> listTeacher = rd.getTeacherByUserName(username);
        request.setAttribute("listTeacher", listTeacher);
        //
        List<Report> listReports = rd.getListReports(username);
        if (listReports.size() == 0) {
            request.setAttribute("mess2", "Don't have report");
        } else {
            request.setAttribute("listReports", listReports);
        }
        //
        request.getRequestDispatcher("StudentReport.jsp").forward(request, response);
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
        ReportDao rd = new ReportDao();
        String username = (String) request.getSession().getAttribute("userName");
        request.setCharacterEncoding("UTF-8");
        Student st = rd.getRollNumber(username);
        String reportID = request.getParameter("selectTeacher");
        String content = request.getParameter("contentReport");
        if (reportID != null && content != null) {
            int reportId = Integer.parseInt(reportID);
            Date d = new Date();
            d.getTime();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
            if (reportId == 0) {
                request.setAttribute("mess1", "Please select Teacher");
            }
            if (rd.reportTeacher(reportId, st.getRollNumber(), username, content, 2, sdf1.format(d),sdf2.format(d)) > 0) {
                request.setAttribute("mess", "Send report successfull");
            }
        }
        List<Teacher> listTeacher = rd.getTeacherByUserName(username);
        request.setAttribute("listTeacher", listTeacher);
        List<Report> listReports = rd.getListReports(username);
        request.setAttribute("listReports", listReports);
        request.getRequestDispatcher("StudentReport.jsp").forward(request, response);
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

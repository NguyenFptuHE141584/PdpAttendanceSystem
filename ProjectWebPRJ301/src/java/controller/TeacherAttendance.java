/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TeacherDao;
import entity.Attendance;
import entity.TeacherSubject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Foxxy
 */
public class TeacherAttendance extends HttpServlet {

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
        TeacherDao td = new TeacherDao();
        HttpSession session = request.getSession();
        String userName = (String) request.getSession().getAttribute("userName");
        List<TeacherSubject> listTeacherSubject = td.getTeacherSubject(userName);
        if (listTeacherSubject.size() == 0) {
            request.setAttribute("mess", "Today don't have subject need attendance");
        } else {
            request.setAttribute("listTeacherSubject", listTeacherSubject);
        }
        String subjectCode = request.getParameter("subjectCode");
        String className = request.getParameter("className");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        if (subjectCode != null && className != null && startTime != null && endTime != null) {
            List<Attendance> list = td.checkAttendance(subjectCode, className, startTime, endTime, userName);
            if (list.size() != 0) {
                request.setAttribute("list", list);
                session.setAttribute("list", list);
            } else {
                request.getRequestDispatcher("Error").forward(request, response);
            }
        }

        session.setAttribute("subjectCode", subjectCode);
        session.setAttribute("startTime", startTime);
        session.setAttribute("endTime", endTime);
        session.setAttribute("className", className);
        request.getRequestDispatcher("TeacherAttendance.jsp").forward(request, response);
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
        TeacherDao td = new TeacherDao();
        List<Attendance> listStudentByClass = (List<Attendance>) request.getSession().getAttribute("list");
        String userNameTeacher = (String) request.getSession().getAttribute("userName");
        String subjectCode = (String) request.getSession().getAttribute("subjectCode");
        String startTime = (String) request.getSession().getAttribute("startTime");
        String endTime = (String) request.getSession().getAttribute("endTime");
        for (int i = 0; i < listStudentByClass.size(); i++) {
            String attendance = request.getParameter("attendance" + listStudentByClass.get(i).getRollNumber());
            String note = request.getParameter("note" + listStudentByClass.get(i).getRollNumber());
            int aID = Integer.parseInt(attendance);
            listStudentByClass.get(i).setNote(note);
            if (td.saveAttendance(aID, note, userNameTeacher, listStudentByClass.get(i).getRollNumber(), subjectCode, startTime, endTime) > 0);
            request.setAttribute("mess2", "Attendance Success");
        }
        String className = (String) request.getSession().getAttribute("className");
        List<TeacherSubject> listTeacherSubject = td.getTeacherSubject(userNameTeacher);
        request.setAttribute("listTeacherSubject", listTeacherSubject);
        List<Attendance> list = td.checkAttendance(subjectCode, className, startTime, endTime, userNameTeacher);
        request.setAttribute("list", list);
        request.getRequestDispatcher("TeacherAttendance.jsp").forward(request, response);
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

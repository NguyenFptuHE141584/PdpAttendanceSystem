/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StudentDao;
import entity.DetailAttendanceStudent;
import entity.StudentSubject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Foxxy
 */
public class ViewAttendanceStudent extends HttpServlet {

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
        StudentDao studentDao = new StudentDao();
        String username = (String) request.getSession().getAttribute("userName");
        List<StudentSubject> liststStudentSubjects = studentDao.getStudentSubject(username);
        request.setAttribute("liststStudentSubjects", liststStudentSubjects);
        //
        List<DetailAttendanceStudent> listDetailAttendanceStudents = new ArrayList<>();
        String subjectCodeS = request.getParameter("subjectCode");
        request.setAttribute("subjectCodeS", subjectCodeS);
        String classNameS = request.getParameter("className");
        request.setAttribute("classNameS", classNameS);
        //
        if (subjectCodeS != null && classNameS != null) {
            List<DetailAttendanceStudent> list = studentDao.getDetailAttandanceStudent(username, subjectCodeS, classNameS);
            if (list.size() != 0) {
                int count = 1;
                for (DetailAttendanceStudent o : list) {
                    o.setId(count++);
                    listDetailAttendanceStudents.add(new DetailAttendanceStudent(o.getId(), o.getDate(), o.getSlotId(), o.getUserNameTeacher(), o.getClassName(), o.getStatusAttend(), o.getNoteAttand()));
                }
                request.setAttribute("listDetailAttendanceStudents", listDetailAttendanceStudents);
            } else {
                request.getRequestDispatcher("Error").forward(request, response);
            }
            int totalSessionOfSubject = studentDao.getTotalSessionOfSubject(username, subjectCodeS, classNameS);
            request.setAttribute("totalSessionOfSubject", totalSessionOfSubject);
            int totalAbsentSessionOfSubject = studentDao.getTotalAbsentSessionOfSubject(username, subjectCodeS, classNameS);
            request.setAttribute("totalAbsentSessionOfSubject", totalAbsentSessionOfSubject);
            int percent = (totalAbsentSessionOfSubject * 100) / totalSessionOfSubject;
            request.setAttribute("percent", percent);
        }
        request.getRequestDispatcher("ViewAttendanceStudent.jsp").forward(request, response);
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

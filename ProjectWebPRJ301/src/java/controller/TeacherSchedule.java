/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ScheduleDao;
import dao.TeacherDao;
import dao.listDate;
import entity.ScheduleDate;
import entity.ScheduleDetailTeacher;
import entity.Slot;
import entity.Teacher;
import entity.WeekOfSchedule;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
public class TeacherSchedule extends HttpServlet {

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
        TeacherDao td = new TeacherDao();
        ScheduleDao sd = new ScheduleDao();
        //get active teacher
        String user = (String) request.getSession().getAttribute("userName");
        Teacher teacherActive = td.getTeacherActive(user);
        request.setAttribute("teacherActive", teacherActive);
        //get date dropdownlist 
        List<WeekOfSchedule> listWeekOfSchedules = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<WeekOfSchedule> list = listDate.list("20210510", "20210516", "20210725");
        int count = 1;
        for (WeekOfSchedule o : list) {
            o.setId(count++);
            listWeekOfSchedules.add(new WeekOfSchedule(o.getId(), o.getStartDate(), o.getEndDate()));
        }
        request.setAttribute("listWeekOfSchedules", listWeekOfSchedules);
        //get list date by id 
        String selectedDate = request.getParameter("selectedDateTeacher");
        if (selectedDate == null) {
            selectedDate = "1";
        }
        int selectedDatePage = Integer.parseInt(selectedDate);
        List<ScheduleDate> listPage = sd.pagingScheduleDates(selectedDatePage);
        request.setAttribute("pagingScheduleDates", listPage);
        
        //
        List<ScheduleDetailTeacher> scheduleDetailsTeacher = new ArrayList<>();
        for (ScheduleDate o : listPage) {
            List<ScheduleDetailTeacher> listScheduleDetails = sd.getScheduleDetailsTeacher(user, o.getDate());
            for (ScheduleDetailTeacher p : listScheduleDetails) {
                scheduleDetailsTeacher.add(p);
            }
        }
        request.setAttribute("scheduleDetailsTeacher", scheduleDetailsTeacher);
        
        List <Slot> listSlot = sd.getListSlot();
        request.setAttribute("listSlot", listSlot);
        request.getRequestDispatcher("TeacherSchedule.jsp").forward(request, response);
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

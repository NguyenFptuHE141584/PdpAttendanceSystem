/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Foxxy
 */
public class Attendance {
    private String rollNumber ; 
    private String studentName ;
    private int statusAttendance ;
    private String note; 

    public Attendance() {
    }

    public Attendance(String rollNumber, String studentName, int statusAttendance, String note) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
     
        this.statusAttendance = statusAttendance;
        this.note = note;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

   

    public int getStatusAttendance() {
        return statusAttendance;
    }

    public void setStatusAttendance(int statusAttendance) {
        this.statusAttendance = statusAttendance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Attendance{" + "rollNumber=" + rollNumber + ", studentName=" + studentName + ", statusAttendance=" + statusAttendance + ", note=" + note + '}';
    }
  
} 

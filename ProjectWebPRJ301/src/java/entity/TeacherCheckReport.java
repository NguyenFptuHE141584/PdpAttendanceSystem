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
public class TeacherCheckReport {
    private Date date ;
    private Date time ;
    private String rollNumber;
    private String reportStudent;
    private String contentReport ;
    private int statusl;

    public TeacherCheckReport() {
    }

    public TeacherCheckReport(Date date, Date time, String rollNumber, String reportStudent, String contentReport, int statusl) {
        this.date = date;
        this.time = time;
        this.rollNumber = rollNumber;
        this.reportStudent = reportStudent;
        this.contentReport = contentReport;
        this.statusl = statusl;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getReportStudent() {
        return reportStudent;
    }

    public void setReportStudent(String reportStudent) {
        this.reportStudent = reportStudent;
    }

    public String getContentReport() {
        return contentReport;
    }

    public void setContentReport(String contentReport) {
        this.contentReport = contentReport;
    }

    public int getStatusl() {
        return statusl;
    }

    public void setStatusl(int statusl) {
        this.statusl = statusl;
    }

    @Override
    public String toString() {
        return "TeacherCheckReport{" + "date=" + date + ", time=" + time + ", rollNumber=" + rollNumber + ", reportStudent=" + reportStudent + ", contentReport=" + contentReport + ", statusl=" + statusl + '}';
    }

     
}

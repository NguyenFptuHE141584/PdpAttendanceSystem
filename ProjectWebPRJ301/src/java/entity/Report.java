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
public class Report {
    private Date date ;
    private Date time ;
    private String nameTeacher ;
    private String contentReport ;
    private int status ;

    public Report() {
    }

    public Report(Date date, Date time, String nameTeacher, String contentReport, int status) {
        this.date = date;
        this.time = time;
        this.nameTeacher = nameTeacher;
        this.contentReport = contentReport;
        this.status = status;
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

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getContentReport() {
        return contentReport;
    }

    public void setContentReport(String contentReport) {
        this.contentReport = contentReport;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Report{" + "date=" + date + ", time=" + time + ", nameTeacher=" + nameTeacher + ", contentReport=" + contentReport + ", status=" + status + '}';
    }

   
    
}

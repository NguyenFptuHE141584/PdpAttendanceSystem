/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Foxxy
 */
public class TeacherSubject {
    private String subjectCode ;
    private String subjectName ;
    private String className;
    private Time startTime ;
    private Time endTime ;
    private Date date ;

    public TeacherSubject() {
    }

    public TeacherSubject(String subjectCode, String subjectName, String className, Time startTime, Time endTime, Date date) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.className = className;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   
    @Override
    public String toString() {
        return "TeacherSubject{" + "subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", className=" + className + ", startTime=" + startTime + ", endTime=" + endTime + ", date=" + date + '}';
    }
    
  
}

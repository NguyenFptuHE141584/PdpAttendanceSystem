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
public class ScheduleDetailTeacher {
    private String subjectCode ;
    private String className ;
    private Date startTime ;
    private Date endTime;
    private Date date ;
    private String slotName;

    public ScheduleDetailTeacher() {
    }

    public ScheduleDetailTeacher(String subjectCode, String className, Date startTime, Date endTime, Date date, String slotName) {
        this.subjectCode = subjectCode;
        this.className = className;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.slotName = slotName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    @Override
    public String toString() {
        return "ScheduleDetail{" + "subjectCode=" + subjectCode + ", className=" + className + ", startTime=" + startTime + ", endTime=" + endTime + ", date=" + date + ", slotName=" + slotName + '}';
    }
    
   
    
}

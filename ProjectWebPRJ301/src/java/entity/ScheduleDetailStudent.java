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
public class ScheduleDetailStudent {
    private String subjectCode ;
    private String className;
    private int statusAttend ;
    private Date startTime ;
    private Date endTime;
    private Date date ;
    private String slotName;

    public ScheduleDetailStudent() {
    }

    public ScheduleDetailStudent(String subjectCode, String className, int statusAttend, Date startTime, Date endTime, Date date, String slotName) {
        this.subjectCode = subjectCode;
        this.className = className;
        this.statusAttend = statusAttend;
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

    public int getStatusAttend() {
        return statusAttend;
    }

    public void setStatusAttend(int statusAttend) {
        this.statusAttend = statusAttend;
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
        return "subjectCode=" + subjectCode + ", className=" + className + ", statusAttend=" + statusAttend + ", startTime=" + startTime + ", endTime=" + endTime + ", date=" + date + ", slotName=" + slotName + '}';
    }

    
}

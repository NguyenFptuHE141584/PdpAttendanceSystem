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
public class DetailAttendanceStudent {
    private int id ;
    private Date date ;
    private int slotId;
    private String userNameTeacher ;
    private String className;
    private int statusAttend;
    private String noteAttand;

    public DetailAttendanceStudent() {
    }

    public DetailAttendanceStudent(int id, Date date, int slotId, String userNameTeacher, String className, int statusAttend, String noteAttand) {
        this.id = id;
        this.date = date;
        this.slotId = slotId;
        this.userNameTeacher = userNameTeacher;
        this.className = className;
        this.statusAttend = statusAttend;
        this.noteAttand = noteAttand;
    }
    

    public DetailAttendanceStudent(Date date, int slotId, String userNameTeacher, String className, int statusAttend, String noteAttand) {
        this.date = date;
        this.slotId = slotId;
        this.userNameTeacher = userNameTeacher;
        this.className = className;
        this.statusAttend = statusAttend;
        this.noteAttand = noteAttand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getUserNameTeacher() {
        return userNameTeacher;
    }

    public void setUserNameTeacher(String userNameTeacher) {
        this.userNameTeacher = userNameTeacher;
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

    public String getNoteAttand() {
        return noteAttand;
    }

    public void setNoteAttand(String noteAttand) {
        this.noteAttand = noteAttand;
    }

    @Override
    public String toString() {
        return "DetailAttendanceStudent{" + "id=" + id + ", date=" + date + ", slotId=" + slotId + ", userNameTeacher=" + userNameTeacher + ", className=" + className + ", statusAttend=" + statusAttend + ", noteAttand=" + noteAttand + '}';
    }
    
    
}

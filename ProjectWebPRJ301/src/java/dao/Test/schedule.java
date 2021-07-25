/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Test;

/**
 *
 * @author Foxxy
 */
public class schedule {
    private String subjectCode;
    private int dateID;
    private int slotID;
    private int teacherID;

    public schedule() {
    }

    public schedule(String subjectCode, int dateID, int slotID, int teacherID) {
        this.subjectCode = subjectCode;
        this.dateID = dateID;
        this.slotID = slotID;
        this.teacherID = teacherID;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getDateID() {
        return dateID;
    }

    public void setDateID(int dateID) {
        this.dateID = dateID;
    }

    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        return "schedule{" + "subjectCode=" + subjectCode + ", dateID=" + dateID + ", slotID=" + slotID + ", teacherID=" + teacherID + '}';
    }
    
}

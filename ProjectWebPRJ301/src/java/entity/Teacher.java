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
public class Teacher {

    private int teacherID;
    private String userName;
    private String teacherName;
    private String address;
    private String image;
    private Date dob;

    public Teacher() {
    }

    public Teacher(int teacherID, String userName, String teacherName) {
        this.teacherID = teacherID;
        this.userName = userName;
        this.teacherName = teacherName;
    }

    public Teacher(String userName, String teacherName) {
        this.userName = userName;
        this.teacherName = teacherName;
    }

    public Teacher(int teacherID, String userName, String teacherName, String address, String image, Date dob) {
        this.teacherID = teacherID;
        this.userName = userName;
        this.teacherName = teacherName;
        this.address = address;
        this.image = image;
        this.dob = dob;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teacherID=" + teacherID + ", userName=" + userName + ", teacherName=" + teacherName + ", address=" + address + ", image=" + image + ", dob=" + dob + '}';
    }

}

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
public class Student {
    private String userName;
    private String rollNumber;
    private String studentName;
    private String address ;
    private Date dob ;
    private String img;

    public Student() {
    }

    public Student(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    public Student(String userName, String studentName) {
        this.userName = userName;
        this.studentName = studentName;
    }
    
    public Student(String userName, String rollNumber, String studentName, String address, Date dob, String img) {
        this.userName = userName;
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.address = address;
        this.dob = dob;
        this.img = img;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Student{" + "userName=" + userName + ", rollNumber=" + rollNumber + ", studentName=" + studentName + ", address=" + address + ", dob=" + dob + ", img=" + img + '}';
    }
    
}

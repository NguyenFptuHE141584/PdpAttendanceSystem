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
public class StudentSubject {
    private String subjectCode ;
    private String subjectName;
    private String className ;
    private Date date ;

    public StudentSubject() {
    }

    public StudentSubject(String subjectCode, String subjectName, String className, Date date) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.className = className;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StudentSubject{" + "subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", className=" + className + ", date=" + date + '}';
    }

    
}

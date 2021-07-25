/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.DetailAttendanceStudent;
import entity.Student;
import entity.StudentSubject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Foxxy
 */
public class StudentDao {

    Connection conn = null;// connect with sql sever
    PreparedStatement ps = null;//throw command from netbean to sql sever
    ResultSet rs = null;// get returned results

    public Student getStudentDetail(String userName) {
        String querry = "select * from StudentInfor where username=?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Student getStudentActive(String user) {
        String querry = "select a.username , a.studentName from StudentInfor a\n"
                + "inner join Account b on a.username = b.username\n"
                + "where b.username =  ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Student(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<StudentSubject> getStudentSubject(String user) {
        List<StudentSubject> list = new ArrayList<>();
        String querry = "select distinct TOP 5 a.subjectCode,d.subjectName,b.className,e.date from Schedule a \n"
                + "inner join Class  b on b.classID =  a.classID\n"
                + "inner join ClassMember c on c.classID = b.classID\n"
                + "inner join [Subject] d on d.subjectCode = a.subjectCode\n"
                + "inner join ScheduleDay e on e.dateID =  a.dateID\n"
                + "inner join StudentInfor g on g.rollNumber = c.rollNumber\n"
                + "where g.username = ? \n";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new StudentSubject(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<DetailAttendanceStudent> getDetailAttandanceStudent(String usernameStudent, String subjectCode, String className) {
        List<DetailAttendanceStudent> list = new ArrayList<>();
        String querry = "select c.[date],b.slotID,e.username,d.className,a.statusAttend,a.noteAttend  from Attendance a \n"
                + "inner join Schedule b on a.id = b.ScheduleID \n"
                + "inner join ScheduleDay c on c.dateID= b.dateID\n"
                + "inner join Class d on d.classID = b.classID\n"
                + "inner join TeacherInfor e on e.teacherID = b.teacherID\n"
                + "inner join ClassMember g on g.rollNumber = a.rollNumber\n"
                + "inner join StudentInfor f on f.rollNumber = g.rollNumber\n"
                + "where f.username = ? and b.subjectCode = ? and d.className= ? \n"
                + "order by c.[date] ASC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, usernameStudent);
            ps.setString(2, subjectCode);
            ps.setString(3, className);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DetailAttendanceStudent(rs.getDate(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public int getTotalSessionOfSubject(String usernameStudent, String subjectCode, String className) {
        String querry = "select count(*)  from Attendance a \n"
                + "inner join Schedule b on a.id = b.ScheduleID \n"
                + "inner join Class d on d.classID = b.classID\n"
                + "inner join ClassMember g on g.rollNumber = a.rollNumber\n"
                + "inner join StudentInfor f on f.rollNumber = g.rollNumber\n"
                + "where f.username = ? and b.subjectCode = ? and d.className=? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, usernameStudent);
            ps.setString(2, subjectCode);
            ps.setString(3, className);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public int getTotalAbsentSessionOfSubject(String usernameStudent, String subjectCode, String className) {
        String querry = "select count(*) from Attendance a \n"
                + "inner join Schedule b on a.id = b.ScheduleID \n"
                + "inner join Class d on d.classID = b.classID\n"
                + "inner join ClassMember g on g.rollNumber = a.rollNumber\n"
                + "inner join StudentInfor f on f.rollNumber = g.rollNumber\n"
                + "where f.username = ? and b.subjectCode = ? and d.className= ? "
                + " and a.statusAttend=0";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, usernameStudent);
            ps.setString(2, subjectCode);
            ps.setString(3, className);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public static void main(String[] args) {
        StudentDao d = new StudentDao();
        int total1 = d.getTotalAbsentSessionOfSubject("nguyennhhe141584", "PRN292", "SE1439");
        int total2 = d.getTotalSessionOfSubject("nguyennhhe141584", "PRN292", "SE1439");
        int percent = (total1*100)/total2;
        System.out.println(percent);
    }

}

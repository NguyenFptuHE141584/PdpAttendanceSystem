/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.TeacherCheckReport;
import entity.Report;
import entity.Student;
import entity.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Foxxy
 */
public class ReportDao {

    Connection conn = null;// connect with sql sever
    PreparedStatement ps = null;//throw command from netbean to sql sever
    ResultSet rs = null;// get returned results

    public List<Teacher> getTeacherByUserName(String usernameStudent) {
        List<Teacher> list = new ArrayList<>();
        String querry = "select distinct a.teacherID,b.username,b.teacherName from Schedule a \n"
                + "inner join TeacherInfor b on b.teacherID = a.teacherID\n"
                + "inner join Class c on c.classID = a.classID\n"
                + "inner join ClassMember d on d.classID =  c.classID\n"
                + "inner join StudentInfor e on e.rollNumber = d.rollNumber \n"
                + "where e.username = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, usernameStudent);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Student getRollNumber(String usernameStudent) {
        List<Teacher> list = new ArrayList<>();
        String querry = "select rollNumber from StudentInfor where username = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, usernameStudent);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Student(rs.getString(1));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Report> getListReports(String usernameStudent) {
        List<Report> list = new ArrayList<>();
        String querry = "select [dateTime],[time],b.username,a.contentReport,a.statsus  from Report a\n"
                + "inner join TeacherInfor b on b.teacherID = a.reportID\n"
                + "where a.username= ? order by a.[time] DESC , a.[datetime] ASC";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, usernameStudent);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Report(rs.getDate(1), rs.getTime(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<TeacherCheckReport> getListCheckReports(String usernameTeacher) {
        List<TeacherCheckReport> list = new ArrayList<>();
        String querry = "select a.[dateTime],a.[time],a.rollNumber,a.username,a.contentReport,a.statsus from Report a\n"
                + "inner join TeacherInfor b on b.teacherID = a.reportID\n"
                + "where b.username = ? order by a.[time] DESC , a.[datetime] ASC ";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, usernameTeacher);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TeacherCheckReport(rs.getDate(1), rs.getTime(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public int reportTeacher(int teacherID, String rollNumber, String username, String content, int status, String date, String time) {
        String querry = "INSERT INTO Report (reportID, rollNumber, username,contentReport,statsus,[dateTime],[time])\n"
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, teacherID);
            ps.setString(2, rollNumber);
            ps.setString(3, username);
            ps.setString(4, content);
            ps.setInt(5, status);
            ps.setString(6, date);
            ps.setString(7, time);
            if (ps.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public int checkReport(int status, String dateime, String rollNumber, String time) {
        String querry = "UPDATE Report \n"
                + "SET statsus = ? \n"
                + "WHERE dateTime =  ? \n"
                + "and rollNumber = ? and [time] = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, status);
            ps.setString(2, dateime);
            ps.setString(3, rollNumber);
            ps.setString(4, time);

            if (ps.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public static void main(String[] args) {
        ReportDao rp = new ReportDao();
        List<TeacherCheckReport> list = rp.getListCheckReports("linhnt2601");
        for (TeacherCheckReport o : list) {
            System.out.println(o);
        }

    }
}

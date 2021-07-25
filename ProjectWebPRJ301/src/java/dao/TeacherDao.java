/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Attendance;
import entity.ScheduleDate;
import entity.Teacher;
import entity.TeacherSubject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Foxxy
 */
public class TeacherDao {

    Connection conn = null;// connect with sql sever
    PreparedStatement ps = null;//throw command from netbean to sql sever
    ResultSet rs = null;// get returned results

    public Teacher getTeacherDetail(String user) {
        String querry = "select * from TeacherInfor where [username] = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<TeacherSubject> getTeacherSubject(String user) {
        List<TeacherSubject> list = new ArrayList<>();
        String querry = "select distinct f.subjectCode,f.subjectName,b.className,d.startTime,d.endTime,e.date from Schedule a \n"
                + "inner join Class b on a.classID = b.classID\n"
                + "inner join TeacherInfor c on a.teacherID =c.teacherID \n"
                + "inner join Slot d on a.slotID = d.slotID\n"
                + "inner join ScheduleDay e on a.dateID =e.dateID\n"
                + "inner join [Subject] f on a.subjectCode =f.subjectCode\n"
                + "where e.[date] = DATEADD(DAY, DATEDIFF(DAY, 0, GETDATE()), 0) and c.username=?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {

                list.add(new TeacherSubject(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTime(4), rs.getTime(5), rs.getDate(6)));
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        return list;
    }

    public List<Attendance> checkAttendance(String subjectCode, String className, String startTime, String endTime, String teacherName) {
        List<Attendance> list = new ArrayList<>();
        String querry = "select b.rollNumber,c.studentName,b.statusAttend,b.noteAttend from Schedule a\n"
                + "inner join Attendance b on b.id = a.ScheduleID \n"
                + "inner join StudentInfor c on c.rollNumber =b.rollNumber\n"
                + "inner join ScheduleDay d on d.dateID = a.dateID\n"
                + "inner join Class e on e.classID = a.classID\n"
                + "inner join Slot f on f.slotID = a.slotID\n"
                + "inner join TeacherInfor g on g.teacherID =a.teacherID\n"
                + "where d.[date] =DATEADD(DAY, DATEDIFF(DAY, 0, GETDATE()), 0) and a.subjectCode = ? \n"
                + "and e.className = ? \n"
                + "and f.startTime = ? and f.endTime = ? \n"
                + "and g.username = ?  "
                + "ORDER BY rollNumber ASC";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, subjectCode);
            ps.setString(2, className);
            ps.setString(3, startTime);
            ps.setString(4, endTime);
            ps.setString(5, teacherName);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attendance(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public int saveAttendance(int statusAttend, String noteAttend, String username, String rollNumber, String subjectCode, String startTime, String endTime) {
        String querry = "UPDATE Attendance SET  statusAttend = ? , noteAttend = ? from Schedule a\n"
                + "inner join Attendance b on b.id =  a.ScheduleID \n"
                + "inner join ScheduleDay c on c.dateID = a.dateID \n"
                + "inner join TeacherInfor d on d.teacherID = a.teacherID \n"
                + "inner join Slot f on f.slotID = a.slotID \n"
                + "where c.[date] = DATEADD(DAY, DATEDIFF(DAY, 0, GETDATE()), 0) and a.subjectCode = ? \n"
                + "and b.rollNumber = ? \n"
                + "and d.username= ? and \n"
                + "f.startTime= ? and f.endTime = ? ";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, statusAttend);
            ps.setString(2, noteAttend);
            ps.setString(3, subjectCode);
            ps.setString(4, rollNumber);
            ps.setString(5, username);
            ps.setString(6, startTime);
            ps.setString(7, endTime);
            if (ps.executeUpdate() > 0) {
                return 1;
            }

        } catch (Exception e) {

        }
        return 0;
    }

    public Teacher getTeacherActive(String user) {
        String querry = "select a.username , a.teacherName from TeacherInfor a\n"
                + "inner join Account b on a.username = b.username\n"
                + "where b.username =  ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Teacher(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public static void main(String[] args) {
        TeacherDao td = new TeacherDao();
        td.saveAttendance(1, "good", "B", "HE141584", "PRJ301", "7:30", "9:00");
    }

}

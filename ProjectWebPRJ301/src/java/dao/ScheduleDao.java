/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ScheduleDate;
import entity.ScheduleDetailStudent;
import entity.ScheduleDetailTeacher;
import entity.Slot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Foxxy
 */
public class ScheduleDao {

    Connection conn = null;// connect with sql sever
    PreparedStatement ps = null;//throw command from netbean to sql sever
    ResultSet rs = null;// get returned results

    public List<ScheduleDetailTeacher> getScheduleDetailsTeacher(String userName, Date date) {
        List<ScheduleDetailTeacher> list = new ArrayList<>();
        String querry = "select a.subjectCode,b.className,c.startTime,c.endTime,e.[date],c.slotName from Schedule a\n"
                + "inner join Class b on a.classID = b.classID\n"
                + "inner join Slot c on c.slotID =  a.slotID\n"
                + "inner join TeacherInfor d on d.teacherID = a.teacherID\n"
                + "inner join ScheduleDay e on e.dateID = a.dateID\n"
                + "where d.username =? and e.[date] = ? ";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, userName);
            ps.setDate(2, (java.sql.Date) date);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ScheduleDetailTeacher(rs.getString(1), rs.getString(2), rs.getTime(3), rs.getTime(4), rs.getDate(5), rs.getString(6)));
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        return list;
    }

    public List<ScheduleDetailStudent> getScheduleDetailsStudent(String userName, Date date) {
        List<ScheduleDetailStudent> list = new ArrayList<>();
        String querry = "select b.subjectCode,f.className,a.statusAttend,g.startTime,g.endTime,c.[date],g.slotName"
                + " from Attendance a \n"
                + "inner join Schedule b on a.id = b.ScheduleID\n"
                + "inner join ScheduleDay c on c.dateID = b.dateID \n"
                + "inner join ClassMember d on d.rollNumber = a.rollNumber\n"
                + "inner join StudentInfor e on e.rollNumber = d.rollNumber\n"
                + "inner join Class f on f .classID =d.classID\n"
                + "inner join Slot g on g.slotID = b.slotID\n"
                + "where   e.username =? and c.[date] = ? ";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, userName);
            ps.setDate(2, (java.sql.Date) date);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ScheduleDetailStudent(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getTime(4), rs.getTime(5), rs.getDate(6), rs.getString(7)));
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        return list;
    }

    public int countDate() {
        String querry = "select count(*) from ScheduleDay";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public List<ScheduleDate> pagingScheduleDates(int index) {
        List<ScheduleDate> list = new ArrayList<>();
        String querry = "select [date] from ScheduleDay \n"
                + "order by dateID OFFSET ? rows fetch next 7 rows only";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, (index - 1) * 7);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ScheduleDate(rs.getDate(1)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Slot> getListSlot() {
        List<Slot> list = new ArrayList<>();
        String querry = "select * from Slot";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Slot(rs.getInt(1), rs.getString(2), rs.getTime(3), rs.getTime(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        ScheduleDao sd = new ScheduleDao();
        List<ScheduleDate> list1 = sd.pagingScheduleDates(10);
        for (ScheduleDate o1 : list1) {
            List<ScheduleDetailStudent> list2 = sd.getScheduleDetailsStudent("nguyennhhe141584", o1.getDate());
            for (ScheduleDetailStudent o2 : list2) {
                System.out.println(o2);
            }
        }

    }
}

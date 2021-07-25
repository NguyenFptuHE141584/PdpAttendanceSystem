/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Test;

import dao.DBContext;
import entity.Attendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Foxxy
 */
public class insert {

    Connection conn = null;// connect with sql sever
    PreparedStatement ps = null;//throw command from netbean to sql sever
    ResultSet rs = null;// get returned results

    public void insert(String date) {
        List<Attendance> list = new ArrayList<>();
        String querry = "insert into ScheduleDay([date]) values (?)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, date);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<schedule> getall() {
        List<schedule> list = new ArrayList<>();
        String querry = "select subjectCode,dateID,slotID,teacherID from Schedule ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new schedule(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insert1(int id, int status) {
        String querry = "insert into Attendance values (?,?,'HE141586',NULL)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, id);
            ps.setInt(2, status);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insert2(int id) {
        String querry = "insert into Attendance values (?,2,'HE141586',NULL)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        insert is = new insert();
        List<schedule> list = is.getall();
        for (int i = 1; i <= 177; i++) {
            if (i < 153) {
                is.insert1(i, 1);
            }
            if (i >= 153) {
                is.insert2(i);
            }

        }
    }
}

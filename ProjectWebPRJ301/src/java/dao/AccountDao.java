/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Foxxy
 */
public class AccountDao {
    
    Connection conn = null;// connect with sql sever
    PreparedStatement ps = null;//throw command from netbean to sql sever
    ResultSet rs = null;// get returned results

     public Account login(String user, String pass) {
        String querry = "select * from Account where [username] = ? and [password] = ? ";
        
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2),rs.getInt(3));
            }
        } catch (Exception e) {

        }
        return null;
    }
     public static void main(String[] args) {
        AccountDao d = new AccountDao();
         System.out.println(d.login("nguyennhhe141584", "nguyen158"));
    }

}

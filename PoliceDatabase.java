package com.project.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PoliceDatabase {
    public static void PoliceInfo(String Pname, String batch, String workstation,String Rank, String number) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement ps = con.prepareStatement("Insert into police(PoliceName,Batch,WorkStation,Rank,Number) Values (?,?,?,?,?)");
            ps.setString(1, Pname);
            ps.setString(2, batch);
            ps.setString(3, workstation);
            ps.setString(4, Rank);     
            ps.setString(5, number);     
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EditDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

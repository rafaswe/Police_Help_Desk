
package com.project.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReistrationDatabase {
        public static void reg(String fname, String uname, String phone, String email, String password) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement ps = con.prepareStatement("Insert into userinfo(FullName,UserName,Phone,Email,Password) Values (?,?,?,?,?)");
            ps.setString(1, fname);
            ps.setString(2, uname);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EditDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

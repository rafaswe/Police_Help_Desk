
package com.project.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInDatabase {
    public static String name;


    public static boolean login(String username, String password) {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement st = con.prepareStatement("Select UserName,Password from userinfo where UserName=? and Password=?");
            st.setString(1, username);
            st.setString(2, password);
            ResultSet a = st.executeQuery();
            if (a.next()) {
                name = username;
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}

package com.project.Database;

//import PoliceHelpDesk.Demo;
import com.project.UI.Menu;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditDatabase {

    public static void edit(String fname,String phone,String email,String pass){
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement st=con.createStatement();
            String sql="'"+LogInDatabase.name+"'";
            ResultSet r=st.executeQuery("Select * from userinfo where UserName = "+sql);
            if(r.next()){
                PreparedStatement ps=con.prepareStatement("Update userinfo set FullName= ? ,Phone=?, Email=?, Password = ? where UserName = ?");
                
                if(!fname.isEmpty())
                {
                    ps.setString(1,fname);
                }
                else
                {
                    ps.setString(1,r.getString(2));
                }
                
                
                if(!phone.isEmpty())
                {
                    ps.setString(2,phone);
                }
                else
                {
                    ps.setString(2,r.getString(4));
                }
                
                
                if(!email.isEmpty())
                {
                    ps.setString(3,email);
                }
                else
                {
                    ps.setString(3,r.getString(5));
                }
                
                
                if(!pass.isEmpty())
                {
                    ps.setString(4,pass);
                }
                else
                {
                    ps.setString(4,r.getString(6));
                }
                ps.setString(5,LogInDatabase.name);
                ps.executeUpdate();
                               
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
public static void setPreviousValue()
{
    Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement st=con.createStatement();
            String sql="'"+LogInDatabase.name+"'";
            ResultSet r=st.executeQuery("Select * from userinfo where UserName = "+sql);
            if(r.next()){
              Menu.view(r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6));                     
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
}


// public static void Victim(String Vname, int vage,String mobile,String NID,String Nationality, String Vaddress,String CrimeType,String CrimePlace,String CrimeTime,String CrimeDetails) {
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
//            PreparedStatement ps = con.prepareStatement("Insert into userinfo(VictimName,VictimAge,Mobile,NID,Nationality,VictimAdress,CrimeName,Location,CrimeTime,CrimeDetails) Values (?,?,?,?,?,?,?,?,?,?)");
//            ps.setString(1, Vname);
//            ps.setInt(2, vage);
//            ps.setString(3, mobile);
//            ps.setString(4, NID);
//            ps.setString(5, Nationality);
//            ps.setString(6, Vaddress);
//            ps.setString(7, CrimeType);
//            ps.setString(8, CrimePlace);
//            ps.setString(9, CrimeTime);
//            ps.setString(10, CrimeDetails);
//            ps.executeUpdate();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(EditDatabase.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//  
// public static void suspect(String sname, int sage, String saddress,String motive,String relation) {
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd police help desk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
//            PreparedStatement ps = con.prepareStatement("Insert into userinfo(SuspectName,SuspectAge,SuspectAdress,Motive,Relationship) Values (?,?,?,?,?)");
//            ps.setString(1, sname);
//            ps.setInt(2, sage);
//            ps.setString(3, saddress);
//            ps.setString(4, motive);
//            ps.setString(5,relation);
//            ps.executeUpdate();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(EditDatabase.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//  
  
}

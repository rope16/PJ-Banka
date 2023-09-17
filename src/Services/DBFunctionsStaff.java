/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.Staff;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petar
 */
public class DBFunctionsStaff {
    private String url, username, password;
    
    public Connection con = null;
    
    public boolean Connect(){
        try {
            boolean status = false;
            Class.forName("com.mysql.jdbc.Driver");
            String serverName = "localhost";
            String dataBase = "banka";
            url = "jdbc:mysql://" + serverName + ":3306/" + dataBase;
            username = "petarp";
            password = "petarperic123";
            con = (Connection) DriverManager.getConnection(url, username, password);
            if(!con.isClosed()){
                System.out.println("Konekcija ostvarena");
                status = true;
            }else{
                System.out.println("Konekcija nije ostvarena.");
            }
            return status;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBFunctionsStaff.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DBFunctionsStaff.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ArrayList<Staff> GetAllStaff(){
        ArrayList<Staff> staffList = new ArrayList();
        try {
            String query = "SELECT * FROM staff";
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Staff staff = new Staff(Integer.parseInt(rs.getString("ID")),
                                        Integer.parseInt(rs.getString("isAdmin")), 
                                        rs.getString("firstName"),
                                        rs.getString("lastName"), 
                                        rs.getString("password"),
                                        rs.getString("email"));
                staffList.add(staff);
            }
            return staffList;
        } catch (SQLException ex) {
            Logger.getLogger(DBFunctionsStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffList;
    }
    
    public Staff GetStaffMember(int ID){
        Staff staff = new Staff();
        try {
            String query = "SELECT * FROM `staff` WHERE ID=" + ID;
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                staff.setID(Integer.parseInt(rs.getString("ID")));
                staff.setIsAdmin(Integer.parseInt(rs.getString("isAdmin")));
                staff.setFirstName(rs.getString("firstName"));
                staff.setLastName(rs.getString("lastName"));
                staff.setPassword(rs.getString("password"));
                staff.setEmail(rs.getString("email"));
            }
            return staff;
        } catch (SQLException ex) {
            Logger.getLogger(DBFunctionsStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staff;
    }
    
    public boolean addStaffMember(Staff staff) {
        try {
            LoginService ls = new LoginService();
            String hashedPassword = ls.hash256B64(staff.getPassword());
            String query = "INSERT INTO staff (isAdmin, firstName, lastName, password, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setInt(1, staff.getIsAdmin());
            pstmt.setString(2, staff.getFirstName());
            pstmt.setString(3, staff.getLastName());
            pstmt.setString(4, hashedPassword);
            pstmt.setString(5, staff.getEmail());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBFunctionsStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; // Return false if an exception occurs
    }
    
    public boolean updateStaffMember(Staff staff) {
        try {
            String query = "UPDATE staff SET isAdmin = ?, firstName = ?, lastName = ?, password = ?, email = ? WHERE ID = ?";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setInt(1, staff.getIsAdmin());
            pstmt.setString(2, staff.getFirstName());
            pstmt.setString(3, staff.getLastName());
            pstmt.setString(4, staff.getPassword());
            pstmt.setString(5, staff.getEmail());
            pstmt.setInt(6, staff.getID());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row was affected (user updated successfully)
        } catch (SQLException ex) {
            Logger.getLogger(DBFunctionsStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; // Return false if an exception occurs
    }
    
    public boolean deleteStaffMember(int ID){
        try {
            String query = "DELETE FROM staff WHERE ID = ?";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setInt(1, ID);
            int rowsAffected = pstmt.executeUpdate();
            
            if(rowsAffected > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBFunctionsStaff.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void changePassword(int userId, String newPassword) {
        try {
            String query = "UPDATE staff SET password = ? WHERE ID = ?";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, newPassword);
            pstmt.setInt(2, userId);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Password changed successfully for user with ID " + userId);
            } else {
                System.out.println("Password change failed. User with ID " + userId + " does not exist.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

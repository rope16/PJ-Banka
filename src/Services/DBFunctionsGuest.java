/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.Guest;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
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
public class DBFunctionsGuest {
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
            Logger.getLogger(DBFunctionsGuest.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DBFunctionsGuest.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ArrayList<Guest> getAllGuests() {
        ArrayList<Guest> guestList = new ArrayList<>();
        try {
            String query = "SELECT * FROM guest";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                double balance = rs.getDouble("balance");

                Guest guest = new Guest(id, firstName, lastName, email, password, phone, balance);
                guestList.add(guest);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return guestList;
    }
    
    public Guest getGuestById(int id) {
        Guest guest = null;
        try {
            String query = "SELECT * FROM guest WHERE ID = ?";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                double balance = rs.getDouble("balance");

                guest = new Guest(id, firstName, lastName, email, password, phone, balance);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return guest;
    }
    
    public boolean addGuest(Guest guest) {
        try {
            LoginService ls = new LoginService();
            String hashedPassword = ls.hash256B64(guest.getPassword());
            String query = "INSERT INTO guest (firstName, lastName, email, password, phone, balance) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, guest.getFirstName());
            pstmt.setString(2, guest.getLastName());
            pstmt.setString(3, guest.getEmail());
            pstmt.setString(4, hashedPassword);
            pstmt.setString(5, guest.getPhone());
            pstmt.setDouble(6, guest.getBalance());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Guest added successfully to the database.");
                return true;
            } else {
                System.out.println("Failed to add the guest to the database.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean updateGuest(Guest guest) {
        try {
            String query = "UPDATE guest SET firstName = ?, lastName = ?, email = ?, password = ?, phone = ?, balance = ? WHERE ID = ?";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, guest.getFirstName());
            pstmt.setString(2, guest.getLastName());
            pstmt.setString(3, guest.getEmail());
            pstmt.setString(4, guest.getPassword());
            pstmt.setString(5, guest.getPhone());
            pstmt.setDouble(6, guest.getBalance());
            pstmt.setInt(7, guest.getID());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Guest updated successfully in the database.");
                return true;
            } else {
                System.out.println("Failed to update the guest in the database. Guest with provided ID not found.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteGuest(int id) {
        try {
            String query = "DELETE FROM guest WHERE ID = ?";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Guest deleted successfully from the database.");
                return true;
            } else {
                System.out.println("Failed to delete the guest from the database. Guest with provided ID not found.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

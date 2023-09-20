/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.Loan;
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
 * @author elephant solutions
 */
public class DBFuntionsLoan {
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
    
    public ArrayList<Loan> GetAllLoans(){
        ArrayList<Loan> loadList = new ArrayList();
        try {
            String query = "SELECT * FROM loan";
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Loan loan = new Loan(Integer.parseInt(rs.getString("ID")),
                                        Integer.parseInt(rs.getString("userId")), 
                                        Double.parseDouble(rs.getString("amount")),
                                        Double.parseDouble(rs.getString("interest")), 
                                        Double.parseDouble(rs.getString("amountToReturn")),
                                        Double.parseDouble(rs.getString("monthlyRate")),
                                                 Integer.parseInt(rs.getString("months")));
                loadList.add(loan);
            }
            return loadList;
        } catch (SQLException ex) {
            Logger.getLogger(DBFunctionsStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loadList;
    }
    
    public Loan GetLoan(int ID){
        Loan loan = new Loan();
        try {
            String query = "SELECT * FROM `loan` WHERE ID=" + ID;
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                loan.setId(Integer.parseInt(rs.getString("ID")));
                loan.setUserId(Integer.parseInt(rs.getString("userId")));
                loan.setAmount(rs.getDouble("amount"));
                loan.setInterest(rs.getDouble("interest"));
                loan.setAmountToReturn(rs.getDouble("amountToReturn"));
                loan.setMonthlyRate(rs.getDouble("monthlyRate"));
                loan.setMonths(rs.getInt("months"));
            }
            return loan;
        } catch (SQLException ex) {
            Logger.getLogger(DBFunctionsStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loan;
    }
    
    public boolean addLoan(Loan loan) {
        try {
            String query = "INSERT INTO loan (amount, interest, amountToReturn, monthlyRate, months, userId) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setDouble(1, loan.getAmount());
            pstmt.setDouble(2, loan.getInterest());
            pstmt.setDouble(3, loan.getAmountToReturn());
            pstmt.setDouble(4, loan.getMonthlyRate());
            pstmt.setInt(5, loan.getMonths());
            pstmt.setInt(6, loan.getUserId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBFunctionsStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; // Return false if an exception occurs
    }
    
    public boolean updateLoan(Loan loan) {
        try {
            String query = "UPDATE loan SET amount = ?, interest = ?, amountToReturn = ?, monthlyRate = ?, months = ?, userId = ? WHERE ID = ?";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setDouble(1, loan.getAmount());
            pstmt.setDouble(2, loan.getInterest());
            pstmt.setDouble(3, loan.getAmountToReturn());
            pstmt.setDouble(4, loan.getMonthlyRate());
            pstmt.setInt(5, loan.getMonths());
            pstmt.setInt(6, loan.getUserId());
            pstmt.setInt(7, loan.getId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row was affected (user updated successfully)
        } catch (SQLException ex) {
            Logger.getLogger(DBFunctionsStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; // Return false if an exception occurs
    }
    
    public boolean deleteLoan(int ID){
        try {
            String query = "DELETE FROM loan WHERE ID = ?";
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
}

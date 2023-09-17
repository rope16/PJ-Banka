/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.Staff;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginService {
    public static String hash256B64(String lozinka){
        try {
            byte []podatak = lozinka.getBytes();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte []sha256 = md.digest(podatak);
            return Base64.getEncoder().encodeToString(sha256);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
            return "Greska";
        }
    }
    
    public boolean provjeriKorisnika(String email, String password, ArrayList<Staff> staffList){
        String hashedPassword = hash256B64(password);
        for(Staff staff : staffList){
            if(staff.getEmail().equals(email) && staff.getPassword().equals(hashedPassword)){
                return true;
            }
        }
        return false;
    }
    
    public boolean provjeriAdmina(String email, String password, ArrayList<Staff> staffList){
        String hashedPassword = hash256B64(password);
        for(Staff staff : staffList){
            if(staff.getEmail().equals(email) && staff.getPassword().equals(hashedPassword)){
                DBFunctionsStaff dbFunctions = new DBFunctionsStaff();
                dbFunctions.Connect();
                Staff staffMember = dbFunctions.GetStaffMember(staff.getID());
                if(staffMember.getIsAdmin() == 1){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
    
    public int ulogovaniZaposleni(String email, String password, ArrayList<Staff> staffList){
        int staffId = 0;
        String hashedPassword = hash256B64(password);
        for(Staff staff : staffList){
            if(staff.getEmail().equals(email) && staff.getPassword().equals(hashedPassword)){
                staffId = staff.getID();
                return staffId;
            }
        }
        return staffId;
    }
}

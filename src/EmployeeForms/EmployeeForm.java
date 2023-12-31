/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package EmployeeForms;

import Models.Staff;
import Services.DBFunctionsStaff;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class EmployeeForm extends javax.swing.JFrame {

    int staffId;
    ArrayList<Staff> staffList = new ArrayList<>();
    DBFunctionsStaff dbFunctions = new DBFunctionsStaff();
    
    public EmployeeForm() {
        initComponents();
        loadStaffToTable();
    }
    
    public EmployeeForm(int staffId){
        this.staffId = staffId;
        initComponents();
        loadStaffToTable();
    }

    public void loadStaffToTable(){
         dbFunctions.Connect();
         staffList = dbFunctions.GetAllStaff();
         
         DefaultTableModel dtm = new DefaultTableModel();
        
            dtm.addColumn("ID");
            dtm.addColumn("Ime");
            dtm.addColumn("Prezime");
            dtm.addColumn("Email");
            dtm.addColumn("Admin");
            
            Object Staff[] = new Object[5];
            
            for(int i = 0; i<staffList.size(); i++){
                Staff[0] = staffList.get(i).getID();
                Staff[1] = staffList.get(i).getFirstName();
                Staff[2] = staffList.get(i).getLastName();
                Staff[3] = staffList.get(i).getEmail();
                Staff[4] = staffList.get(i).getIsAdmin();
                dtm.addRow(Staff);
            }
            
            this.zaposleni_TABLE.setModel(dtm);
    }
    
    public boolean provjeraPassworda(String password) {
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(this, "Šifra mora da sadrži najmanje 8 karaktera.");
            return false;
        }

        boolean hasNumber = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
                break;
            }
        }

        if (!hasNumber) {
            JOptionPane.showMessageDialog(this, "Šifra mora da sadrži najmanje jedan broj.");
            return false;
        }

        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        zaposleni_TABLE = new javax.swing.JTable();
        changePassword_BT = new javax.swing.JButton();
        confirmPassword_FI = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Ocisti = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        email_TB = new javax.swing.JTextField();
        dodaj_BT = new javax.swing.JButton();
        admin_RB = new javax.swing.JRadioButton();
        ime_TB = new javax.swing.JTextField();
        password_FI = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        obrisi_BT = new javax.swing.JButton();
        prezime_TB = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        update_BT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Ime");

        zaposleni_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Ime", "Prezime", "Email", "Admin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        zaposleni_TABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                zaposleni_TABLEMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(zaposleni_TABLE);

        changePassword_BT.setText("Promijeni sifru");
        changePassword_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassword_BTActionPerformed(evt);
            }
        });

        confirmPassword_FI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPassword_FIActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Potvrdi šifru");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Admin");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Prezime");

        Ocisti.setText("Ocisti unos");
        Ocisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OcistiActionPerformed(evt);
            }
        });

        jButton1.setText("Nazad");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        dodaj_BT.setText("Dodaj");
        dodaj_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodaj_BTActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Email");

        obrisi_BT.setText("Obrisi");
        obrisi_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obrisi_BTActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Šifra");

        update_BT.setText("Izmjeni");
        update_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_BTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Ocisti, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(changePassword_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(admin_RB)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ime_TB, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(prezime_TB)))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(email_TB)
                            .addComponent(password_FI, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(confirmPassword_FI))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(update_BT, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(obrisi_BT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dodaj_BT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ime_TB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(prezime_TB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(admin_RB)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(email_TB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dodaj_BT))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(password_FI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_BT))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(confirmPassword_FI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(obrisi_BT)))))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(changePassword_BT)
                        .addComponent(Ocisti)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zaposleni_TABLEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zaposleni_TABLEMousePressed
        Staff selectedStaff = staffList.get(zaposleni_TABLE.getSelectedRow());

        ime_TB.setText(selectedStaff.getFirstName());
        prezime_TB.setText(selectedStaff.getLastName());
        email_TB.setText(selectedStaff.getEmail());
        password_FI.setEnabled(false);
        password_FI.setText("");
        confirmPassword_FI.setEnabled(false);
        confirmPassword_FI.setText("");
    }//GEN-LAST:event_zaposleni_TABLEMousePressed

    private void changePassword_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassword_BTActionPerformed
        new EmployeePasswordForm(staffId).setVisible(true);
        dispose();
    }//GEN-LAST:event_changePassword_BTActionPerformed

    private void confirmPassword_FIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPassword_FIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPassword_FIActionPerformed

    private void OcistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OcistiActionPerformed
        ime_TB.setText("");
        prezime_TB.setText("");
        email_TB.setText("");
        password_FI.setEnabled(true);
        confirmPassword_FI.setEnabled(true);
    }//GEN-LAST:event_OcistiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AdminMenu(staffId).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dodaj_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodaj_BTActionPerformed
        String ime = ime_TB.getText();
        String prezime = prezime_TB.getText();
        String email = email_TB.getText();
        String password = password_FI.getText();
        String confirmPassword = confirmPassword_FI.getText();
        int isAdmin = 0;
        if(!ime.isEmpty()
            && !prezime.isEmpty()
            && !email.isEmpty()
            && !password.isEmpty()
            && !confirmPassword.isEmpty()
        )
        {
            if(password.equals(confirmPassword)){
                if(admin_RB.isSelected()){
                    isAdmin = 1;
                }
                Staff staff = new Staff(isAdmin, ime, prezime, password, email);
                dbFunctions.Connect();
                if(provjeraPassworda(password)){
                    if(dbFunctions.addStaffMember(staff)){
                        JOptionPane.showMessageDialog(this, "Radnik uspješno dodat!");
                        loadStaffToTable();
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "Sifre moraju da se podudaraju!");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
        }
    }//GEN-LAST:event_dodaj_BTActionPerformed

    private void obrisi_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obrisi_BTActionPerformed
        int id = 0;
        Object idValue = zaposleni_TABLE.getValueAt(zaposleni_TABLE.getSelectedRow(), 0);
        if(idValue != null){
            id = (int) idValue;
        }

        dbFunctions.Connect();

        if(dbFunctions.deleteStaffMember(id)){
            JOptionPane.showMessageDialog(this, "Zaposleni uspjesno obrisan!");
            loadStaffToTable();
        }
    }//GEN-LAST:event_obrisi_BTActionPerformed

    private void update_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_BTActionPerformed
        int id = 0;
        Object idValue = zaposleni_TABLE.getValueAt(zaposleni_TABLE.getSelectedRow(), 0);
        if(idValue != null){
            id = (int) idValue;
        }

        dbFunctions.Connect();
        Staff staff = dbFunctions.GetStaffMember(id);

        staff.setFirstName(ime_TB.getText());
        staff.setLastName(prezime_TB.getText());
        staff.setEmail(email_TB.getText());
        if(admin_RB.isSelected())
        staff.setIsAdmin(1);
        else
        staff.setIsAdmin(0);

        if(dbFunctions.updateStaffMember(staff)){
            JOptionPane.showMessageDialog(this, "Zaposleni uspjesno ažuriran.");
            loadStaffToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Došlo je do greške.");
        }
    }//GEN-LAST:event_update_BTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ocisti;
    private javax.swing.JRadioButton admin_RB;
    private javax.swing.JButton changePassword_BT;
    private javax.swing.JPasswordField confirmPassword_FI;
    private javax.swing.JButton dodaj_BT;
    private javax.swing.JTextField email_TB;
    private javax.swing.JTextField ime_TB;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton obrisi_BT;
    private javax.swing.JPasswordField password_FI;
    private javax.swing.JTextField prezime_TB;
    private javax.swing.JButton update_BT;
    private javax.swing.JTable zaposleni_TABLE;
    // End of variables declaration//GEN-END:variables
}

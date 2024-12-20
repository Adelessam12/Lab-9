/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab.Frontend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import lab.pkg9.Database;
import lab.pkg9.User;
import lab.pkg9.UserManager;

/**
 *
 * @author Dell
 */
public class Register extends javax.swing.JFrame {

    Database db;

    public Register(Database db) {
        this.db = db;
        setContentPane(new JLabel(new ImageIcon("R (2).jpg")));
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        usernamelabel = new javax.swing.JLabel();
        emaillabel = new javax.swing.JLabel();
        dateofbirthlabel = new javax.swing.JLabel();
        passwordlabel = new javax.swing.JLabel();
        confirmpasswordlabel = new javax.swing.JLabel();
        usernamefiled = new javax.swing.JTextField();
        emailfield = new javax.swing.JTextField();
        dateofbirth = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        confirmpassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        usernamelabel.setText("UserName");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(48, 37, 0, 0);
        getContentPane().add(usernamelabel, gridBagConstraints);

        emaillabel.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 37, 0, 0);
        getContentPane().add(emaillabel, gridBagConstraints);

        dateofbirthlabel.setText("Date of birth");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 37, 0, 0);
        getContentPane().add(dateofbirthlabel, gridBagConstraints);

        passwordlabel.setText("password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 37, 0, 0);
        getContentPane().add(passwordlabel, gridBagConstraints);

        confirmpasswordlabel.setText("confirm password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 37, 0, 0);
        getContentPane().add(confirmpasswordlabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 305;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 6, 0, 15);
        getContentPane().add(usernamefiled, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 305;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 15);
        getContentPane().add(emailfield, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 305;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 15);
        getContentPane().add(dateofbirth, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 305;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 15);
        getContentPane().add(jPasswordField1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 305;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 15);
        getContentPane().add(confirmpassword, gridBagConstraints);

        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 87, 6, 0);
        getContentPane().add(jButton1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String username = usernamefiled.getText().trim();
        String email = emailfield.getText().trim();
        String dobInput = dateofbirth.getText().trim();
        String password = new String(jPasswordField1.getPassword());
        String confirmPassword = new String(confirmpassword.getPassword());

        // Check if all fields are filled
        if (username.isEmpty() || email.isEmpty() || dobInput.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!email.matches("^[^@\\s]+@[^@\\s]+\\.[a-zA-Z]{2,4}$")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid email format. Example: user@example.com", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] emailParts = email.split("@");
        if (emailParts.length == 2 && emailParts[1].split("\\.").length != 2) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Email must contain exactly one dot in the domain part. Example: user@example.com",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Validate password strength
        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{7,}$")) {
            javax.swing.JOptionPane.showMessageDialog(this, """
                                                        Password must contain at least:
                                                        - One uppercase letter
                                                        - One lowercase letter
                                                        - One number
                                                        - One special character
                                                        - Minimum 7 characters""",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        if (!username.matches(".*[a-zA-Z].*")) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Username must contain at least one letter and cannot be entirely numeric.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate and parse the date of birth
        Date dob;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false); // Ensures strict date parsing
            dob = dateFormat.parse(dobInput);
        } catch (ParseException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean emailExists = false;
        if (db.getUsers() != null) {
            for (User user : db.getUsers()) {
                if (user.getEmail().equals(email)) {
                    emailExists = true;
                    break;
                }
            }
        }
        if (emailExists) {
            javax.swing.JOptionPane.showMessageDialog(this, "Email is already registered.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Check if password matches confirm password
        if (!password.equals(confirmPassword)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Show success message
        javax.swing.JOptionPane.showMessageDialog(this, "User registered successfully!", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        UserManager.registerUser(email, username, password, dob);
        // Clear fields after successful registration
        usernamefiled.setText("");
        emailfield.setText("");
        dateofbirth.setText("");
        jPasswordField1.setText("");
        confirmpassword.setText("");
        this.dispose();
        StartupPage sp = new StartupPage();
        sp.setVisible(true);


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmpassword;
    private javax.swing.JLabel confirmpasswordlabel;
    private javax.swing.JTextField dateofbirth;
    private javax.swing.JLabel dateofbirthlabel;
    private javax.swing.JTextField emailfield;
    private javax.swing.JLabel emaillabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel passwordlabel;
    private javax.swing.JTextField usernamefiled;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}

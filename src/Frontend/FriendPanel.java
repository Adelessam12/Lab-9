/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FriendPanel extends JPanel {
  
    public FriendPanel(String username, String profileImagePath) {
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); // Smaller horizontal and vertical gaps

        // Profile Image
        ProfilePanel profilePanel = new ProfilePanel();
        profilePanel.setPreferredSize(new Dimension(100, 100)); // Smaller profile image
        if (profileImagePath != null && !profileImagePath.isEmpty()) {
            File imgFile = new File(profileImagePath);
            if (imgFile.exists()) {
                profilePanel.setProfileImage(imgFile);
            }
        }
        add(profilePanel);

        // Username Label
        JLabel usernameLabel = new JLabel(username);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN,20)); // Smaller font size
        add(usernameLabel);

        // Reduce panel padding
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Smaller padding
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

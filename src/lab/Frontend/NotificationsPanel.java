/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lab.Frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lab.Frontend.PostPanel;
import lab.pkg9.Content;
import lab.pkg9.FriendshipService;
import lab.pkg9.User;

/**
 *
 * @author Dell
 */
public class NotificationsPanel extends javax.swing.JPanel {

    String username;
    String profilepath;
    FriendshipService fm;

    public NotificationsPanel(Object notificationObject, String profilePath, String username, FriendshipService fm) {
        initComponents();
        this.username = username;
        this.profilepath = profilePath;
        this.fm = fm;
        handleNotification(notificationObject);
    }

    private void handleNotification(Object notificationObject) {
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel();
        // If the notification is a Content type (like a post)
        if (notificationObject instanceof Content) {
            JButton viewPostButton = new JButton("View Post");

            viewPostButton.addActionListener(e -> {
                // Create a dialog to show the PostPanel
                JDialog postDialog = new JDialog();
                postDialog.setTitle("Post");
                postDialog.setSize(400, 300); // Adjust size as needed

                PostPanel postPanel = new PostPanel(username, profilepath, ((Content) notificationObject).getContent(), ((Content) notificationObject).getImagePath());
                postDialog.add(postPanel);

                // Set dialog properties
                postDialog.setModal(true); // Make it modal
                postDialog.setLocationRelativeTo(this); // Center relative to NotificationsPanel
                postDialog.setVisible(true); // Show the dialog
            });

            this.add(viewPostButton, BorderLayout.CENTER);

            // If the notification is a User (likely a friend request)
        } else if (notificationObject instanceof User) {
            JPanel friendPanel = new JPanel();
            friendPanel.setLayout(new FlowLayout());
            User friend = (User) notificationObject;

            // Assuming notificationObject also has the status (you can adjust this based on how status is passed)
            String friendRequestStatus = "pending"; // You might get the actual status from somewhere else

            // Friend request label
            JLabel friendLabel = new JLabel("Friend Request from: " + friend.getUsername());
            friendPanel.add(friendLabel);

            // Display accept/decline buttons only if the status is pending
            if ("pending".equals(friendRequestStatus)) {
                JButton acceptButton = new JButton("Accept");
                JButton declineButton = new JButton("Decline");

                acceptButton.addActionListener(e -> {
                    fm.acceptFriendRequest(friend);
                    declineButton.setVisible(false);
                    acceptButton.setVisible(false);
                    label.setText("accepted");

                });

                declineButton.addActionListener(e -> {
                    fm.declineFriendRequest(friend);
                    declineButton.setVisible(false);
                    acceptButton.setVisible(false);
                    label.setText("declined");

                    // Perform actual decline logic here
                });
friendPanel.add(label);
                friendPanel.add(acceptButton);
                friendPanel.add(declineButton);
            } else {
                // Handle other statuses if needed (e.g., accepted, declined)
                JLabel statusLabel = new JLabel("Request Status: " + friendRequestStatus);
                friendPanel.add(statusLabel);
            }

            this.add(friendPanel, BorderLayout.CENTER);

        } else {
            // If notification type is unknown
            JLabel errorLabel = new JLabel("Unknown notification type.");
            this.add(errorLabel, BorderLayout.CENTER);
        }
    }


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

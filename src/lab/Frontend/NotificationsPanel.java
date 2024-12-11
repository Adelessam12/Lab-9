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
import javax.swing.JPanel;
import lab.pkg9.Content;
import lab.pkg9.FriendshipService;
import lab.pkg9.User;

/**
 *
 * @author Dell
 */
public final class NotificationsPanel extends javax.swing.JPanel {

    private final String username;
    private final String profilepath;
    private final FriendshipService fm;
    private String status;

    public NotificationsPanel(Object notificationObject, String profilePath, String username, FriendshipService fm, String status) {
        initComponents();
        this.username = username;
        this.profilepath = profilePath;
        this.fm = fm;
        this.status = status;
        handle_sent_requests_Notification(notificationObject);
    }

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
        if (notificationObject instanceof Content) {
            // Panel to hold content notification
            JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            Content content = (Content) notificationObject;

            // Profile image as an icon
            JLabel profileImageLabel = new JLabel();
            String profileImagePath = profilepath; // Assuming User has this method
            if (profileImagePath != null && !profileImagePath.isEmpty()) {
                // Load the image and set it as an icon (adjust size as needed)
                javax.swing.ImageIcon profileIcon = new javax.swing.ImageIcon(profileImagePath);
                java.awt.Image scaledImage = profileIcon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                profileImageLabel.setIcon(new javax.swing.ImageIcon(scaledImage));
            } else {
                profileImageLabel.setText("No Image"); // Fallback if no profile image
            }
            // Username label
            JLabel usernameLabel = new JLabel("Posted by: " + username);

            // View Post button
            JButton viewPostButton = new JButton("View Post");
            viewPostButton.setPreferredSize(new java.awt.Dimension(100, 30)); // Set button size

            viewPostButton.addActionListener(e -> {
                // Create a dialog to show the PostPanel
                JDialog postDialog = new JDialog();
                postDialog.setTitle("Post");
                postDialog.setSize(400, 300); // Adjust size as needed

                PostPanel postPanel = new PostPanel(username, profilepath, content.getContent(), content.getImagePath());
                postDialog.add(postPanel);

                // Set dialog properties
                postDialog.setModal(true); // Make it modal
                postDialog.setLocationRelativeTo(this); // Center relative to NotificationsPanel
                postDialog.setVisible(true); // Show the dialog
            });

            // Add components to the content panel
            contentPanel.add(profileImageLabel);
            contentPanel.add(usernameLabel);
            contentPanel.add(viewPostButton);

            // Add content panel to NotificationsPanel
            this.add(contentPanel, BorderLayout.CENTER);

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

    public void handle_sent_requests_Notification(Object notificationObject) {
        // Set layout for this panel
        this.setLayout(new BorderLayout());

        // Panel to hold the notification
        JPanel notificationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        if (notificationObject instanceof User user) {

            // Profile image as an icon
            JLabel profileImageLabel = new JLabel();
            String profileImagePath = user.getProfile().getProfilePhotoPath(); // Assuming User has this method
            if (profileImagePath != null && !profileImagePath.isEmpty()) {
                // Load the image and set it as an icon (adjust size as needed)
                javax.swing.ImageIcon profileIcon = new javax.swing.ImageIcon(profileImagePath);
                java.awt.Image scaledImage = profileIcon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                profileImageLabel.setIcon(new javax.swing.ImageIcon(scaledImage));
            } else {
                profileImageLabel.setText("No Image"); // Fallback if no profile image
            }

            // Label for username and status
            String message = user.getUsername() + " has " + status.toLowerCase() + " your friend request.";
            JLabel messageLabel = new JLabel(message);

            // Add components to the notification panel
            notificationPanel.add(profileImageLabel);
            notificationPanel.add(messageLabel);
        } else {
            JLabel errorLabel = new JLabel("Invalid notification object for sent request.");
            notificationPanel.add(errorLabel);
        }

        // Add the notification panel to the main NotificationsPanel
        this.add(notificationPanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
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

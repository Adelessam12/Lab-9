/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab.Frontend;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import lab.pkg9.Content;
import lab.pkg9.Database;
import lab.pkg9.Profile;
import lab.pkg9.User;
import lab.pkg9.UserFactory;
import lab.pkg9.UserManager;

/**
 *
 * @author Dell
 */
public class UpdateProfile extends javax.swing.JFrame {
    /**
     * Creates new form UpdateProfile
     */
    private User user;
    private Database db;

    public UpdateProfile(User user, Database db) {
        setContentPane(new JLabel(new ImageIcon("R (2).jpg")));
        initComponents();
        bioTextPane.setEditable(false);
        jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));
        this.user = user;
        this.db = db;
        jLabel4.setText(user.getUsername());
        jLabel4.setFont(new Font("Arial", Font.PLAIN, 15)); // Font size
        jLabel4.setAlignmentX(Component.CENTER_ALIGNMENT); // Align to the left

        loaduser();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        profielphoto = new ProfilePanel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        postsContainerPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        friendsContainerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bioTextPane = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        coverphotolabel = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 153, 153));

        jButton1.setText("update pasword");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("update bio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("update profile photo ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        profielphoto.setPreferredSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout profielphotoLayout = new javax.swing.GroupLayout(profielphoto);
        profielphoto.setLayout(profielphotoLayout);
        profielphotoLayout.setHorizontalGroup(
            profielphotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        profielphotoLayout.setVerticalGroup(
            profielphotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        jButton4.setText("update cover photo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(0, 51, 204));

        postsContainerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        postsContainerPanel.setLayout(new javax.swing.BoxLayout(postsContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(postsContainerPanel);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        friendsContainerPanel.setLayout(new javax.swing.BoxLayout(friendsContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane3.setViewportView(friendsContainerPanel);

        jLabel1.setText("Bio:");

        jScrollPane2.setViewportView(bioTextPane);

        jLabel2.setText("My Posts:");

        jLabel3.setText("Friends:");

        jButton5.setText("return to newsfeed");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(381, 381, 381)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(539, 539, 539)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(profielphoto, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(coverphotolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(coverphotolabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(profielphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(250, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            user.getProfile().setProfilePhotoPath(path);
            ProfilePanel profilePanel = (ProfilePanel) profielphoto;
            profilePanel.setProfileImage(path);
            db.saveUsersToFile();
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Load the image from the selected file
            ImageIcon coverPhoto = new ImageIcon(selectedFile.getAbsolutePath());

            // Scale the image to the specific size (945x309)
            Image scaledImage = coverPhoto.getImage().getScaledInstance(945, 309, Image.SCALE_SMOOTH);
            user.getProfile().setCoverPhotoPath(selectedFile.getAbsolutePath());
            db.saveUsersToFile();
            // Ensure the label size is fixed and matches the desired image size
            coverphotolabel.setPreferredSize(new Dimension(945, 309));  // Set preferred size for label
            coverphotolabel.setIcon(new ImageIcon(scaledImage));  // Set scaled image as the icon
            coverphotolabel.revalidate();  // Revalidate the label to apply the new preferred size
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        User user1 = UserFactory.createUser("john.doe@example.com", "JohnDoe", "hashedPassword", new Date());
        user1.setProfile(new Profile("hello i am very delighted to announce "));
        JDialog dialog = new JDialog(this, "Update Bio", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(400, 150);
        dialog.setLocationRelativeTo(this);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel bioLabel = new JLabel("New Bio:");
        JTextField bioTextField = new JTextField(30);
        inputPanel.add(bioLabel);
        inputPanel.add(bioTextField);

        dialog.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        saveButton.addActionListener(e -> {
            String newBio = bioTextField.getText().trim();
            if (!newBio.isEmpty()) {
                user.getProfile().setBio(newBio);
                db.saveUsersToFile();
                loadBio();
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Bio cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        User user1 = UserFactory.createUser("john.doe@example.com", "JohnDoe", "hashedPassword", new Date());
        user1.setProfile(new Profile("hello i am very delighted to announce "));
        JDialog dialog = new JDialog(this, "Update Password", true);

        dialog.setLayout(new BorderLayout());
        dialog.setSize(400, 150);
        dialog.setLocationRelativeTo(this);

        // Input Panel with Label and JPasswordField
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel passwordLabel = new JLabel("New Password:");
        JPasswordField passwordField = new JPasswordField(20); // Password field with masking
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        dialog.add(inputPanel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        // Save button action
        saveButton.addActionListener(e -> {
            char[] newPassword = passwordField.getPassword(); // Get password as a char array
            String password = new String(newPassword).trim(); // Convert to String and trim

            if (!password.isEmpty()) {
                System.out.println(user.getHashedPassword());
                user.setHashedPassword(db.hashPassword(password)); // Update password using setter
                db.saveUsersToFile();
                System.out.println(user.getHashedPassword());
                JOptionPane.showMessageDialog(dialog, "Password updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose(); // Close the dialog
            } else {
                JOptionPane.showMessageDialog(dialog, "Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Cancel button action
        cancelButton.addActionListener(e -> dialog.dispose());

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Show the dialog
    dialog.setVisible(true);    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        db.saveUsersToFile();
        this.dispose();

    }//GEN-LAST:event_jButton5ActionPerformed
    private void loadPosts() {

        postsContainerPanel.removeAll();

        for (Content post : user.getPostManager().getContent()) {
            String username = UserManager.findUser(post.getAuthorId()).getUsername();
            String profilepath = UserManager.findUser(post.getAuthorId()).getProfile().getProfilePhotoPath();
            postsContainerPanel.add(new PostPanel(username, profilepath, post.getContent(), post.getImagePath()));
        }
        // Refresh the UI to show new posts
        postsContainerPanel.revalidate();
        postsContainerPanel.repaint();
    }

    private void loadFriends() {
        friendsContainerPanel.removeAll();
        ArrayList<User> friends = new ArrayList<>();
        for (String friendid : user.getFriendManager().getFriendList()) {
            friends.add(UserManager.findUser(friendid));
        }
        for (User friend : friends) {
            String username = friend.getUsername();
            String profileImagePath = (friend.getProfile() != null) ? friend.getProfile().getProfilePhotoPath() : null;
            int x =  friend.isIsOnline()? 1: 0;
            FriendPanel friendPanel = new FriendPanel(username, profileImagePath, x);
            friendPanel.setPreferredSize(new java.awt.Dimension(80, 80));  // Consistent size for each friend panel

            friendsContainerPanel.add(friendPanel);
        }

        friendsContainerPanel.revalidate();
        friendsContainerPanel.repaint();
    }

    public final void loaduser() {
        loadprofile();
        loadPosts();
        loadFriends();
        loadBio();

    }

    public void loadprofile() {
        ProfilePanel profilePanel = (ProfilePanel) profielphoto;
        profilePanel.setProfileImage(user.getProfile().getProfilePhotoPath());
        coverphotolabel.setIcon(new ImageIcon(user.getProfile().getCoverPhotoPath()));

    }

    private void loadBio() {
        // Get the bio from the user's profile
        String bio = user.getProfile().getBio();

        // Set the bio text into the JTextPane
        bioTextPane.setText(bio);
        bioTextPane.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane bioTextPane;
    private javax.swing.JLabel coverphotolabel;
    private javax.swing.JPanel friendsContainerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel postsContainerPanel;
    private javax.swing.JPanel profielphoto;
    // End of variables declaration//GEN-END:variables
}

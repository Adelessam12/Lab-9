/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab.Frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import lab.pkg9.Content;
import lab.pkg9.Group;
import lab.pkg9.Post;
import lab.pkg9.UserManager;
import lab.pkg9.GroupAdmin;
import lab.pkg9.GroupCoAdmin;
import lab.pkg9.GroupMember;

import lab.pkg9.GroupRole;
import lab.pkg9.User;

/**
 *
 * @author Dell
 */
public class GroupPage extends javax.swing.JFrame {

    /**
     * Creates new form GroupPage
     */
    private final Group group;
    private final User user;
    GroupRole role;

    public GroupPage(Group group, User user) {
        this.group = group;
        this.user = user;
        initComponents();
        if (user.getGroups().get(group.getGroupId()) == null) {
            loadGroupsPage();
            createPost.setVisible(false);
        } else {
            role = user.getGroups().get(group.getGroupId());
            if (role instanceof GroupAdmin) {
                loadAdminpage(new GroupAdmin(user.getUserId(), group.getGroupId()));
            } else if (role instanceof GroupCoAdmin) {
                loadcoadminPage(new GroupCoAdmin(user.getUserId(), group.getGroupId()));
            } else if (role instanceof GroupMember) {
                loadGroupsPage();
            }
        }
    }

    private void loadAdminpage(GroupAdmin admin) {
        loadGroup();
        loadposts();
        loadmembers(admin);
    }

    private void loadcoadminPage(GroupCoAdmin coadmin) {
        loadGroup();
        loadposts();
        loadcoadminmembers(coadmin);
    }

    private void loadGroupsPage() {
        loadGroup();
        loadposts();
        loadnobuttonmembers();
    }

    public void loadGroup() {

        ProfilePanel Groupimage = (ProfilePanel) groupPhoto;
        if (group.getGroupPhoto() != null) {
            Groupimage.setProfileImage(group.getGroupPhoto());
        }
        String Description = group.getDescription();

        // Set the bio text into the JTextPane
        jTextField1.setText(Description);
        jTextField1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));

    }

    public void loadnobuttonposts() {
        groupPosts.removeAll(); // Clear previous posts before reloading
        ArrayList<Post> posts = new ArrayList<>();

        // Collect all posts from the group
        for (Post key : group.getPosts()) {
            posts.add(key);
        }

        // Sort posts by timestamp (newest first)
        Collections.sort(posts, (p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()));

        // Loop through each post to create panels
        for (Content post : posts) {
            String username = UserManager.findUser(post.getAuthorId()).getUsername();
            String profilePath = UserManager.findUser(post.getAuthorId()).getProfile().getProfilePhotoPath();

            // Create a PostPanel for the post
            PostPanel postPanel = new PostPanel(username, profilePath, post.getContent(), post.getImagePath());

            // Add the post panel to the groupPosts panel
            groupPosts.add(postPanel);
        }

        // Refresh the groupPosts panel
        groupPosts.revalidate();
        groupPosts.repaint();
    }

    public void loadposts() {
        groupPosts.removeAll(); // Clear previous posts before reloading
        ArrayList<Post> posts = new ArrayList<>();

        // Collect all posts from the group
        for (Post post : group.getPosts()) {
            posts.add(post);
        }

        // Sort posts by timestamp (newest first)
        Collections.sort(posts, (p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()));

        // Loop through each post to create panels
        for (Post post : posts) {
            String username = post.getAuthorId();
            String profilePath = UserManager.findUser(post.getAuthorId()).getProfile().getProfilePhotoPath();

            // Create a PostPanel for the post
            PostPanel postPanel = new PostPanel(
                    UserManager.findUser(username).getUsername(), profilePath, post.getContent(), post.getImagePath());

            // Create Edit button
            JButton editButton = new JButton("Edit");
            // Create Remove button
            JButton removeButton = new JButton("Delete");
            if (role instanceof GroupAdmin) {
                GroupAdmin groupadmin = (GroupAdmin) user.getGroups().get(group.getGroupId());
                editButton.addActionListener(e -> {
                    EditPost editPost = new EditPost(groupadmin, post);
                    editPost.setVisible(true);
                });

                removeButton.addActionListener(e -> {
                    groupadmin.deletePost((Post) post);
                    postPanel.remove(removeButton);
                    postPanel.add(new JLabel("Deleted")).setFont(new Font("Arial", Font.PLAIN, 14));
                    postPanel.revalidate();
                    postPanel.repaint();

                });
                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Align buttons to the right
                buttonPanel.add(editButton);
                buttonPanel.add(removeButton);
                postPanel.add(buttonPanel);
            } else if (role instanceof GroupCoAdmin) {
                GroupCoAdmin groupCoadmin = (GroupCoAdmin) user.getGroups().get(group.getGroupId());
                editButton.addActionListener(e -> {
                    EditPost editPost = new EditPost(groupCoadmin, post);
                    editPost.setVisible(true);
                });

                removeButton.addActionListener(e -> {
                    groupCoadmin.deletePost((Post) post);
                    postPanel.remove(removeButton);
                    postPanel.add(new JLabel("Deleted")).setFont(new Font("Arial", Font.PLAIN, 14));
                    postPanel.revalidate();
                    postPanel.repaint();

                });
                postPanel.add(editButton);
                postPanel.add(removeButton);
            }

            // Add buttons to the post panel
            // Add the post panel to the groupPosts panel
            groupPosts.add(postPanel);
        }

        // Refresh the groupPosts panel
        groupPosts.revalidate();
        groupPosts.repaint();
    }

    public void loadnobuttonmembers() {
        membersPanel.removeAll();
        User admin = UserManager.findUser(group.getAdminId());
        membersPanel.add(new EntryPanel(admin.getUsername() + "  (Admin)", admin.getProfile().getProfilePhotoPath()));
        for (String id : group.getUsers().keySet()) {

            User user1 = UserManager.findUser(id);
            if (group.getUsers().get(id).equals("CoAdmin")) {
                membersPanel.add(new EntryPanel(user1.getUsername() + "  (Moderator)", user1.getProfile().getProfilePhotoPath()));

            }
        }
        if (group.getUsers().containsKey(user.getUserId())) {
            membersPanel.add(new EntryPanel(user.getUsername() + " Current user  (Member)", user.getProfile().getProfilePhotoPath()));
        }

        for (String id : group.getUsers().keySet()) {
            if (!user.getUserId().equals(id)) {
                User user1 = UserManager.findUser(id);
                if (group.getUsers().get(id).equals("Member")) {
                    membersPanel.add(new EntryPanel(user1.getUsername() + "  (Member)", user1.getProfile().getProfilePhotoPath()));
                }

            }
        }

        membersPanel.revalidate();
        membersPanel.repaint();
    }

    public void loadcoadminmembers(GroupCoAdmin coadmin) {
        membersPanel.removeAll(); // Clear the panel before loading members
        ArrayList<User> memberUsers = new ArrayList<>();
        ArrayList<User> restUsers = new ArrayList<>();
        User admin = UserManager.findUser(group.getAdminId());
        membersPanel.add(new EntryPanel(admin.getUsername() + "  (Admin)", admin.getProfile().getProfilePhotoPath()));
        membersPanel.add(new EntryPanel(user.getUsername() + "  (Current user - Moderator)", user.getProfile().getProfilePhotoPath()));
        for (String id : group.getUsers().keySet()) {
            if (!user.getUserId().equals(id)) {
                User user1 = UserManager.findUser(id);
                if (group.getUsers().get(id).equals("Member")) {
                    memberUsers.add(user1);
                } else if (group.getUsers().get(id).equals("CoAdmin")) {
                    restUsers.add(user1);
                }
            }
        }
        for (User user1 : restUsers) {
            membersPanel.add(new EntryPanel(user1.getUsername() + "  (Moderator)", user1.getProfile().getProfilePhotoPath()));
            JSeparator separator = new JSeparator();
            membersPanel.add(separator, BorderLayout.SOUTH);
        }
        for (User user1 : memberUsers) {
            JPanel entryPanel = loadcoAdminPanel(user1);
            membersPanel.add(entryPanel);
            JSeparator separator = new JSeparator();
            membersPanel.add(separator, BorderLayout.SOUTH);
        }

        membersPanel.revalidate();
        membersPanel.repaint();
    }

    private JPanel loadcoAdminPanel(User user1) {
        EntryPanel entrypanel = new EntryPanel(user1.getUsername() + "  (Moderator)", user1.getProfile().getProfilePhotoPath());
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> {
            switch (role) {
                case GroupAdmin groupAdmin ->
                    groupAdmin.removeMember(user1.getUserId());
                case GroupCoAdmin groupCoAdmin ->
                    groupCoAdmin.removeMember(user1.getUserId());
                default -> {
                }
            }

            entrypanel.remove(removeButton);
            entrypanel.add(new JLabel("Removed")).setFont(new Font("Arial", Font.PLAIN, 14));
            GroupCoAdmin coAdmin = (GroupCoAdmin) role;
            loadcoadminPage(coAdmin);
            entrypanel.revalidate();
            entrypanel.repaint();
        });
        entrypanel.add(removeButton);
        return entrypanel;
    }

    public void loadmembers(GroupAdmin adminrole) { /////// not done yet, dont do it, fix promote and demote. look a the pdf
        membersPanel.removeAll(); // Clear the panel before loading members
        ArrayList<User> memberUsers = new ArrayList<>();
        ArrayList<User> restUsers = new ArrayList<>();
        User admin = UserManager.findUser(group.getAdminId());
        membersPanel.add(new EntryPanel(admin.getUsername() + " (Current user - Admin)", admin.getProfile().getProfilePhotoPath()));
        for (String id : group.getUsers().keySet()) {
            User user1 = UserManager.findUser(id);
            if (group.getUsers().get(id).equals("Member")) {
                memberUsers.add(user1);
            } else if (group.getUsers().get(id).equals("CoAdmin")) {
                restUsers.add(user1);
            }
        }
        for (User user1 : restUsers) {
            JPanel entryPanel = loadAdminPanel(adminrole, user1);
            membersPanel.add(entryPanel);
            JSeparator separator = new JSeparator();
            membersPanel.add(separator, BorderLayout.SOUTH);
        }
        for (User user1 : memberUsers) {
            JPanel entryPanel = loadMemberAdminPanel(user1);
            membersPanel.add(entryPanel);
            JSeparator separator = new JSeparator();
            membersPanel.add(separator, BorderLayout.SOUTH);
        }
        membersPanel.revalidate(); // Refresh the UI
        membersPanel.repaint();
    }

    private JPanel loadAdminPanel(GroupAdmin admin, User user1) {
        EntryPanel entrypanel = new EntryPanel(user1.getUsername() + "  (Moderator)", user1.getProfile().getProfilePhotoPath());
        JButton demoteButton = new JButton("Demote");
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> {
            admin.removeMember(user1.getUserId());
            entrypanel.remove(removeButton);
            entrypanel.add(new JLabel("Removed")).setFont(new Font("Arial", Font.PLAIN, 14));
            entrypanel.revalidate();
            entrypanel.repaint();
        });

        demoteButton.addActionListener(e -> {
            admin.demoteToMember(user1.getUserId());
            entrypanel.remove(demoteButton);
            entrypanel.remove(removeButton);
            entrypanel.add(new JLabel("Demoted")).setFont(new Font("Arial", Font.PLAIN, 14));
            entrypanel.add(removeButton);
            entrypanel.revalidate();
            entrypanel.repaint();
        });
        entrypanel.add(demoteButton);
        entrypanel.add(removeButton);
        return entrypanel;
    }

    private JPanel loadMemberAdminPanel(User user1) {
        EntryPanel entrypanel = new EntryPanel(user1.getUsername() + "  (Member)", user1.getProfile().getProfilePhotoPath());
        JButton removeButton = new JButton("Remove");
        JButton promoteButton = new JButton("Promote");
        removeButton.addActionListener(e -> {
            ((GroupAdmin) role).removeMember(user1.getUserId());
            entrypanel.remove(removeButton);
            entrypanel.remove(promoteButton);
            entrypanel.add(new JLabel("Removed")).setFont(new Font("Arial", Font.PLAIN, 14));
            entrypanel.revalidate();
            entrypanel.repaint();
        });
        promoteButton.addActionListener(e -> {
            ((GroupAdmin) role).promoteToCoAdmin(user1.getUserId());
            entrypanel.remove(promoteButton);
            entrypanel.remove(removeButton);
            entrypanel.add(new JLabel("Promoted")).setFont(new Font("Arial", Font.PLAIN, 14));
            entrypanel.add(removeButton);
            entrypanel.revalidate();
            entrypanel.repaint();
        });
        entrypanel.add(promoteButton);
        entrypanel.add(removeButton);

        return entrypanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupPhoto = new ProfilePanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        createPost = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        groupPosts = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        membersPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        groupPhoto.setPreferredSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout groupPhotoLayout = new javax.swing.GroupLayout(groupPhoto);
        groupPhoto.setLayout(groupPhotoLayout);
        groupPhotoLayout.setHorizontalGroup(
            groupPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        groupPhotoLayout.setVerticalGroup(
            groupPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        jTextField1.setEditable(false);
        jTextField1.setBackground(java.awt.SystemColor.controlHighlight);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Description");

        createPost.setText("Create Post");
        createPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPostActionPerformed(evt);
            }
        });

        groupPosts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        groupPosts.setLayout(new javax.swing.BoxLayout(groupPosts, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(groupPosts);

        membersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        membersPanel.setLayout(new javax.swing.BoxLayout(membersPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(membersPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(groupPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(createPost)
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(groupPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 15, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(createPost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void createPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPostActionPerformed

        CreateGroupPost grouppost = new CreateGroupPost(role);
        grouppost.setVisible(true);

    }//GEN-LAST:event_createPostActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createPost;
    private javax.swing.JPanel groupPhoto;
    private javax.swing.JPanel groupPosts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel membersPanel;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab.Frontend;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
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
    Group group;
    User user;

    public GroupPage(Group group, User user) {
        this.group = group;
        this.user = user;
        initComponents();
        GroupRole role = user.getGroups().get(group.getGroupId());
        if (role instanceof GroupAdmin) {
            loadAdminpage(new GroupAdmin(user.getUserId(), group));

        } else if (role instanceof GroupCoAdmin) {
            loadcoadminPage(new GroupCoAdmin(user.getUserId(), group));
        } else if (role instanceof GroupMember) {
            loadGroupsPage();
        }
    }

    public GroupPage() {
    }

    public void loadcoadminPage(GroupCoAdmin coadmin) {
        loadGroup();
        loadposts();
        loadcoadminmembers(coadmin);
    }

    public void loadGroupsPage() {
        loadGroup();
        loadposts();
        loadnobuttonmembers();

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

    public void loadnobuttonmembers() {
        for (String id : group.getUsers().keySet()) {
            User user = UserManager.findUser(id);
            if (!user.getUserId().contains(id)) {
                membersPanel.add(new EntryPanel(user.getUsername(), user.getProfile().getProfilePhotoPath()));
            }
        }
    }

    public void loadAdminpage(GroupAdmin admin) {
        loadGroup();
        loadposts();
        loadmembers(admin);
    }

    public void loadGroup() {
        ProfilePanel Groupimage = (ProfilePanel) groupPhoto;
        Groupimage.setProfileImage(group.getGroupPhoto());
        String Description = group.getDescription();

        // Set the bio text into the JTextPane
        jTextField1.setText(Description);
        jTextField1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));

    }

    public void loadposts() {
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

            // Create Edit button
            JButton editButton = new JButton("Edit");
            GroupAdmin groupadmin = new GroupAdmin(group.getAdminId(), group);
            editButton.addActionListener(e -> {
                // Handle post editing logic here
                groupadmin.editPost((Post) post, profilePath, username);
            });

            // Create Remove button
            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(e -> {
                // Handle post removal logic here
            });

            // Add buttons to the post panel
            postPanel.add(editButton);
            postPanel.add(removeButton);

            // Add the post panel to the groupPosts panel
            groupPosts.add(postPanel);
        }

        // Refresh the groupPosts panel
        groupPosts.revalidate();
        groupPosts.repaint();
    }

    public void loadcoadminmembers(GroupCoAdmin coadmin) {
        membersPanel.removeAll(); // Clear the panel before loading members

        for (String id : group.getUsers().keySet()) {
            User user = UserManager.findUser(id);

            if (!user.getUserId().contains(id)) {
                EntryPanel panel = new EntryPanel(user.getUsername(), user.getProfile().getProfilePhotoPath());
                // Create Promote button
                JButton promoteButton = new JButton("Promote");
                promoteButton.addActionListener(e -> {
                    // Handle promote logic

                    loadcoadminmembers(coadmin); // Refresh the members panel
                });

                // Create Demote button
                JButton demoteButton = new JButton("Demote");
                demoteButton.addActionListener(e -> {
                    // Handle demote logic
                    GroupRole role = user.getGroups().get(group.getGroupId());
                    if (role instanceof GroupMember) {
                        coadmin.removeMember(user.getUserId());
                        System.out.println(user.getUsername() + " demoted to Member.");
                    }
                    loadcoadminmembers(coadmin); // Refresh the members panel
                });

                // Create Remove button
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(e -> {
                    // Handle remove logic
                    coadmin.removeMember(id);

                    System.out.println(user.getUsername() + " removed from the group.");
                    loadcoadminmembers(coadmin); // Refresh the members panel
                });

                // Add buttons to the EntryPanel
                panel.add(promoteButton);
                panel.add(demoteButton);
                panel.add(removeButton);

                // Add EntryPanel to membersPanel
                membersPanel.add(panel);
            }
        }

        membersPanel.revalidate(); // Refresh the UI
        membersPanel.repaint();
    }

    public void loadmembers(GroupAdmin admin) {
        membersPanel.removeAll(); // Clear the panel before loading members

        for (String id : group.getUsers().keySet()) {
            User user = UserManager.findUser(id);

            if (!user.getUserId().contains(id)) {
                EntryPanel panel = new EntryPanel(user.getUsername(), user.getProfile().getProfilePhotoPath());

                // Create Promote button
                JButton promoteButton = new JButton("Promote");
                promoteButton.addActionListener(e -> {
                    // Handle promote logic

                    loadmembers(admin); // Refresh the members panel
                });

                // Create Demote button
                JButton demoteButton = new JButton("Demote");
                demoteButton.addActionListener(e -> {
                    // Handle demote logic
                    GroupRole role = user.getGroups().get(group.getGroupId());
                    if (role instanceof GroupCoAdmin) {
                        admin.demoteToMember(user.getUserId());
                        System.out.println(user.getUsername() + " demoted to Member.");
                    }
                    loadmembers(admin); // Refresh the members panel
                });

                // Create Remove button
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(e -> {
                    // Handle remove logic
                    admin.removeMember(id);

                    System.out.println(user.getUsername() + " removed from the group.");
                    loadmembers(admin); // Refresh the members panel
                });

                // Add buttons to the EntryPanel
                panel.add(promoteButton);
                panel.add(demoteButton);
                panel.add(removeButton);

                // Add EntryPanel to membersPanel
                membersPanel.add(panel);
            }
        }

        membersPanel.revalidate(); // Refresh the UI
        membersPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        membersPanel = new javax.swing.JPanel();
        groupPhoto = new ProfilePanel();
        groupPosts = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        createPost = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        membersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        membersPanel.setLayout(new javax.swing.BoxLayout(membersPanel, javax.swing.BoxLayout.Y_AXIS));

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

        groupPosts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        groupPosts.setLayout(new javax.swing.BoxLayout(groupPosts, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("Description");

        createPost.setText("Create Post");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(groupPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(createPost))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(groupPosts, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(membersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(groupPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(membersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(groupPosts, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createPost;
    private javax.swing.JPanel groupPhoto;
    private javax.swing.JPanel groupPosts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel membersPanel;
    // End of variables declaration//GEN-END:variables
}

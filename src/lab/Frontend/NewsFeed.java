/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab.Frontend;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import lab.pkg9.Content;
import lab.pkg9.ContentCreator;
import lab.pkg9.Database;
import lab.pkg9.FriendshipService;
import lab.pkg9.Post;
import lab.pkg9.User;
import lab.pkg9.UserManager;

/**
 *
 * @author Dell
 */
public final class NewsFeed extends javax.swing.JFrame {

    /**
     * Creates new form NewsFeed
     *
     * @param user
     */
    Database database;
    User user;
    ContentCreator Cm;
    FriendshipService FM ;

    public NewsFeed(User user, Database database, ContentCreator Cm) {
        setContentPane(new JLabel(new ImageIcon("R (2).jpg")));
        initComponents();
        ImageIcon originalIcon = new javax.swing.ImageIcon(user.getProfile().getProfilePhotoPath());
        Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        profile.setIcon(new ImageIcon(scaledImage));
        this.database = database;
        this.user = user;
        this.Cm = Cm;
         FM = new FriendshipService(user);
        
     loadFriendRequests();
        loadnewsfeed();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        Friendpostspanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Storiescontainerpanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        friendsContainerPanel = new javax.swing.JPanel();
        Refresh_button = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        create_content_button = new javax.swing.JButton();
        friend_managment_button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        Notifications_panel = new javax.swing.JPanel();
        ViewStories = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Friendpostspanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Freind's Posts"));
        Friendpostspanel.setLayout(new javax.swing.BoxLayout(Friendpostspanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(Friendpostspanel);

        Storiescontainerpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Friend Stories"));
        Storiescontainerpanel.setLayout(new javax.swing.BoxLayout(Storiescontainerpanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane2.setViewportView(Storiescontainerpanel);
        Storiescontainerpanel.getAccessibleContext().setAccessibleName("");

        friendsContainerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Friends"));
        friendsContainerPanel.setLayout(new javax.swing.BoxLayout(friendsContainerPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane3.setViewportView(friendsContainerPanel);

        ImageIcon originalIcon =new javax.swing.ImageIcon("R.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        Refresh_button.setIcon(new ImageIcon(scaledImage));
        Refresh_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Refresh_buttonActionPerformed(evt);
            }
        });

        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });

        ImageIcon originalIcon2 =new javax.swing.ImageIcon("OIP.jpeg");
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        create_content_button.setIcon(new ImageIcon(scaledImage2));
        create_content_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_content_buttonActionPerformed(evt);
            }
        });

        ImageIcon originalIcon5 =new javax.swing.ImageIcon("image.jpeg");
        Image scaledImage5 = originalIcon5.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        friend_managment_button.setIcon(new ImageIcon(scaledImage5));
        friend_managment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend_managment_buttonActionPerformed(evt);
            }
        });

        ImageIcon originalIcon4 =new javax.swing.ImageIcon("logout-vector-icon.jpg");
        Image scaledImage4 = originalIcon4.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        jButton1.setIcon(new ImageIcon(scaledImage4));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("show notifications");

        Notifications_panel.setLayout(new javax.swing.BoxLayout(Notifications_panel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane5.setViewportView(Notifications_panel);

        buttonGroup1.add(ViewStories);
        ViewStories.setText("View stories");
        ViewStories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewStoriesActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButton1);
        jToggleButton1.setText("View friend suggestions");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ViewStories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(Refresh_button)
                                .addGap(18, 18, 18)
                                .addComponent(profile)
                                .addGap(29, 29, 29)
                                .addComponent(create_content_button)
                                .addGap(18, 18, 18)
                                .addComponent(friend_managment_button)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ViewStories)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Refresh_button, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friend_managment_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(create_content_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(156, 156, 156))
        );

        jScrollPane2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Refresh_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_buttonActionPerformed
        ImageIcon originalIcon = new javax.swing.ImageIcon(user.getProfile().getProfilePhotoPath());
        Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        profile.setIcon(new ImageIcon(scaledImage));
        loadnewsfeed();
    }//GEN-LAST:event_Refresh_buttonActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        UpdateProfile up = new UpdateProfile(this.user, database);
        up.setVisible(true);        up.setVisible(true);        up.setVisible(true);    }//GEN-LAST:event_profileActionPerformed

    private void create_content_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_content_buttonActionPerformed
        // Create a dialog
        int choice = javax.swing.JOptionPane.showOptionDialog(
                this,
                "What would you like to create?",
                "Choose Action",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Create Post", "Create Story"},
                "Create Post"
        );

        // Handle user choice
        if (choice == javax.swing.JOptionPane.YES_OPTION) {
            // Open CreatePost JFrame
            CreatePost postFrame = new CreatePost(user, Cm);
            postFrame.setVisible(true);
        } else if (choice == javax.swing.JOptionPane.NO_OPTION) {
            // Open CreateStory JFrame
            CreateStory storyFrame = new CreateStory(user, Cm);
            storyFrame.setVisible(true);
        }
    }//GEN-LAST:event_create_content_buttonActionPerformed

    private void friend_managment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend_managment_buttonActionPerformed
        FriendsPage fp = new FriendsPage(user);
        fp.setVisible(true);
    }//GEN-LAST:event_friend_managment_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UserManager.logout(user);
        this.dispose();
        StartupPage sp = new StartupPage();
        sp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ViewStoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewStoriesActionPerformed
      TitledBorder title = BorderFactory.createTitledBorder("Friend Stories");
        Storiescontainerpanel.setBorder(title);
            loadfriendstories();
               
    }//GEN-LAST:event_ViewStoriesActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
            TitledBorder title = BorderFactory.createTitledBorder("Friend Suggestions");
        Storiescontainerpanel.setBorder(title);
        loadSuggestions();
                }//GEN-LAST:event_jToggleButton1ActionPerformed

    public void loadnewsfeed() {
        loadFriends();
        loadPosts();
        loadfriendstories();
      
    }

    public void loadPosts() {
        Friendpostspanel.removeAll();
        ArrayList<Content> allfriendsposts = new ArrayList<>();
        ArrayList<User> friends = new ArrayList<>();
        for (String friendid : user.getFriendManager().getFriendList()) {
            friends.add(UserManager.findUser(friendid));
        }
        for (User friend : friends) {
            for (Content post : friend.getPostManager().getContent()) {
                allfriendsposts.add(post);

            }
        }
        Collections.sort(allfriendsposts, (p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()));

        // Add PostPanel for each post (text first, then image)
        for (Content post : allfriendsposts) {
            String username = UserManager.findUser(post.getAuthorId()).getUsername();
            String profilepath = UserManager.findUser(post.getAuthorId()).getProfile().getProfilePhotoPath();
            Friendpostspanel.add(new PostPanel(username, profilepath, post.getContent(), post.getImagePath()));
           // Notifications_panel.add(new NotificationsPanel( post, profilepath, username));
        }

        Notifications_panel.revalidate();
        Notifications_panel.repaint();
        Friendpostspanel.revalidate();
        Friendpostspanel.repaint();
    }

    public void loadFriends() {
        friendsContainerPanel.removeAll();
        ArrayList<User> friends = new ArrayList<>();
        for (String friendid : user.getFriendManager().getFriendList()) {
            friends.add(UserManager.findUser(friendid));
        }
        for (User friend : friends) {
            String username = friend.getUsername();
            String profileImagePath = (friend.getProfile() != null) ? friend.getProfile().getProfilePhotoPath() : null;

            FriendPanel friendPanel = new FriendPanel(username, profileImagePath, friend.isIsOnline());
            friendPanel.setPreferredSize(new java.awt.Dimension(80, 80));  // Consistent size for each friend panel

            friendsContainerPanel.add(friendPanel);
        }
        friendsContainerPanel.revalidate();
        friendsContainerPanel.repaint();
    }

    public void loadfriendstories() {
        Storiescontainerpanel.removeAll();
        ArrayList<User> friends = new ArrayList<>();
        for (String friendid : user.getFriendManager().getFriendList()) {
            User friend = UserManager.findUser(friendid);
            if (friend.getStoryManager().getContent().isEmpty()) {
                friends.add(friend);

            }
        }
        for (User friend : friends) {
            StoryPanel storyPanel = new StoryPanel(friend);
            Storiescontainerpanel.add(storyPanel);
            
        }
        Storiescontainerpanel.revalidate();
        Storiescontainerpanel.repaint();
    }
public void loadFriendRequests() {
    // Clear the current content of the Notifications_panel
    Notifications_panel.removeAll();

    // Get the received friend requests from the user's manager
    Map<String, String> receivedFriendRequests = user.getFriendRequestManagable().getReceivedFriendRequests();

    // Loop through the map and add a NotificationPanel for each friend request
    for (Map.Entry<String, String> entry : receivedFriendRequests.entrySet()) {
        String friendId = entry.getKey(); // The user ID
        String requestStatus = entry.getValue(); // The status of the request (e.g., "pending", "accepted", etc.)

        // Find the User object using the userManager's findUser method
        User friend = UserManager.findUser(friendId);

        if (friend != null && requestStatus.equals("Pending")) {
            // Add the NotificationPanel to the Notifications_panel
            Notifications_panel.add(new NotificationsPanel(friend,friend.getUsername(), friend.getProfile().getProfilePhotoPath(),FM));
        }
    }

    // Refresh the panel to display updated notifications
    Notifications_panel.revalidate();
    Notifications_panel.repaint();
}
    public void loadSuggestions() {
        Storiescontainerpanel.removeAll();
        
        ArrayList<User> suggestions = FM.suggestions();

        for (User suggestion : suggestions) {
            if (!user.getFriendRequestManagable().getSentFriendRequests().containsKey(suggestion.getUserId())) {
                String profileImagePath = (suggestion.getProfile() != null) ? suggestion.getProfile().getProfilePhotoPath() : null;
                SuggestionPanel suggestionPanel = new SuggestionPanel(user, suggestion, profileImagePath, FM);

                suggestionPanel.setPreferredSize(new Dimension(200, 100));
                Storiescontainerpanel.add(suggestionPanel);
                JButton add = new JButton("Add Friend");
                suggestionPanel.add(add);
                Storiescontainerpanel.add(suggestionPanel);
                add.addActionListener((java.awt.event.ActionEvent evt) -> {
                    FM.sendFriendRequest(suggestion);
                    System.out.println(user.getFriendRequestManagable().getSentFriendRequests());
                    suggestionPanel.remove(add);
                    database.saveUsersToFile();
                    //ArrayList<User> users = database.getUsers();
                    suggestionPanel.add(new JLabel("   sent")).setFont(new Font("Arial", Font.PLAIN, 14));
                    Storiescontainerpanel.revalidate();
                    Storiescontainerpanel.repaint();
                });
            }
        }
        Storiescontainerpanel.revalidate();
        Storiescontainerpanel.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Friendpostspanel;
    private javax.swing.JPanel Notifications_panel;
    private javax.swing.JButton Refresh_button;
    private javax.swing.JPanel Storiescontainerpanel;
    private javax.swing.JToggleButton ViewStories;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton create_content_button;
    private javax.swing.JButton friend_managment_button;
    private javax.swing.JPanel friendsContainerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton profile;
    // End of variables declaration//GEN-END:variables
}

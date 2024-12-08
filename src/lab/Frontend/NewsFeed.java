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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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

    public NewsFeed(User user, Database database, ContentCreator Cm) {
        setContentPane(new JLabel(new ImageIcon("R (2).jpg")));
        initComponents();
        ImageIcon originalIcon = new javax.swing.ImageIcon(user.getProfile().getProfilePhotoPath());
        Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        profile.setIcon(new ImageIcon(scaledImage));
        this.database = database;
        this.user = user;
        this.Cm = Cm;
        loadnewsfeed();
    }

    public NewsFeed() throws HeadlessException {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Friendpostspanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Storiescontainerpanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        friendsContainerPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        friendSuggestionspanel = new javax.swing.JPanel();
        Refresh_button = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        create_content_button = new javax.swing.JButton();
        friend_managment_button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Friendpostspanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Freind's Posts"));
        Friendpostspanel.setLayout(new javax.swing.BoxLayout(Friendpostspanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(Friendpostspanel);

        Storiescontainerpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Friend's Stories"));
        Storiescontainerpanel.setLayout(new javax.swing.BoxLayout(Storiescontainerpanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane2.setViewportView(Storiescontainerpanel);

        friendsContainerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Friends"));
        friendsContainerPanel.setLayout(new javax.swing.BoxLayout(friendsContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane3.setViewportView(friendsContainerPanel);

        friendSuggestionspanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Friend suggestions"));
        friendSuggestionspanel.setLayout(new javax.swing.BoxLayout(friendSuggestionspanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane4.setViewportView(friendSuggestionspanel);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1037, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Refresh_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(create_content_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(friend_managment_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(Refresh_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addComponent(profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(create_content_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(friend_managment_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(589, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Refresh_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_buttonActionPerformed
        Storiescontainerpanel.removeAll();
        friendsContainerPanel.removeAll();
        Friendpostspanel.removeAll();
        friendSuggestionspanel.removeAll();
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
        FriendsPage fp = new FriendsPage(user, database);
        fp.setVisible(true);
    }//GEN-LAST:event_friend_managment_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UserManager.logout(user);
        this.dispose();
        StartupPage sp = new StartupPage();
        sp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void loadnewsfeed() {
        loadFriends();
        loadPosts();
        loadSuggestions();
        loadfriendstories();
    }

    public void loadPosts() {
        ArrayList<Post> allfriendsposts = new ArrayList<>();
        ArrayList<User> friends = new ArrayList<>();
        for (String friendid : user.getFriendManager().getFriendList()) {
            friends.add(UserManager.findUser(friendid));
        }
        for (User friend : friends) {
            for (Post post : friend.getPostManager().getPosts()) {
                allfriendsposts.add(post);
            }
        }
        Collections.sort(allfriendsposts, (p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()));

        // Add PostPanel for each post (text first, then image)
        for (Post post : allfriendsposts) {
            Friendpostspanel.add(new PostPanel(post.getContent(), post.getImagePath()));
        }

        // Refresh the UI to show new posts
        Friendpostspanel.revalidate();
        Friendpostspanel.repaint();
    }

    public void loadFriends() {
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
        ArrayList<User> friends = new ArrayList<>();
        for (String friendid : user.getFriendManager().getFriendList()) {
            friends.add(UserManager.findUser(friendid));
        }
        for (User friend : friends) {
            StoryPanel storyPanel = new StoryPanel(friend);
            Storiescontainerpanel.add(storyPanel);
        }
        Storiescontainerpanel.revalidate();
        Storiescontainerpanel.repaint();
    }

    public void loadSuggestions() {
        FriendshipService FM = new FriendshipService(database, user);
        ArrayList<User> suggestions = FM.suggestions();

        for (User suggestion : suggestions) {
            if(!user.getFriendRequestManagable().getSentFriendRequests().containsKey(suggestion.getUsername())){
            String profileImagePath = (suggestion.getProfile() != null) ? suggestion.getProfile().getProfilePhotoPath() : null;
            SuggestionPanel suggestionPanel = new SuggestionPanel(user, suggestion, profileImagePath, FM);

            suggestionPanel.setPreferredSize(new Dimension(200, 100));
            friendSuggestionspanel.add(suggestionPanel);
            JButton add = new JButton("Add Friend");
            suggestionPanel.add(add);
            friendSuggestionspanel.add(suggestionPanel);
            add.addActionListener((java.awt.event.ActionEvent evt) -> {
                FM.sendFriendRequest(suggestion);
                System.out.println(user.getFriendRequestManagable().getSentFriendRequests());
                suggestionPanel.remove(add);
                database.saveUsersToFile();
                //ArrayList<User> users = database.getUsers();
                suggestionPanel.add(new JLabel("   sent")).setFont(new Font("Arial", Font.PLAIN, 14));
                friendSuggestionspanel.revalidate();
                friendSuggestionspanel.repaint();
            });
            }
        }
        friendSuggestionspanel.revalidate();
        friendSuggestionspanel.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Friendpostspanel;
    private javax.swing.JButton Refresh_button;
    private javax.swing.JPanel Storiescontainerpanel;
    private javax.swing.JButton create_content_button;
    private javax.swing.JPanel friendSuggestionspanel;
    private javax.swing.JButton friend_managment_button;
    private javax.swing.JPanel friendsContainerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton profile;
    // End of variables declaration//GEN-END:variables
}

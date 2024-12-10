/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab.Frontend;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lab.pkg9.Database;
import lab.pkg9.DatabaseFactory;
import lab.pkg9.FriendshipService;
import lab.pkg9.FriendshipServiceInterface;
import lab.pkg9.User;
import lab.pkg9.UserManager;

/**
 *
 * @author Mahmoud Waleed
 */
public class FriendsPage extends javax.swing.JFrame {

    /**
     * Creates new form FriendsPage
     */
    private final User user;
    private final FriendshipServiceInterface friendService;
    private final Database db;

    public FriendsPage(User user) {
        initComponents();
        this.user = user;
        this.db = DatabaseFactory.createDatabase();
        friendService = new FriendshipService(user);
        loadSuggestions();
        scrollFriends.setVisible(false);
        scrollRequests.setVisible(false);
        setLocationRelativeTo(null);
        friendsContainer.setLayout(new BoxLayout(friendsContainer, BoxLayout.Y_AXIS));
        requestsContainer.setLayout(new BoxLayout(requestsContainer, BoxLayout.Y_AXIS));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollRequests = new javax.swing.JScrollPane();
        requestsContainer = new javax.swing.JPanel();
        scrollFriends = new javax.swing.JScrollPane();
        friendsContainer = new javax.swing.JPanel();
        scrollSuggestions = new javax.swing.JScrollPane();
        friendSuggestionspanel = new javax.swing.JPanel();
        friends = new javax.swing.JButton();
        requestActivity = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        requestsContainer.setLayout(new javax.swing.BoxLayout(requestsContainer, javax.swing.BoxLayout.LINE_AXIS));
        scrollRequests.setViewportView(requestsContainer);

        friendsContainer.setLayout(new javax.swing.BoxLayout(friendsContainer, javax.swing.BoxLayout.LINE_AXIS));
        scrollFriends.setViewportView(friendsContainer);

        scrollSuggestions.setMaximumSize(new java.awt.Dimension(469, 225));

        friendSuggestionspanel.setMaximumSize(new java.awt.Dimension(467, 223));
        friendSuggestionspanel.setMinimumSize(new java.awt.Dimension(467, 223));
        friendSuggestionspanel.setLayout(new javax.swing.BoxLayout(friendSuggestionspanel, javax.swing.BoxLayout.Y_AXIS));
        scrollSuggestions.setViewportView(friendSuggestionspanel);

        friends.setText("Show Friends");
        friends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsActionPerformed(evt);
            }
        });

        requestActivity.setText("Show Friends Requests");
        requestActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestActivityActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("People You May Know");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(friends, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollFriends, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollSuggestions, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollRequests)
                    .addComponent(requestActivity, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(requestActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(friends, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(scrollRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollFriends, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollSuggestions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void friendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsActionPerformed
        friends.setText("Hide Friends List");

        // Clear any previous entries to reset the friend list only when switching views
        if (!scrollFriends.isVisible()) {
            // When scrollFriends is hidden, show it and populate it
            friendsContainer.removeAll();
            friendsContainer.revalidate();
            friendsContainer.repaint();

            // friends to the UI
            if (user.getFriendManager().getFriendList() != null && !user.getFriendManager().getFriendList().isEmpty()) {
                ArrayList<User> friendss = new ArrayList<>();
                for (String friendid : user.getFriendManager().getFriendList()) {
                    friendss.add(UserManager.findUser(friendid));
                }
                for (User user1 : friendss) {
                    JPanel entryPanel1 = new JPanel();
                    entryPanel1.setLayout(new FlowLayout(FlowLayout.LEFT)); // Horizontal layout for label and button
                    JLabel newLabel = new JLabel(user1.getUsername()); // Show the friend's username
                    JButton remove = new JButton("Remove");
                    JButton block = new JButton("  Block  ");

                    // Add components to the panel
                    entryPanel1.add(newLabel);
                    entryPanel1.add(remove);
                    entryPanel1.add(block);
                    remove.addActionListener((java.awt.event.ActionEvent evt1) -> {
                        user.getFriendManager().removeFriend(user, user1);
                        db.saveUsersToFile();
                        friendService.suggestions().add(user1);
                        newLabel.setText("Removed");
                        entryPanel1.remove(remove);
                        entryPanel1.remove(block);
                        friendsContainer.repaint();
                    });
                    block.addActionListener((java.awt.event.ActionEvent evt1) -> {
                        friendService.blockFriend(user1);
                        entryPanel1.remove(remove);
                        entryPanel1.remove(block);
                        newLabel.setText("Blocked");
                        friendsContainer.repaint();
                    });

                    // Add the entry panel to friendsContainer
                    friendsContainer.add(entryPanel1);

                }
                

                friendsContainer.revalidate();
                friendsContainer.repaint();
            } else {
                System.out.println("No friends found!");
                 friendsContainer.add(new JLabel("\n \n \n    NO FRIENDS")).setFont(new Font("Arial", Font.PLAIN, 14));
                friendsContainer.repaint();
            }
            scrollFriends.setVisible(true);
            friendsContainer.setVisible(true);

            // Revalidate the scroll pane to update the view
            scrollFriends.revalidate();
            scrollFriends.repaint();
        } else {
            // Hide the friends list if it's already visible
            scrollFriends.setVisible(false);
            friendsContainer.setVisible(false);
            friends.setText("Show Friends");
        }
    }//GEN-LAST:event_friendsActionPerformed

    private void requestActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestActivityActionPerformed
        requestActivity.setText("Hide Friend Requests");
        if (!scrollRequests.isVisible()) {

            // Clear any previous entries to reset the request list
            requestsContainer.removeAll();
            requestsContainer.revalidate();
            requestsContainer.repaint();

            //add friend requests to the UI
            if (user.getFriendRequestManagable().getReceivedFriendRequests().containsValue("Pending") && !user.getFriendRequestManagable().getReceivedFriendRequests().isEmpty()) {
                for (Map.Entry<String, String> user1 : user.getFriendRequestManagable().getReceivedFriendRequests().entrySet()) {
                    if (user1.getValue().contains("Pending")) {
                        //     System.out.println(user1.getValue());
                        System.out.println(user.getFriendRequestManagable().getReceivedFriendRequests());
                        System.out.println(user.getFriendRequestManagable().getSentFriendRequests());
                        //System.out.println(user1.getKey().getFriendRequestManagable().getReceivedFriendRequests());

                        JPanel entryPanel = new JPanel();
                        entryPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Horizontal layout for label and button

                        // Create the label dynamically for each friend
                     
                        JLabel newLabel = new JLabel(UserManager.findUser(user1.getKey()).getUsername() + " " + user1.getValue());
                        JButton accept = new JButton("Accept");
                        JButton decline = new JButton("Delete");

                        // Add components to the panel
                        entryPanel.add(newLabel);
                        entryPanel.add(accept);
                        entryPanel.add(decline);

                        accept.addActionListener((java.awt.event.ActionEvent evt1) -> {
                            friendService.acceptFriendRequest(UserManager.findUser(user1.getKey()));
                            //System.out.println(user.getValue().get(1));
                            entryPanel.remove(accept);
                            entryPanel.remove(decline);
                            newLabel.setText("Accepted");
                            requestsContainer.repaint();
                        });

                        decline.addActionListener((java.awt.event.ActionEvent evt1) -> {
                            friendService.declineFriendRequest(UserManager.findUser(user1.getKey()));
                            entryPanel.remove(accept);
                            entryPanel.remove(decline);
                            newLabel.setText("Deleted");
                            requestsContainer.repaint();
                        });

                        // Add the entry panel to friendsContainer
                        requestsContainer.add(entryPanel);
                    }

                    // Revalidate and repaint after adding components to the container
                    requestsContainer.revalidate();
                    requestsContainer.repaint();
                }
            } else {
                System.out.println("No requests found!");
                requestsContainer.add(new JLabel("NO NEW REQUESTS")).setFont(new Font("Arial", Font.PLAIN, 14));
                requestsContainer.repaint();
            }
            scrollRequests.setVisible(true);
            requestsContainer.setVisible(true);

            // Revalidate the scroll pane to update the view
            scrollRequests.revalidate();
            scrollRequests.repaint();
}
            else {
            // Hide the friends list if it's already visible
            scrollRequests.setVisible(false);
            requestsContainer.setVisible(false);
            requestActivity.setText("Show Friend Requests ");
        }

    }//GEN-LAST:event_requestActivityActionPerformed

    private void loadSuggestions() {
        friendSuggestionspanel.removeAll();
        ArrayList<User> suggestions = friendService.suggestions();
//        System.out.println(suggestions.get(0));
        for (User suggestion : suggestions) {
            if (!user.getFriendRequestManagable().getSentFriendRequests().containsKey(suggestion.getUserId())) {
                String profileImagePath = (suggestion.getProfile() != null) ? suggestion.getProfile().getProfilePhotoPath() : null;
                SuggestionPanel suggestionPanel = new SuggestionPanel(user, suggestion, profileImagePath, friendService);
                //Username Label
                String name = suggestion.getUsername();
                JLabel nameLabel = new JLabel(name);
                nameLabel.setFont(new Font("Arial", Font.PLAIN, 15)); // Font size
                nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align to the left

                suggestionPanel.setPreferredSize(new Dimension(200, 100));
                suggestionPanel.add(nameLabel);
                JButton add = new JButton("Add Friend");
                suggestionPanel.add(add);
                friendSuggestionspanel.add(suggestionPanel);
                add.addActionListener((java.awt.event.ActionEvent evt) -> {
                    friendService.sendFriendRequest(suggestion);
                    System.out.println(user.getFriendRequestManagable().getSentFriendRequests());
                    suggestionPanel.remove(add);
                    suggestionPanel.add(new JLabel("   sent")).setFont(new Font("Arial", Font.PLAIN, 14));
                    friendSuggestionspanel.revalidate();
                    friendSuggestionspanel.repaint();
                });
            }
        }
        scrollSuggestions.repaint();
        scrollSuggestions.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel friendSuggestionspanel;
    private javax.swing.JButton friends;
    private javax.swing.JPanel friendsContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton requestActivity;
    private javax.swing.JPanel requestsContainer;
    private javax.swing.JScrollPane scrollFriends;
    private javax.swing.JScrollPane scrollRequests;
    private javax.swing.JScrollPane scrollSuggestions;
    // End of variables declaration//GEN-END:variables
}

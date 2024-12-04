/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Collections;
import lab.pkg9.Post;
import lab.pkg9.Story;
import lab.pkg9.User;

/**
 *
 * @author Dell
 */
public class NewsFeed extends javax.swing.JFrame {

    /**
     * Creates new form NewsFeed
     */
    
    public NewsFeed(User user) {
       initComponents();
            loadPosts(user);
            loadFriends(user);
            loadfriendstories(user);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Friendpostspanel.setLayout(new javax.swing.BoxLayout(Friendpostspanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(Friendpostspanel);

        Storiescontainerpanel.setLayout(new javax.swing.BoxLayout(Storiescontainerpanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane2.setViewportView(Storiescontainerpanel);

        friendsContainerPanel.setLayout(new javax.swing.BoxLayout(friendsContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane3.setViewportView(friendsContainerPanel);

        friendSuggestionspanel.setLayout(new javax.swing.BoxLayout(friendSuggestionspanel, javax.swing.BoxLayout.X_AXIS));
        jScrollPane4.setViewportView(friendSuggestionspanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(165, 165, 165)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void loadPosts(User user) {
        ArrayList<Post> allfriendsposts= new ArrayList<>();
for(User friend: user.getFriendList())
   for(Post post :friend.getPosts())
   {
      allfriendsposts.add(post);
   }
         Collections.sort(allfriendsposts, (p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()));
         
  
       

        // Add PostPanel for each post (text first, then image)
       for (Post post: allfriendsposts)
       {
           Friendpostspanel.add(new PostPanel(post.getContent(),post.getImagePath()));
       }

        // Refresh the UI to show new posts
        Friendpostspanel.revalidate();
        Friendpostspanel.repaint();
    }

    public void loadFriends(User user) {
    friendsContainerPanel.removeAll();

    ArrayList<User> friends = user.getFriendList();
    for (User friend : friends) {
        String username = friend.getUsername();
        String profileImagePath = (friend.getProfile() != null) ? friend.getProfile().getProfilePhotoPath() : null;

        FriendPanel friendPanel = new FriendPanel(username, profileImagePath,friend.isIsOnline());
        friendPanel.setPreferredSize(new java.awt.Dimension(80, 80));  // Consistent size for each friend panel

        friendsContainerPanel.add(friendPanel);
    }

    friendsContainerPanel.revalidate();
    friendsContainerPanel.repaint();
}
public void loadfriendstories(User user) {
    for (User friend : user.getFriendList()) {
        
        StoryPanel storyPanel = new StoryPanel(friend);
        Storiescontainerpanel.add(storyPanel);
    }
}

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewsFeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewsFeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewsFeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewsFeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewsFeed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Friendpostspanel;
    private javax.swing.JPanel Storiescontainerpanel;
    private javax.swing.JPanel friendSuggestionspanel;
    private javax.swing.JPanel friendsContainerPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}

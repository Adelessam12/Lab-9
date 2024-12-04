package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import lab.pkg9.Story;
import lab.pkg9.User;

public class StoryPanel extends JPanel {
    private ProfilePanel profilePanel; // Changed from ImagePanel to ProfilePanel
    private JButton button;
    private User friend;

    public StoryPanel(User friend) {
        this.friend = friend;
        setLayout(new GridBagLayout());  // Use GridBagLayout for more control
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Create and add ProfilePanel (to display the profile picture)
        profilePanel = new ProfilePanel();
        profilePanel.setProfileImage(friend.getProfile().getProfilePhotoPath());
        profilePanel.setPreferredSize(new Dimension(100, 100)); // Set the size of the profile image
        gbc.gridx = 0; 
        gbc.gridy = 0;
        add(profilePanel, gbc);  // Add the profile image panel to the top of the grid

        // Create button to show friend's stories
        button = new JButton("See " + friend.getUsername() + " stories");
        button.setPreferredSize(new Dimension(200, 50)); // Set the size of the button
        button.setMinimumSize(new Dimension(200, 50)); // Prevent the button from shrinking
        button.setMaximumSize(new Dimension(200, 50)); // Prevent the button from expanding
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openStoryPopup(friend);
            }
        });
        
        // Add button below the image panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(button, gbc);
    }

    // Open a popup with a scrollable list of the friend's stories
   private void openStoryPopup(User friend) {
    // Create a new dialog to display the stories
    JDialog storyDialog = new JDialog((Frame) null, "Stories of " + friend.getUsername(), true);
    storyDialog.setLayout(new BorderLayout());
    
    // Create a panel to hold the stories
    JPanel storiesPanel = new JPanel();
    storiesPanel.setLayout(new BoxLayout(storiesPanel, BoxLayout.Y_AXIS));

    // Add each story to the panel using PostPanel
    List<Story> stories = friend.getStories();
    for (Story story : stories) {
        // Create a PostPanel for each story
        // You may want to adjust the parameters to match your Story model
        PostPanel postPanel = new PostPanel(story.getContent(), story.getImagePath());
        storiesPanel.add(postPanel);
    }

    // Add stories panel inside a JScrollPane for scrolling
    JScrollPane scrollPane = new JScrollPane(storiesPanel);
    storyDialog.add(scrollPane, BorderLayout.CENTER);

    // Set dialog size and display it
    storyDialog.setSize(300, 400);
    storyDialog.setVisible(true);
}

}

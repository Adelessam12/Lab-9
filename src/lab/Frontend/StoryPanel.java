package lab.Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import lab.pkg9.Content;
import lab.pkg9.Story;
import lab.pkg9.User;

public class StoryPanel extends JPanel {
    private final ProfilePanel profilePanel; // Changed from ImagePanel to ProfilePanel
    private final JButton button;

    public StoryPanel(User friend) {
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
        String firstname=friend.getUsername().split(" ")[0];
        button = new JButton("See " + firstname + " stories");
        button.setPreferredSize(new Dimension(150, 25)); // Set the size of the button
        button.setMinimumSize(new Dimension(150, 25)); // Prevent the button from shrinking
        button.setMaximumSize(new Dimension(150, 25)); // Prevent the button from expanding
        button.addActionListener((ActionEvent e) -> {
            openStoryPopup(friend);
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
    ArrayList<Content> stories = friend.getStoryManager().getContent();
    for (Content story : stories) {
        if ((((Story) story).isExpired())) {
            friend.getStoryManager().removeContent(story);
        } else {
            PostPanel postPanel = new PostPanel(story.getContent(), story.getImagePath());
            postPanel.setMaximumSize(new Dimension(500, 300)); // Restrict maximum size of each PostPanel
            storiesPanel.add(postPanel);
            storiesPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between posts
        }
    }

    // Add stories panel inside a JScrollPane for scrolling
    JScrollPane scrollPane = new JScrollPane(storiesPanel);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    storyDialog.add(scrollPane, BorderLayout.CENTER);

    // Set dialog size dynamically based on content or provide a larger default size
    int width = Math.max(500, storiesPanel.getPreferredSize().width + 50); // Add padding for scrollbars
    int height = Math.min(600, storiesPanel.getPreferredSize().height + 50); // Limit to a reasonable height
    storyDialog.setSize(width, height);
    storyDialog.setLocationRelativeTo(null); // Center the dialog on the screen

    // Display the dialog
    storyDialog.setVisible(true);
}

}

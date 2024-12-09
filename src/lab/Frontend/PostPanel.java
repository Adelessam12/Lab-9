package lab.Frontend;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.swing.border.EmptyBorder;

public class PostPanel extends JPanel {

   private final String username;
    private final String profileImagePath;
    private final String content;
    private final String imagePath;
    
    public PostPanel(String username, String profileImagePath, String content, String imagePath) {
        this.username = username;
        this.profileImagePath = profileImagePath;
        this.content = content;
        this.imagePath = imagePath;

        setLayout(new BorderLayout(10, 10)); // Border layout with gaps

        // Create and add profile panel (username + profile photo)
        JPanel profilePanel = createProfilePanel();
        add(profilePanel, BorderLayout.NORTH);

        // Create and add content and image panel (side-by-side layout)
        JPanel postContentPanel = createPostContentPanel();
        add(postContentPanel, BorderLayout.CENTER);

        // Add separator line
        JSeparator separator = new JSeparator();
        add(separator, BorderLayout.SOUTH);
    }
     /**
     * Creates a panel to display the user's profile picture and username.
     */
    private JPanel createProfilePanel() {
        JPanel profilePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0)); // Horizontal layout
        profilePanel.setOpaque(false);

        // Profile photo
        ProfilePanel profileImagePanel = new ProfilePanel();
        profileImagePanel.setPreferredSize(new Dimension(50, 50)); // Circular size
        profileImagePanel.setProfileImage(profileImagePath);
        profilePanel.add(profileImagePanel);

        // Username label
        JLabel usernameLabel = new JLabel(username);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        usernameLabel.setForeground(Color.BLACK);
        profilePanel.add(usernameLabel);

        return profilePanel;
    }

    /**
     * Creates a panel to display the post's text content and image.
     */
    private JPanel createPostContentPanel() {
    JPanel postContentPanel = new JPanel(new BorderLayout(10, 0)); // Horizontal layout with a gap
    postContentPanel.setOpaque(false);

    // Text content panel
    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
    contentPanel.setOpaque(false);

    // Add padding to the content panel
    contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

    // Post content label with proper multiline indentation
    JLabel contentLabel = new JLabel("<html><div style='margin-left:20px; font-size:12px; line-height:1.5;'>"
            + content.replace("\n", "<br>") + "</div></html>");
    contentLabel.setForeground(Color.DARK_GRAY); // Use dark gray for a softer look
    contentLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align content to the left
    contentLabel.setBorder(new EmptyBorder(0, 0, 10, 0)); // Add padding below the label

    // Add the label to the content panel
    contentPanel.add(contentLabel);

    // Add the content panel to the left side
    postContentPanel.add(contentPanel, BorderLayout.CENTER);

    // Image panel
    JPanel imagePanel = createImagePanel();
    imagePanel.setBorder(new EmptyBorder(10, 0, 10, 10)); // Add padding around the image
    postContentPanel.add(imagePanel, BorderLayout.EAST); // Place the image on the right

    return postContentPanel;
}



    /**
     * Creates a panel for displaying the image content of the post.
     */
   private JPanel createImagePanel() {
    JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    imagePanel.setOpaque(false);

    if (imagePath != null) {
        try {
            File imgFile = new File(imagePath);
            if (imgFile.exists()) {
                ImageIcon imageIcon = new ImageIcon(imagePath);
                Image image = imageIcon.getImage();
                Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
                imagePanel.add(imageLabel);
            } else {
                // Use the error panel for missing image files
                imagePanel.add(createErrorPanel("Image not found"));
            }
        } catch (Exception e) {
            // Use the error panel for exceptions
            imagePanel.add(createErrorPanel("Error loading image"));
        }
    } else {
        // Use the error panel for null image paths
        imagePanel.add(createErrorPanel("No image provided"));
    }

    return imagePanel;
}
    /**
     * Creates a panel to display an error message.
     *
     * @param errorMessage The error message to display.
     */
    private JPanel createErrorPanel(String errorMessage) {
    JPanel errorPanel = new JPanel();
    JLabel errorLabel = new JLabel(errorMessage);
    errorLabel.setForeground(Color.RED); // Display error message in red
    errorPanel.add(errorLabel);
    errorPanel.setOpaque(false); // Transparent background
    return errorPanel;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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

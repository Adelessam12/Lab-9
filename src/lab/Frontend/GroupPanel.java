package lab.Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroupPanel extends JPanel {
    private String groupName;
    private String imagePath;
    private JButton viewGroupButton;

    /**
     * Constructs a GroupPanel for a specific group.
     * @param groupName the name of the group.
     * @param imagePath the path to the group's image.
     */
    public GroupPanel(String groupName, String imagePath) {
        this.groupName = groupName;
        this.imagePath = imagePath;

        setLayout(new BorderLayout());

        // Create and add the ImagePanel
        ImagePanel imagePanel = new ImagePanel(imagePath);
        add(imagePanel, BorderLayout.WEST);

        // Create and add the group name label
        JLabel nameLabel = new JLabel(groupName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(nameLabel, BorderLayout.CENTER);

        // Create and add the "View Group" button
        viewGroupButton = new JButton("View Group");
        add(viewGroupButton, BorderLayout.EAST);

        // Add action listener to the button
        viewGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openViewGroupFrame();
            }
        });
    }

    /**
     * Opens the ViewGroup frame for this group.
     */
    private void openViewGroupFrame() {
        JFrame viewGroupFrame = new JFrame("View Group - " + groupName);
        viewGroupFrame.setSize(400, 300);
        viewGroupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // You can add more details about the group here
        JLabel groupDetails = new JLabel("Details of " + groupName);
        groupDetails.setHorizontalAlignment(SwingConstants.CENTER);
        groupDetails.setFont(new Font("Arial", Font.PLAIN, 18));

        viewGroupFrame.add(groupDetails);
        viewGroupFrame.setVisible(true);
    }
}

package lab.Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lab.pkg9.Group;
import lab.pkg9.User;

public class GroupPanel extends JPanel {
 
    /**
     * Constructs a GroupPanel for a specific group.
     * @param groupName the name of the group.
     * @param imagePath the path to the group's image.
     */
    String groupName;
    String imagePath;
    JButton viewGroupButton;
    Group group;
    User user;
    public GroupPanel(Group group, User user) {
        this.group= group;
        this.user= user;
        this.groupName = group.getName();
        this.imagePath = group.getGroupPhoto();

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
        GroupPage gp= new GroupPage(group, user);
        gp.setVisible(true);
    }
}

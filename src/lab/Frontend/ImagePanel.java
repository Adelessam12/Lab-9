package lab.Frontend;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class ImagePanel extends JPanel {
    private String imagePath;

    public ImagePanel(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagePath != null) {
            ImageIcon icon = new ImageIcon(imagePath);
            Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            g.drawImage(image, 0, 0, null);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);  // Fixed size for the image panel
    }
}

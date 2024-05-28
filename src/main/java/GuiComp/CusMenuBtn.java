package GuiComp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 * Custom menu button class.
 * 
 * @author Mustafa
 */
public class CusMenuBtn extends JButton {
    private boolean over;

    public CusMenuBtn() {
        initButton();
    }

    private void initButton() {
        setFont(new Font("Arial", Font.PLAIN, 14));
        setForeground(Color.WHITE);
        setBackground(new Color(0, 0, 0, 0));
        setBorder(new EmptyBorder(5, 10, 5, 10));
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setHorizontalTextPosition(JButton.RIGHT); // Ensures text is to the right of the icon
        setVerticalTextPosition(JButton.CENTER); // Ensures text is centered vertically
        setPreferredSize(new Dimension(200, 50)); // Increased width to allow space for icon and text

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setFont(new Font("Arial", Font.BOLD, 14));
                over = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setFont(new Font("Arial", Font.PLAIN, 14));
                over = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent me) {
                setFont(new Font("Arial", Font.BOLD, 14));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    public void setIcon(Icon icon) {
        super.setIcon(icon);
        if (icon != null) {
            setHorizontalTextPosition(JButton.RIGHT); // Ensure text is to the right of the icon
            setVerticalTextPosition(JButton.CENTER); // Ensure text is centered vertically
            setIconTextGap(10); // Space between icon and text
        }
    }
}

package GuiComp;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Mustafa
 */
public class CusPasswordField extends JPasswordField {
    private Icon purifix;
    private String placeholder;
    private int radius;
    private Color borderColor;

    public Icon getPurifix() {
        return purifix;
    }

    public void setPurifix(Icon purifix) {
        this.purifix = purifix;
        initBorder();
        repaint();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public CusPasswordField() {
        this.radius = 15; // Default radius
        this.borderColor = Color.BLACK; // Default border color
        setBorder(new EmptyBorder(10, 3, 10, 3));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius));
        super.paintComponent(g2);
        paintIcon(g2);
        paintPlaceholder(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(borderColor);
        g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, radius, radius));
        g2.dispose();
    }

    private void paintIcon(Graphics g) {
        if (purifix != null) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            Image prefix = ((ImageIcon) purifix).getImage();
            int y = (getHeight() - purifix.getIconHeight()) / 2;
            g2.drawImage(prefix, 5, y, purifix.getIconWidth(), purifix.getIconHeight(), this);
            g2.dispose();
        }
    }

    private void paintPlaceholder(Graphics g) {
        if (placeholder != null && getText().isEmpty()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR);
            FontMetrics fm = g.getFontMetrics();
            g2.setColor(Color.GRAY);
            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
            g2.drawString(placeholder, purifix != null ? purifix.getIconWidth() + 10 : 5, y);
            g2.dispose();
        }
    }

    private void initBorder() {
        int left = 5;
        if (purifix != null) {
            left = purifix.getIconWidth() + 10; 
        }
        setBorder(new EmptyBorder(10, left, 10, 3));
    }
}
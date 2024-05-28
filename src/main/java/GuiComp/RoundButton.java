package GuiComp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 * Custom JButton with rounded edges.
 */
public class RoundButton extends JButton {
    private Color colorOver;
    private Color colorClick;
    private  Color backcolor;

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getBackcolor() {
        return backcolor;
    }

    public void setBackcolor(Color backcolor) {
        this.backcolor = backcolor;
    }
    private boolean over;
    private int radius;
    public RoundButton() {
         this(15);
         backcolor= new Color(102,0,102);
         colorOver = new Color(179, 250, 160);
         colorClick = new Color(152, 184, 144);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(colorOver);
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(backcolor);
                over = false;

            }

            @Override
            public void mousePressed(MouseEvent me) {
                 setBackground(colorClick);
            }
            @Override
                public void mouseReleased(MouseEvent me) {
                if (over) {
                    setBackground(colorOver);
                } else {
                    setBackground(backcolor);
                }
            }
        });
    }

    public RoundButton(int radius) {
        this.radius = radius;
        setContentAreaFilled(false); 
        setPreferredSize(new Dimension(100, 40)); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(getShape());
        g2.setColor(getForeground());
        g2.draw(getShape());
        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do not paint border by default
    }

    @Override
    public boolean contains(int x, int y) {
        // Hit detection for round buttons
        Shape shape = getShape();
        return shape.contains(x, y);
    }

    private Shape getShape() {
        return new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }
}

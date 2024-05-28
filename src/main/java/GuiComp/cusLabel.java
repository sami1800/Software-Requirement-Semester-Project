/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuiComp;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Mustafa
 */
public class cusLabel extends JLabel {
    public cusLabel(String Text){
        super(Text);
        setOpaque(true);
        setBackground(Color.WHITE);
        setForeground(new Color(103,102,102) );
        setBorder(new EmptyBorder(10,5,10,5));
    } 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(230,230,230));
        g.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
    }
}

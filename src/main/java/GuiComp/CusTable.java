package GuiComp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Mustafa
 */
public class CusTable extends JTable {

    public CusTable() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        
        // Custom header renderer
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel header = new JLabel(value + "");
                header.setOpaque(true);
                header.setBackground(Color.decode("#3c1053")); // Header background color
                header.setForeground(Color.WHITE); // Header text color
                header.setFont(header.getFont().deriveFont(Font.BOLD)); // Bold font
                header.setHorizontalAlignment(SwingConstants.CENTER); // Center alignment
                return header;
            }
        });

        // Custom cell renderer
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (comp instanceof JLabel) {
                    JLabel label = (JLabel) comp;
                    label.setText(value + "");
                    if (column == 4) {
                        label.setHorizontalAlignment(SwingConstants.CENTER);
                    } else {
                        label.setHorizontalAlignment(SwingConstants.LEFT);
                    }
                    if (isSelected) {
                        label.setForeground(new Color(13, 113, 182));
                    } else {
                        label.setForeground(new Color(102, 102, 102));
                    }
                    label.setBackground(Color.WHITE);
                }
                return comp;
            }
        });
    }
}

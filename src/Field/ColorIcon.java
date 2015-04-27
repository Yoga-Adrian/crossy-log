package Field;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class ColorIcon implements Icon {

    Color color;
    int preferredSize = -1;

    private ColorIcon() {
    }

    public ColorIcon(Color color, int preferredSize) {
        this.color = color;
        this.preferredSize = preferredSize;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillRect(0, 0, preferredSize, preferredSize);
    }

    @Override
    public int getIconWidth() {
        return preferredSize;
    }

    @Override
    public int getIconHeight() {
        return preferredSize;
    }
}

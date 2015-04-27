package Field;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.util.Random;

/* Updated by : Vanji
	24 April 2015
 */
public class CheckerBoard {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
		Random random = new Random();
            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                JPanel gui = new JPanel(new BorderLayout());
                gui.setBorder(new EmptyBorder(2, 3, 2, 3));

                int w = 7;
                int h = 12;
                gui.setLayout(new GridLayout(h, w, 0, 0));
				JLabel labels[] = new JLabel[(h*w)];
                for (int i = 0; i < 12; i++) {
					int GroundWater = random.nextInt(2) + 1;
					if (GroundWater == 2) {
						Water water = new Water();
						for (int j = 0; j < water.getFieldSize(); j++) {
							if (water.isItem(j))

								{labels[i*7+j]=(new JLabel(new ImageIcon("Log.jpg")));
								gui.add(labels[i*7+j]);}
							else
							{labels[i*7+j]=(new JLabel(new ImageIcon("Water.jpg")));
								gui.add(labels[i*7+j]);}
					}

				} //GroundWater = 2 means Water
					else {
						Ground ground = new Ground();
						for (int j = 0; j < ground.getFieldSize(); j++) {
							if (ground.isItem(j))
							{labels[i*7+j]=(new JLabel(new ImageIcon("Tree.jpg")));
							gui.add(labels[i*7+j]);}
							else
							{labels[i*7+j]=(new JLabel(new ImageIcon("Ground.jpg")));
							gui.add(labels[i*7+j]);}
						}
					}
				}
				//gui.add(labels[1]);
                JFrame f = new JFrame("Crossy Log");
                f.add(gui);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);
                f.pack();
                f.setVisible(true);
            }
        };

        SwingUtilities.invokeLater(r);
    }
}

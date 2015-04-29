package GUI;

import java.awt.event.*;
import javax.swing.*;
import Main.Main;

/**
 * Created by yoga on 4/26/2015.
 */

public class TimerAnimation extends JLabel implements ActionListener
{
    private int i,j;

    public TimerAnimation(
            int startX, int startY,
            int delay, String gambar,int x,int y)
    {
        this.i=x;
        this.j=y;
        setIcon( new ImageIcon(gambar) );
        setSize(50, 50);
        setLocation(startX, startY);
        new javax.swing.Timer(delay, this).start();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (Main.vector.elementAt(i).getClass().getSimpleName().equals("Water")) {
            if (Main.vector.elementAt(i).isItem(j) && j>=0 && j<=6)
                setIcon(new ImageIcon("Log.jpg"));
            else
                setIcon(new ImageIcon("Water.jpg"));
        }
    }
}

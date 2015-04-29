package GUI;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import Main.Main;
import com.sun.deploy.panel.JSmartTextArea;

/**
 * class ScoreGUI
 * kelas ini berguna untuk menampilkan score selama permainan berlangsung
 */

public class ScoreGUI extends JLabel implements ActionListener
{

    /**
     * konstruktor
     * @param delay untuk selang waktu pemrosesan
     */
    public ScoreGUI(
            int delay)
    {

        setText(("score: " + Main.score));
        setSize(100, 50);
        setLocation(0,600);
        new javax.swing.Timer(delay, this).start();
    }
    /**
     *
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {
        setText(("score: "+Main.score));
    }
}

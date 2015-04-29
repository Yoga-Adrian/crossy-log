package Command;
import Char.Karakter;
import Field.*;
import Point.Point;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.*;

/**
 * Created by yoga on 4/26/2015.
 */

        public class TimerAnimation extends JLabel implements ActionListener
        {
            private int deltaX = 2;
            private int deltaY = 3;
            private int directionX = 1;
            private int directionY = 1;
            private static Karakter player;
            private int i,j;

            private static class InputHandler extends KeyAdapter {
                public void keyReleased(KeyEvent e){
                    CommandProcessor action = new CommandProcessor(player);
                    switch(e.getKeyCode()){
                        case KeyEvent.VK_LEFT:
                            action.setCurrentCommand("MoveLeft");
                            action.run();
                            break;
                        case KeyEvent.VK_RIGHT:
                            action.setCurrentCommand("MoveRight");
                            action.run();
                            break;
                        case KeyEvent.VK_UP:
                            action.setCurrentCommand("MoveForward");
                            action.run();
                            break;
                        case KeyEvent.VK_DOWN:
                            action.setCurrentCommand("MoveBackward");
                            action.run();
                            break;
                    }
                    player.setKarakter(action.getCurrentKarakter());
                    System.out.println(player.getCPosition());
                }
            }

            public TimerAnimation(
                    int startX, int startY,
                    int deltaX, int deltaY,
                    int directionX, int directionY,
                    int delay, String gambar,int x,int y)
            {
                this.deltaX = deltaX;
                this.deltaY = deltaY;
                this.directionX = directionX;
                this.directionY = directionY;
                this.i=x;
                this.j=y;
                player = new Karakter("Doge");
                setIcon( new ImageIcon(gambar) );
                setSize(50, 50);
                setLocation(startX, startY);
                new javax.swing.Timer(delay, this).start();
            }

            public void actionPerformed(ActionEvent e)
            {
                Container parent = getParent();

                //  Determine next X position

                //int nextX =nextX;
               /*
                if (nextX < 50)
                {
                    nextX = 350;
                    directionX *= 1;
                }

                if ( nextX > 350)
                {
                    nextX =50;
                    directionX *= 1;
                }
*/
                //  Determine next Y position

                //int nextY =
                 if (karakterthread.vector.elementAt(i).getClass().getSimpleName().equals("Water")) {
                     if (karakterthread.vector.elementAt(i).isItem(j))
                         setIcon(new ImageIcon("Log.jpg"));
                     else
                         setIcon(new ImageIcon("Water.jpg"));
                 }



            }



}



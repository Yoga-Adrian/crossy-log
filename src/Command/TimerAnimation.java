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
                    int delay, String gambar)
            {
                this.deltaX = deltaX;
                this.deltaY = deltaY;
                this.directionX = directionX;
                this.directionY = directionY;
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

                int nextX = getLocation().x + (deltaX * directionX);
                
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

                //  Determine next Y position

                int nextY = getLocation().y + (deltaY * directionY);
                setLocation(nextX, nextY);
            }

    public static void main(String[] args){
        Karakter Doge = new Karakter("Doge");

        Point playerPosition = new Point(4,0);
        Doge.setCPosition(playerPosition);
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.addKeyListener(new InputHandler());

        Random random = new Random();
        Vector<Field> vector = new Vector<>();

        for (int i = 0; i < 12; i++) {
            int GroundWater = random.nextInt(2) + 1;
            if (GroundWater == 2) {
                Water water = new Water();
                vector.add(water);
                vector.elementAt(i).start();
                for (int j=0;j <water.getFieldSize();j++)
                {
                    if (water.isItem(j))
                    {
                        if (water.getDirection())
                            frame.getContentPane().add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 1, 0, 1000,"Log.jpg") );
                        else
                            frame.getContentPane().add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, -1, 0, 1000,"Log.jpg") );
                    }
                    else
                    {
                        if(water.getDirection())
                            frame.getContentPane().add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 1, 0, 1000,"Water.jpg") );
                        else
                            frame.getContentPane().add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, -1, 0, 1000,"Water.jpg") );
                    }
                }
            }
            else {
                Ground ground = new Ground();
                vector.add(ground);
                for (int j=0;j <ground.getFieldSize();j++)
                {
                    if (ground.isItem(j))
                        frame.getContentPane().add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 0, 0, 1000,"Tree.jpg") );
                    else
                        frame.getContentPane().add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 0, 0, 1000,"Ground.jpg") );
                }
            }
        }

        frame.setSize(450,700);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}



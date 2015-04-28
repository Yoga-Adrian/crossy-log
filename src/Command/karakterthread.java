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
 * Created by yoga on 4/28/2015.
 */
public class karakterthread extends JLabel implements ActionListener {

    private int deltaX = 2;
    private int deltaY = 3;
    private int directionX = 1;
    private int directionY = 1;
    public static Karakter player;
    public static Vector<Field> vector;
    public static JFrame frame;

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

    public karakterthread(
            int startX, int startY,
            int deltaX, int deltaY,
            int directionX, int directionY,
            int delay, String gambar,Karakter pl)
    {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.directionX = directionX;
        this.directionY = directionY;
        this.player=pl;

        setIcon( new ImageIcon(gambar) );
        setSize(50, 50);
        setLocation(startX, startY);
        new javax.swing.Timer(delay, this).start();
    }

    public void actionPerformed(ActionEvent e)
    {
        Container parent = getParent();

        //  Determine next X position


        int nextX =((player.getCPosition().getAbsis()+1)*50);


        int nextY =(12-(player.getCPosition().getOrdinat()+1))*50;
        setLocation(nextX, nextY);
    }

    public static void moveMap(){
        karakterthread.vector.remove(0);
        Random random = new Random();
        if(random.nextInt(2)+1 == 1){
            Ground ground = new Ground();
            karakterthread.vector.add(ground);
        } else{
            Water water = new Water();
            karakterthread.vector.add(water);
        }
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add((new karakterthread(player.getCPosition().getAbsis() * 200, 13 * 50, 0, 0, 0, 0, 10, "Doge.jpg", player)));
        for (int i = 0; i < 12; i++) {
            if (vector.elementAt(i).getClass().getSimpleName().equals("Water")) {
                for (int j=0;j <vector.elementAt(i).getFieldSize();j++)
                {
                    if (vector.elementAt(i).isItem(j))
                    {
                        if (vector.elementAt(i).getDirection())
                            panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 1, 0, 1000,"Log.jpg") );
                        else
                            panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, -1, 0, 1000,"Log.jpg") );
                    }
                    else
                    {
                        if(vector.elementAt(i).getDirection())
                            panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 1, 0, 1000,"Water.jpg") );
                        else
                            panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, -1, 0, 1000,"Water.jpg") );
                    }
                }
            }
            else {
                for (int j=0;j <vector.elementAt(i).getFieldSize();j++)
                {
                    if (vector.elementAt(i).isItem(j))
                        panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 0, 0, 1000,"Tree.jpg") );
                    else
                        panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 0, 0, 1000,"Ground.jpg") );
                }
            }
        }
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        Karakter Doge = new Karakter("Doge");

        Point playerPosition = new Point(3,0);
        Doge.setCPosition(playerPosition);
        JPanel panel = new JPanel();
        frame = new JFrame();
        frame.addKeyListener(new InputHandler());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(new karakterthread(600, 13 * 50, 0, 0, 0, 0, 10, "Doge.jpg", Doge));
        System.out.println(player.getCPosition().getAbsis());
        Random random = new Random();
        vector = new Vector<>();

        for (int i = 0; i < 12; i++) {
            int GroundWater = random.nextInt(2) + 1;
            if (GroundWater == 2 && i != 0) {
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
                if(i == 0){
                    for(int k=0; k<ground.getFieldSize(); k++){
                        ground.setItem(k, false);
                    }
                }
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

        frame.setSize(450, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



}

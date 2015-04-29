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

    public static Karakter player;
    public static Vector<Field> vector;
    public static JFrame frame;
    private int deltaX = 2;
    private int deltaY = 3;
    private int directionX = 1;
    private int directionY = 1;

    public karakterthread(
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

        Point playerPosition = new Point(3,0);
        player.setCPosition(playerPosition);
        setIcon( new ImageIcon(gambar) );
        setSize(50, 50);
        setLocation(startX, startY);
        new javax.swing.Timer(delay, this).start();
    }

    public static void moveMap(){

        JPanel panel = new JPanel();
        panel.add(new karakterthread((player.getCPosition().getAbsis()+1)*50, 13 * 50, 0, 0, 0, 0, 10, "Doge.jpg"));
        panel.setLayout(null);
        for (int i = 0; i < 12; i++) {
            if (vector.elementAt(i).getClass().getSimpleName().equals("Water")) {

                for (int j=0;j <vector.elementAt(i).getFieldSize();j++)
                {
                    if (vector.elementAt(i).isItem(j))
                    {
                        if (vector.elementAt(i).getDirection())
                            panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 1, 0, 10,"Log.jpg",i,j) );
                        else
                            panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, -1, 0, 10,"Log.jpg",i,j) );
                    }
                    else
                    {
                        if(vector.elementAt(i).getDirection())
                            panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 1, 0, 10,"Water.jpg",i,j) );
                        else
                            panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, -1, 0, 10,"Water.jpg",i,j) );
                    }
                }
            }
            else {
                for (int j=0;j <vector.elementAt(i).getFieldSize();j++)
                {
                    if (vector.elementAt(i).isItem(j))
                        panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 0, 0, 10,"Tree.jpg",i,j) );
                    else
                        panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 0, 0, 10,"Ground.jpg",i,j) );
                }
            }
        }

        frame.setContentPane(panel);
        frame.setVisible(true);

        for(int i=0; i<12; i++){
            for(int j=0; j<7; j++){
                System.out.print(vector.elementAt(i).isItem(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

        JPanel panel = new JPanel();
        frame = new JFrame();
        frame.addKeyListener(new InputHandler());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(new karakterthread(600, 13 * 50, 0, 0, 0, 0, 10, "Doge.jpg"));

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
                            frame.getContentPane().add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 1, 0, 10,"Log.jpg",i,j) );
                        else
                            frame.getContentPane().add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, -1, 0, 10,"Log.jpg",i,j) );
                    }
                    else
                    {
                        if(water.getDirection())
                            frame.getContentPane().add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 1, 0, 10,"Water.jpg",i,j) );
                        else
                            frame.getContentPane().add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, -1, 0, 10,"Water.jpg",i,j) );
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
                        frame.getContentPane().add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 0, 0, 10,"Tree.jpg",i,j) );
                    else
                        frame.getContentPane().add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 50, 0, 0, 0, 10,"Ground.jpg",i,j) );
                }
            }
        }

        frame.setSize(450, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Container parent = getParent();

        //  Determine next X position


        int nextX =((player.getCPosition().getAbsis()+1)*50);


        int nextY =(12-(player.getCPosition().getOrdinat()+1))*50;
        setLocation(nextX, nextY);
    }

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
            if (vector.elementAt(0).getFieldCode() == 1){
                if (vector.elementAt(0).isItem(player.getCPosition().getAbsis())){
                    player.setStatus(false);
                }
            }
            else{ // Field Code = 2
                if (!vector.elementAt(0).isItem(player.getCPosition().getAbsis())){
                    player.setStatus(false);
                }
            }
            System.out.println(player.getStatus());
        }
    }



}

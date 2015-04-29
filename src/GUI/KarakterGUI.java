package GUI;
import Command.CommandProcessor;
import Field.*;
import Main.Main;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * Created by yoga on 4/28/2015.
 */
public class KarakterGUI extends JLabel implements ActionListener {
    private int deltaX = 2;
    private int deltaY = 3;
    private int directionX = 1;
    private int directionY = 1;


    public KarakterGUI(
            int startX, int startY,
            int deltaX, int deltaY,
            int directionX, int directionY,
            int delay, String gambar)
    {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.directionX = directionX;
        this.directionY = directionY;

        setIcon(new ImageIcon(gambar));
        setSize(50, 50);
        setLocation(startX, startY);
        new javax.swing.Timer(delay, this).start();
    }

    public static void moveMap(){
        JPanel panel = new JPanel();
        panel.add(new KarakterGUI((Main.player.getCPosition().getAbsis() + 1) * 50, 13 * 50, 0, 0, 0, 0, 10, "Doge.jpg"));
        panel.setLayout(null);
        for (int i = 0; i < 12; i++) {
            if (Main.vector.elementAt(i).getClass().getSimpleName().equals("Water")) {
                for (int j=0;j <Main.vector.elementAt(i).getFieldSize();j++) {
                    if (Main.vector.elementAt(i).isItem(j)) {
                        if (Main.vector.elementAt(i).getDirection())
                            panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 10,"Log.jpg",i,j) );
                        else
                            panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 10,"Log.jpg",i,j) );
                    } else {
                        if(Main.vector.elementAt(i).getDirection())
                            panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 10,"Water.jpg",i,j) );
                        else
                            panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 10,"Water.jpg",i,j) );
                    }
                }
            }
            else {
                for (int j=0;j <Main.vector.elementAt(i).getFieldSize();j++) {
                    if (Main.vector.elementAt(i).isItem(j))
                        panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 10,"Tree.jpg",i,j) );
                    else
                        panel.add( new TimerAnimation((j+1)*50, (12-(i+1))*50, 10,"Ground.jpg",i,j) );
                }
            }
        }

        Main.frame.setContentPane(panel);
        Main.frame.setVisible(true);
    }

    public static void newGame(){
        JPanel panel = new JPanel();
        Main.frame.addKeyListener(new InputHandler());
        Main.frame.setContentPane(panel);
        Main.frame.setDefaultCloseOperation(Main.frame.EXIT_ON_CLOSE);
        Main.frame.getContentPane().setLayout(null);
        Main.frame.getContentPane().add(new KarakterGUI(600, 13 * 50, 0, 0, 0, 0, 10, "Doge.jpg"));

        Random random = new Random();

        for (int i = 0; i < 12; i++) {
            int GroundWater = random.nextInt(2) + 1;
            if (GroundWater == 2 && i != 0) {
                Water water = new Water();
                Main.vector.add(water);
                Main.vector.elementAt(i).start();
                for (int j=0;j <water.getFieldSize();j++) {
                    if (water.isItem(j)) {
                        if (water.getDirection())
                            Main.frame.getContentPane().add(new TimerAnimation((j+1)*50, (12-(i+1))*50, 10, "Log.jpg", i, j));
                        else
                            Main.frame.getContentPane().add(new TimerAnimation((j+1)*50, (12-(i+1))*50, 10, "Log.jpg", i, j));
                    } else {
                        if(water.getDirection())
                            Main.frame.getContentPane().add(new TimerAnimation((j+1)*50, (12-(i+1))*50, 10, "Water.jpg", i, j));
                        else
                            Main.frame.getContentPane().add(new TimerAnimation((j+1)*50, (12-(i+1))*50, 10, "Water.jpg", i, j));
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
                Main.vector.add(ground);
                for (int j=0;j <ground.getFieldSize();j++) {
                    if (ground.isItem(j))
                        Main.frame.getContentPane().add(new TimerAnimation((j+1)*50, (12-(i+1))*50, 10, "Tree.jpg", i, j));
                    else
                        Main.frame.getContentPane().add(new TimerAnimation((j+1)*50, (12-(i+1))*50, 10, "Ground.jpg", i, j));
                }
            }
        }

        Main.frame.setSize(450, 700);
        Main.frame.setResizable(false);
        Main.frame.setLocationRelativeTo(null);
        Main.frame.setVisible(true);
    }

    public void showGameOver(){
        JPanel panel = new JPanel();
        Main.frame = new JFrame();
        Main.frame.addKeyListener(new InputHandler());
        Main.frame.setContentPane(panel);
        Main.frame.setDefaultCloseOperation(Main.frame.EXIT_ON_CLOSE);
        Main.frame.getContentPane().setLayout(null);
    }

    public void actionPerformed(ActionEvent e) {
        //  Determine next X position
        int nextX =((Main.player.getCPosition().getAbsis()+1)*50);

        int nextY =(12-(Main.player.getCPosition().getOrdinat()+1))*50;
        setLocation(nextX, nextY);
    }

    private static class InputHandler extends KeyAdapter {
        public void keyReleased(KeyEvent e){
            CommandProcessor action = new CommandProcessor();
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
            if (Main.vector.elementAt(0).getClass().getSimpleName().equals("Ground")){
                if (Main.vector.elementAt(0).isItem(Main.player.getCPosition().getAbsis())){
                    Main.player.setStatus(false);
                }
            } else if (!Main.vector.elementAt(0).isItem(Main.player.getCPosition().getAbsis())){
                    Main.player.setStatus(false);
            }
        }
    }



}

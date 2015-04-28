package Command;

import Char.Karakter;
import Field.*;
import Point.Point;

/*import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

/**
 * Created by yoga on 4/28/2015.
 */
/*public class Main extends JLabel {
    private static class InputHandler extends KeyAdapter {
        public void keyReleased(KeyEvent e){
            CommandProcessor action = new CommandProcessor(karakterthread.player);
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
            karakterthread.player.setKarakter(action.getCurrentKarakter());
            System.out.println(karakterthread.player.getCPosition());
        }
    }
    public static void main(String[] args){
        Karakter Doge = new Karakter("Doge");

        Point playerPosition = new Point(4,0);
        Doge.setCPosition(playerPosition);
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.addKeyListener(new InputHandler());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(new karakterthread(600, 13 * 50, 0, 0, 0, 0, 10, "Doge.jpg",Doge));
        System.out.println(karakterthread.player.getCPosition().getAbsis());
        Random random = new Random();
        Vector<Field> vector = new Vector<>();

        for (int i = 0; i < 12; i++) {
            int GroundWater = random.nextInt(2) + 1;
            if (GroundWater == 2) {
                Field.Water water = new Field.Water();
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
                Field.Ground ground = new Field.Ground();
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
*/
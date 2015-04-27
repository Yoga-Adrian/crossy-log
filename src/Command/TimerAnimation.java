package Command;
import Field.*;

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
            int deltaX = 2;
            int deltaY = 3;
            int directionX = 1;
            int directionY = 1;

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

            public static void main(String[] args)
            {
                JPanel panel = new JPanel();
                JFrame frame = new JFrame();

                frame.setContentPane(panel);
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                frame.getContentPane().setLayout(null);

                    Random random = new Random();
                    Vector<Field> vector = new Vector<>();

                    for (int i = 0; i < 12; i++) {
                        int GroundWater = random.nextInt(2) + 1;
                        if (GroundWater == 2) {
                            Water water = new Water();
                            vector.add(water);
                            for (int j=0;j <water.getFieldSize();j++)
                            {
                                if (water.isItem(j))
                                {
                                    if (water.getDirection())
                                        frame.getContentPane().add( new TimerAnimation((j+1)*50, (i+1)*50, 50, 0, 1, 0, 500,"Log.jpg") );
                                    else
                                        frame.getContentPane().add( new TimerAnimation((j+1)*50, (i+1)*50, 50, 0, -1, 0, 500,"Log.jpg") );
                                }
                                else
                                {
                                    if(water.getDirection())
                                        frame.getContentPane().add( new TimerAnimation((j+1)*50, (i+1)*50, 50, 0, 1, 0, 500,"Water.jpg") );
                                    else
                                        frame.getContentPane().add( new TimerAnimation((j+1)*50, (i+1)*50, 50, 0, -1, 0, 500,"Water.jpg") );
                                }
                            }
                        }
                        else {
                            Ground ground = new Ground();
                            vector.add(ground);
                            for (int j=0;j <ground.getFieldSize();j++)
                            {
                                if (ground.isItem(j))
                                    frame.getContentPane().add( new TimerAnimation((j+1)*50, (i+1)*50, 50, 0, 0, 0, 500,"Tree.jpg") );
                                else
                                    frame.getContentPane().add( new TimerAnimation((j+1)*50, (i+1)*50, 50, 0, 0, 0, 500,"Ground.jpg") );
                            }
                        }
                    }

                    for(int i=0; i<vector.size(); i++){
                        System.out.print(vector.elementAt(i));
                        if(vector.elementAt(i).getFieldCode() == 1)
                            System.out.println(" Ground");
                        else
                            System.out.println(" Water");
                    }



/*                    Scanner scanner = new Scanner(System.in);
                    CommandProcessor Action = new CommandProcessor();
                    String command = "";
                    command = scanner.nextLine();
                    while(!command.toLowerCase().equals("exit")){
                        Action.setCurrentCommand(command);
                        Action.run();
                        System.out.println(Action.getCurrentKarakter().getCPosition());
                        command = scanner.nextLine();
                    }
  */


                frame.setSize(450,700);
                frame.setLocationRelativeTo( null );
                frame.setVisible(true);

            }
        }



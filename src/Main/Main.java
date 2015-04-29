package Main;

import Char.Karakter;
import Field.Field;
import Point.Point;
import javax.swing.*;
import java.util.Vector;

public class Main {
    public static Karakter player;
    public static Vector<Field> vector;
    public static JFrame frame;

    public static void main(String[] args){
        player = new Karakter("Doge");
        Point playerPosition = new Point(3,0);
        player.setCPosition(playerPosition);

        vector = new Vector<>();
        frame = new JFrame();
        GUI.KarakterGUI.newGame();
    }


}

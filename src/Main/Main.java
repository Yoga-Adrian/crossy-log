package Main;

import Char.Karakter;
import Field.Field;
import Point.Point;
import javax.swing.*;
import java.util.Vector;

/** <h1> Crossy Log </h1>
 *  @author Yoga Adrian / 13513030
 *  @author Levanji Prahyudy Mudjono / 13513052
 *  @author Octavianus Marcel Harjono / 13513056
 *  @version 1.0
 */

/**
 * class Main
 * Kelas ini memrupakan kelas main utama dan mempunyai
 * atribut static Karakter, Vector of Field, dan JFrame
 */

public class Main {
    public static Karakter player;
    public static Vector<Field> vector;
    public static JFrame frame;
    public static int score=0;

    public static void main(String[] args){

        player = new Karakter("Doge");
        Point playerPosition = new Point(3,0);
        player.setCPosition(playerPosition);
        vector = new Vector<>();
        frame = new JFrame();
        GUI.KarakterGUI.newGame();
    }
}

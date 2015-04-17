package Command;

import Char.Karakter;
import Point.Point;

/**
 * Created by omarcelh on 13-Apr-15.
 */
public class MoveForward implements Command {
    private Karakter currentPlayer;
    public MoveForward(Karakter Player){
        currentPlayer = new Karakter(Player);
    }

    public void execute(){
        Point newPosition = new Point(currentPlayer.getCPosition().getAbsis(), currentPlayer.getCPosition().getOrdinat() + 1);
        currentPlayer.setCPosition(newPosition);
    }
}

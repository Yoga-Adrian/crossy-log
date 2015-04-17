package Command;

import Char.Karakter;
import Point.Point;

/**
 * Created by omarcelh on 13-Apr-15.
 */
public class MoveBackward implements Command {
    private Karakter currentPlayer;
    public MoveBackward(Karakter Player){
        currentPlayer = new Karakter(Player);
    }

    public void execute(){
        Point newPosition = new Point(currentPlayer.getCPosition().getAbsis(), currentPlayer.getCPosition().getOrdinat() - 1);
        currentPlayer.setCPosition(newPosition);
    }
}

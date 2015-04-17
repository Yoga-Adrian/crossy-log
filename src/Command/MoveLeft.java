package Command;

import Char.Karakter;
import Point.Point;

/**
 * Created by omarcelh on 13-Apr-15.
 */
public class MoveLeft implements Command {
    private Karakter currentPlayer;
    public MoveLeft(Karakter Player){
        currentPlayer = new Karakter(Player);
    }

    public void execute(){
        Point newPosition = new Point(currentPlayer.getCPosition().getAbsis() - 1, currentPlayer.getCPosition().getOrdinat());
        currentPlayer.setCPosition(newPosition);
    }
}

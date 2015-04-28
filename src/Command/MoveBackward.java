package Command;

import Char.Karakter;
import Point.Point;

import java.awt.event.KeyEvent;

/**
 * Created by omarcelh on 13-Apr-15.
 */
public class MoveBackward implements Command {
    private Karakter currentPlayer;

    public MoveBackward(Karakter Player){
        currentPlayer = new Karakter(Player);
    }

    public Karakter getCurrentPlayer(){
        return currentPlayer;
    }

    public void setCurrentPlayer(Karakter _currentPlayer){
        currentPlayer.setName(_currentPlayer.getName());
        currentPlayer.setStatus(_currentPlayer.getStatus());
        currentPlayer.setCPosition(_currentPlayer.getCPosition());
    }

    public void execute(){
        currentPlayer.keyReleased(KeyEvent.VK_DOWN);
    }
}

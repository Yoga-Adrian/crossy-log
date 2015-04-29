package Command;

import Main.Main;
import java.awt.event.KeyEvent;

/**
 * Created by omarcelh on 13-Apr-15.
 */
public class MoveLeft implements Command {
    public MoveLeft(){

    }

    public void execute(){
        Main.player.keyReleased(KeyEvent.VK_LEFT);
    }
}

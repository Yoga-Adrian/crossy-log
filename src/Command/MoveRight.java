package Command;

import Main.Main;
import java.awt.event.KeyEvent;

/**
 * Created by omarcelh on 13-Apr-15.
 */
public class MoveRight implements Command{
    public MoveRight(){
    }

    public void execute(){
        Main.player.keyReleased(KeyEvent.VK_RIGHT);
    }
}

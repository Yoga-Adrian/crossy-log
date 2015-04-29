package Command;

import Main.Main;
import java.awt.event.KeyEvent;

/**
 * class MoveBackward
 * mengimplementasi method dari interface Command
 */
public class MoveBackward implements Command {
    /**
     * Konstruktor
     */
    public MoveBackward(){

    }

    /**
     * Method execute
     * Menjalankan action MoveBackward
     */
    public void execute(){
        Main.player.keyReleased(KeyEvent.VK_DOWN);
    }
}

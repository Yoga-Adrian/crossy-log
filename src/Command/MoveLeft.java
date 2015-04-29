package Command;

import Main.Main;
import java.awt.event.KeyEvent;

/**
 * class MoveLeft
 * mengimplementasi method dari interface Command
 */
public class MoveLeft implements Command {
    /**
     * Konstruktor
     */
    public MoveLeft(){

    }

    /**
     * Method execute
     * Menjalankan action MoveLeft
     */
    public void execute(){
        Main.player.keyReleased(KeyEvent.VK_LEFT);
    }
}

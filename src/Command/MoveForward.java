package Command;

import Main.Main;
import java.awt.event.KeyEvent;

/**
 * class MoveForward
 * yang mengimplementasi interface Command
 */
public class MoveForward implements Command {
    /**
     * Konstruktor
     */
    public MoveForward() {
    }

    /**
     * Method execute
     * Menjalankan action MoveForward
     */
    public void execute(){
        Main.player.keyReleased(KeyEvent.VK_UP);
    }
}

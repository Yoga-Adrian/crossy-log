package Command;

import Main.Main;
import java.awt.event.KeyEvent;

/**
 * class MoveRight
 * mengimplementasi method dari interface Command
 */
public class MoveRight implements Command{
    /**
     * Konstruktor
     */
    public MoveRight(){
    }

    /**
     * Method execute
     * Menjalankan action MoveRight
     */
    public void execute(){
        Main.player.keyReleased(KeyEvent.VK_RIGHT);
    }
}

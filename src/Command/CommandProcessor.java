package Command;

import Char.Karakter;

/**
 * Created by omarcelh on 13-Apr-15.
 */
public class CommandProcessor {
    private String currentCommand;
    private Karakter currentKarakter;

    public CommandProcessor(final Karakter player){
        currentCommand = "";
        currentKarakter = new Karakter(player);
    }

    public String getCurrentCommand(){
        return currentCommand;
    }
    
    public void setCurrentCommand(String _currentCommand){
        currentCommand = _currentCommand;
    }

    public void run(){
        switch(currentCommand){
            case "MoveRight":{
                MoveRight action = new MoveRight(currentKarakter);
                action.execute();
                break;}
            case "MoveLeft":{
                MoveLeft action = new MoveLeft(currentKarakter);
                action.execute();
                break;}
            case "MoveForward":{
                MoveForward action = new MoveForward(currentKarakter);
                action.execute();
                break;}
            case "MoveBackward":{
                MoveBackward action = new MoveBackward(currentKarakter);
                action.execute();
                break;}
            case "Load":{
                Load action = new Load();
                action.execute();
                break;}
            case "Save":{
                Save action = new Save();
                action.execute();
                break;}
            case "AllObjectMover":{
                AllObjectMover action = new AllObjectMover();
                action.execute();
                break;}
        }
    }
}


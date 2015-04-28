package Command;

import Char.Karakter;
import Point.Point;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by omarcelh on 13-Apr-15.
 */
public class CommandProcessor {
    private String currentCommand;
    private Karakter currentKarakter;

    public CommandProcessor(){
        currentCommand = "";
        currentKarakter = new Karakter("Doge");
    }

    public CommandProcessor(final Karakter player){
        currentCommand = "";
        currentKarakter = new Karakter(player);
    }

    public Karakter getCurrentKarakter(){
        return currentKarakter;
    }

    public void setCurrentKarakter(Karakter _currentKarakter){
        currentKarakter.setName(_currentKarakter.getName());
        currentKarakter.setStatus(_currentKarakter.getStatus());
        currentKarakter.setCPosition(_currentKarakter.getCPosition());
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
                this.setCurrentKarakter(action.getCurrentPlayer());
                break;}
            case "MoveLeft":{
                MoveLeft action = new MoveLeft(currentKarakter);
                action.execute();
                this.setCurrentKarakter(action.getCurrentPlayer());
                break;}
            case "MoveForward":{
                MoveForward action = new MoveForward(currentKarakter);
                action.execute();
                this.setCurrentKarakter(action.getCurrentPlayer());
                break;}
            case "MoveBackward":{
                MoveBackward action = new MoveBackward(currentKarakter);
                action.execute();
                this.setCurrentKarakter(action.getCurrentPlayer());
                break;}
            case "Load":{
                Load action = new Load();
                action.execute();
                break;}
            case "Save":{
                Save action = new Save();
                action.execute();
                break;}
            default:{
                if(!currentCommand.toLowerCase().equals("exit")){
                    System.out.println("Syntax Error");
                }
                break;}
        }
    }
}


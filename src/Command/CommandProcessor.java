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

    public CommandProcessor(){
        currentCommand = "";
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
                MoveRight action = new MoveRight();
                action.execute();
                break;}
            case "MoveLeft":{
                MoveLeft action = new MoveLeft();
                action.execute();
                break;}
            case "MoveForward":{
                MoveForward action = new MoveForward();
                action.execute();
                break;}
            case "MoveBackward":{
                MoveBackward action = new MoveBackward();
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


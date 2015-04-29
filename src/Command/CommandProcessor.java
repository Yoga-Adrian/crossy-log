package Command;

/**
 * class CommandProcessor
 * kelas ini menghandle seluruh input dari player
 */
public class CommandProcessor {
    private String currentCommand;

    /**
     * Konstruktor CommandProcessor
     */
    public CommandProcessor(){
        currentCommand = "";
    }

    /**
     * Method getCurrentCommand
     * @return string command sekarang
     */
    public String getCurrentCommand(){
        return currentCommand;
    }

    /**
     * Method setCurrentCommand
     * @param _currentCommand command baru
     */
    public void setCurrentCommand(String _currentCommand){
        currentCommand = _currentCommand;
    }

    /**
     * Method run
     * Menjalankan action dari command sekarang
     */
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


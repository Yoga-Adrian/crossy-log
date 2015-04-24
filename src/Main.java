import Char.*;
import Command.*;
import Field.*;
import Point.*;
import java.util.*;

public class    Main {
    public static void main(String[] args){
        Random random = new Random();
        Vector<Field> vector = new Vector<>();

        for (int i = 0; i < 12; i++) {
            int GroundWater = random.nextInt(2) + 1;
            if (GroundWater == 2) {
                Water water = new Water();
                vector.add(water);
            }
            else {
                Ground ground = new Ground();
                vector.add(ground);
            }
        }

        for(int i=0; i<vector.size(); i++){
            System.out.print(vector.elementAt(i));
            if(vector.elementAt(i).getFieldCode() == 1)
                System.out.println(" Ground");
            else
                System.out.println(" Water");
        }



        Scanner scanner = new Scanner(System.in);
        CommandProcessor Action = new CommandProcessor();
        String command = "";
        command = scanner.nextLine();
        while(!command.toLowerCase().equals("exit")){
            Action.setCurrentCommand(command);
            Action.run();
            System.out.println(Action.getCurrentKarakter().getCPosition());
            command = scanner.nextLine();
        }
    }
}

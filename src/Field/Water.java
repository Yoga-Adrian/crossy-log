package Field;

import Point.Point;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author yoga
 */
 
public class Water extends Field {
    public Water(){
		super(2);
        item = new Vector<>(fieldSize);
        for(int i=0; i<fieldSize; i++){
            item.add(false);
        }
        this.generateRandom();
	}
    
    public Water(Point P){
        super(2, P);
        item = new Vector<>(fieldSize);
        for(int i=0; i<fieldSize; i++){
            item.add(false);
        }
        this.generateRandom();
    }


    public void generateRandom(){
        Random random = new Random();
        int numOfTrees = random.nextInt(fieldSize/2) + 2;
        while(numOfTrees!=0){
            int randomPosition = random.nextInt(fieldSize);
            if(!isItem(randomPosition)){
                this.setItem(randomPosition, true);
                numOfTrees--;
            }
        }
    }

    public void moveField(){
        boolean temp = item.remove(0);
        item.add(temp);
    }

    @Override
    public String toString() {
        String ret = "";
        for(int i=0; i<item.size(); i++){
            if(item.elementAt(i))
                ret += "1 ";
            else
                ret += "0 ";
        }
        return ret;
    }
}


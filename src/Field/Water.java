package Field;

import Point.Point;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author yoga
 */
 
public class Water extends Field {
    private Vector<Boolean> log;

    public Water(){
		super(2);
        log = new Vector<>(fieldSize);
        for(int i=0; i<fieldSize; i++){
            log.add(false);
        }
        this.generateLog();
	}
    
    public Water(Point P){
        super(2, P);
        log = new Vector<>(fieldSize);
        for(int i=0; i<fieldSize; i++){
            log.add(false);
        }
        this.generateLog();
    }

    public boolean isLog(int index){ return log.elementAt(index); }

    public void setLog(int index, boolean _log) { log.setElementAt(_log, index);}

    public void generateLog(){
        Random random = new Random();
        int numOfTrees = random.nextInt(fieldSize/2) + 1;
        while(numOfTrees!=0){
            int randomPosition = random.nextInt(fieldSize);
            if(!isLog(randomPosition)){
                this.setLog(randomPosition, true);
                numOfTrees--;
            }
        }
    }

    public void moveField(){
        boolean temp = log.remove(0);
        log.add(temp);
    }
}


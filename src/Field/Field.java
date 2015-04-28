package Field;

import Command.karakterthread;
import Point.Point;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author yoga
 */

public abstract class Field extends Thread {
    protected int fieldCode;
    protected int fieldSize;
    static protected boolean direction=true;
    protected Vector<Boolean> item;

	public Field(int _fieldCode){
		fieldCode = _fieldCode;
		fieldSize = 7;
        Random random = new Random();
        direction = !direction;
        item = new Vector<>(fieldSize);
	}
	
    public Field(int _fieldCode, Point _position){
		fieldCode = _fieldCode;
		fieldSize = 7;
        Random random = new Random();
        direction= !direction;
        item = new Vector<>(fieldSize);
	}

    public void run()
    {
        while (true) {
            for(int i=0; i<12; i++) {
                if(karakterthread.vector.elementAt(i).getClass().getSimpleName().equals("Water")) {
                    karakterthread.vector.elementAt(i).moveField(direction);
                }
            }

            try {
                sleep (1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean getDirection(){return direction;}

    public int getFieldCode(){
        return fieldCode;
    }

	public int getFieldSize() { return fieldSize; }

	public void setFieldSize(int _fieldSize) { fieldSize = _fieldSize; }

    public abstract void generateRandom();

    public void moveField(boolean rdirection){
        if(rdirection) {
            boolean temp = item.remove(0);
            item.add(temp);
        } else {
            boolean temp = item.remove(this.getFieldSize()-1);
            item.add(0, temp);
        }
    }

    public boolean isItem(int index){
        return item.elementAt(index);
    }

    public void setItem(int index, boolean _item) { item.setElementAt(_item, index);}

}


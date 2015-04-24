package Field;

import Point.Point;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author yoga
 */

public abstract class Field {
    protected int fieldCode;
    protected int fieldSize;
    protected int direction;
    protected Vector<Boolean> item;

	public Field(int _fieldCode){
		fieldCode = _fieldCode;
		fieldSize = 7;
        Random random = new Random();
        direction = random.nextInt(1);
        item = new Vector<>(fieldSize);
	}
	
    public Field(int _fieldCode, Point _position){
		fieldCode = _fieldCode;
		fieldSize = 7;
        Random random = new Random();
        direction = random.nextInt(1);
        item = new Vector<>(fieldSize);
	}

    
    public int getFieldCode(){
        return fieldCode;
    }

	public int getFieldSize() { return fieldSize; }

	public void setFieldSize(int _fieldSize) { fieldSize = _fieldSize; }

    public abstract void generateRandom();

    public boolean isItem(int index){
        return item.elementAt(index);
    }

    public void setItem(int index, boolean _item) { item.setElementAt(_item, index);}

}


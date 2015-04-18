package Field;

import Point.Point;

import java.util.Random;

/**
 *
 * @author yoga
 */

public abstract class Field {
    protected int fieldCode;
    protected Point position;
    protected int fieldSize;
    protected int direction;

	public Field(int _fieldCode){
		fieldCode = _fieldCode;
		position = new Point();
		fieldSize = 7;
        Random random = new Random();
        direction = random.nextInt(1);
	}
	
    public Field(int _fieldCode, Point _position){
		fieldCode = _fieldCode;
		position = new Point(_position);
		fieldSize = 7;
        Random random = new Random();
        direction = random.nextInt(1);
	}
    
    public Point getPosition(){
        return position;
    }
    
    public void setPoint(Point P){
        position.setAbsis(P.getAbsis());
        position.setOrdinat(P.getOrdinat());
    }
    
    public int getFieldCode(){
        return fieldCode;
    }

	public int getFieldSize() { return fieldSize; }

	public void setFieldSize(int _fieldSize) { fieldSize = _fieldSize; }

}


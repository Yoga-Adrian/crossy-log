package Field;

import Point.Point;

/**
 *
 * @author yoga
 */

public abstract class Field {
    protected int fieldCode;
    protected Point position;
    
	public Field(int _fieldCode){
		fieldCode = _fieldCode;
		position = new Point();
	}
	
    public Field(int _fieldCode, Point _position){
		fieldCode = _fieldCode;
		position = new Point(_position);
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
    
    /*public static void main(String[] args){
		Point P = new Point(1,2);
		Field F1 = new Ground(P);
		P.setAbsis(2);
		Field F2 = new Log(P);
		P.setOrdinat(3);
		Field F3 = new Water(P);
		
		System.out.println(F1.getFieldCode() + " " + F1.getPosition());
		System.out.println(F2.getFieldCode() + " " + F2.getPosition());
		System.out.println(F3.getFieldCode() + " " + F3.getPosition());
		
	}*/
}


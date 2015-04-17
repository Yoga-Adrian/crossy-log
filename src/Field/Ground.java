package Field;

import Point.Point;


public class Ground extends Field{
    public Ground(){
		super(1);
	}
	
    public Ground(Point P){
		super(1, P);
    }
}

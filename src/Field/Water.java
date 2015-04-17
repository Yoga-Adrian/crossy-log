package Field;

import Point.Point;

/**
 *
 * @author yoga
 */
 
public class Water extends Field {
    public Water(){
		super(3);
	}
    
    public Water(Point P){
        super(3, P);
    }
}


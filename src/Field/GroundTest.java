package Field;

import junit.framework.TestCase;
import Point.Point;

/**
 * Created by omarcelh on 18-Apr-15.
 */
public class GroundTest extends TestCase {

    public void testIsTree() throws Exception {
        Ground instance = new Ground();
        instance.setTree(0, true);
        assertTrue("error di isTree", instance.isTree(0));
    }

    public void testSetTree() throws Exception {
        Ground instance = new Ground();
        instance.setTree(0, true);
        assertTrue("error di setTree", instance.isTree(0));
    }

    public void testGenerateTree() throws Exception {
        Ground instance = new Ground();
        int counter = 0;
        for(int i=0; i<instance.getFieldSize(); i++){
            if(instance.isTree(i))
                counter++;
        }
        assertTrue("error di generateTree", counter >=1 && counter <= instance.getFieldSize()/2);
    }

    public void testMoveField() throws Exception {
        Ground instance = new Ground();
        boolean first = instance.isTree(0);
        instance.moveField();
        boolean last = instance.isTree(instance.getFieldSize()-1);
        assertEquals("error di moveField", first, last);
    }

    public void testGetPosition() throws Exception {
        Point P = new Point(2, 3);
        Ground instance = new Ground(P);
        assertEquals("error di getPosition", P.getAbsis(), instance.getPosition().getAbsis());
        assertEquals("error di getPosition", P.getOrdinat(), instance.getPosition().getOrdinat());
    }

    public void testSetPoint() throws Exception {
        Ground instance = new Ground();
        Point P = new Point(3, 4);
        instance.setPoint(P);
        assertEquals("error di setPosition", P.getAbsis(), instance.getPosition().getAbsis());
        assertEquals("error di setPosition", P.getOrdinat(), instance.getPosition().getOrdinat());
    }

    public void testGetFieldCode() throws Exception {
        Ground instance = new Ground();
        assertEquals("error di getFieldCode", 1, instance.getFieldCode());
    }

    public void testGetFieldSize() throws Exception {
        Ground instance = new Ground();
        assertEquals("error di getFieldSize", instance.getFieldSize(), 7);
    }

    public void testSetFieldSize() throws Exception {
        Ground instance = new Ground();
        instance.setFieldSize(11);
        assertEquals("error di getFieldSize", instance.getFieldSize(), 11);
    }
}
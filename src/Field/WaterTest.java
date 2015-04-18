package Field;

import junit.framework.TestCase;
import Point.Point;

/**
 * Created by omarcelh on 18-Apr-15.
 */
public class WaterTest extends TestCase {

    public void testIsLog() throws Exception {
        Water instance = new Water();
        instance.setLog(0, true);
        assertTrue("error di isLog", instance.isLog(0));
    }

    public void testSetLog() throws Exception {
        Water instance = new Water();
        instance.setLog(0, true);
        assertTrue("error di setLog", instance.isLog(0));
    }

    public void testGenerateLog() throws Exception {
        Water instance = new Water();
        int counter = 0;
        for(int i=0; i<instance.getFieldSize(); i++){
            if(instance.isLog(i))
                counter++;
        }
        assertTrue("error di generateLog", counter >=1 && counter <= instance.getFieldSize()/2);
    }

    public void testMoveField() throws Exception {
        Water instance = new Water();
        boolean first = instance.isLog(0);
        instance.moveField();
        boolean last = instance.isLog(instance.getFieldSize()-1);
        assertEquals("error di moveField", first, last);
    }

    public void testGetPosition() throws Exception {
        Point P = new Point(2, 3);
        Water instance = new Water(P);
        assertEquals("error di getPosition", P.getAbsis(), instance.getPosition().getAbsis());
        assertEquals("error di getPosition", P.getOrdinat(), instance.getPosition().getOrdinat());
    }

    public void testSetPoint() throws Exception {
        Water instance = new Water();
        Point P = new Point(3, 4);
        instance.setPoint(P);
        assertEquals("error di setPosition", P.getAbsis(), instance.getPosition().getAbsis());
        assertEquals("error di setPosition", P.getOrdinat(), instance.getPosition().getOrdinat());
    }

    public void testGetFieldCode() throws Exception {
        Water instance = new Water();
        assertEquals("error di getFieldCode", 1, instance.getFieldCode());
    }

    public void testGetFieldSize() throws Exception {
        Water instance = new Water();
        assertEquals("error di getFieldSize", instance.getFieldSize(), 7);
    }

    public void testSetFieldSize() throws Exception {
        Water instance = new Water();
        instance.setFieldSize(11);
        assertEquals("error di getFieldSize", instance.getFieldSize(), 11);
    }
}
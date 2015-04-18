package Field;

import Point.Point;
import junit.framework.TestCase;

/**
 * Created by omarcelh on 13-Apr-15.
 */
public class WaterTest extends TestCase {

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
        assertEquals("error di getFieldCode", 2, instance.getFieldCode());
    }

    public void testIsLog() throws Exception {

    }

    public void testSetLog() throws Exception {

    }

    public void testGenerateLog() throws Exception {

    }

    public void testMoveField() throws Exception {

    }
}
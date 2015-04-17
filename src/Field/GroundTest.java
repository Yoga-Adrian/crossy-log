package Field;

import junit.framework.TestCase;
import Point.Point;

/**
 * Created by omarcelh on 13-Apr-15.
 */
public class GroundTest extends TestCase {

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
}
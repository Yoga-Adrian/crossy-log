package Field;

import junit.framework.TestCase;
import Point.Point;

public class WaterTest extends TestCase {

    public void testIsItem() throws Exception {
        Water instance = new Water();
        instance.setItem(0, true);
        assertTrue("error di isItem", instance.isItem(0));
    }

    public void testSetLog() throws Exception {
        Water instance = new Water();
        instance.setItem(0, true);
        assertTrue("error di setItem", instance.isItem(0));
    }

    public void testGenerateLog() throws Exception {
        Water instance = new Water();
        int counter = 0;
        for(int i=0; i<instance.getFieldSize(); i++){
            if(instance.isItem(i))
                counter++;
        }
        assertTrue("error di generateLog", counter >= 1 && counter <= instance.getFieldSize() / 2);
    }

    public void testMoveField() throws Exception {
        Water instance = new Water();
        boolean first = instance.isItem(0);
        instance.moveField();
        boolean last = instance.isItem(instance.getFieldSize()-1);
        assertEquals("error di moveField", first, last);
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
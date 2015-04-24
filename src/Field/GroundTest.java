package Field;

import junit.framework.TestCase;
import Point.Point;

/**
 * Created by omarcelh on 18-Apr-15.
 */
public class GroundTest extends TestCase {

    public void testIsTree() throws Exception {
        Ground instance = new Ground();
        instance.setItem(0, true);
        assertTrue("error di isItem", instance.isItem(0));
    }

    public void testSetTree() throws Exception {
        Ground instance = new Ground();
        instance.setItem(0, true);
        assertTrue("error di setItem", instance.isItem(0));
    }

    public void testGenerateTree() throws Exception {
        Ground instance = new Ground();
        int counter = 0;
        for(int i=0; i<instance.getFieldSize(); i++){
            if(instance.isItem(i))
                counter++;
        }
        assertTrue("error di generateTree", counter >=1 && counter <= instance.getFieldSize()/2);
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
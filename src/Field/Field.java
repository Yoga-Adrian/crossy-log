package Field;

import Command.karakterthread;
import Point.Point;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author yoga
 */

public abstract class Field extends Thread {
    static protected boolean direction=true;
    protected int fieldCode;
    protected int fieldSize;
    private static boolean lock;
    protected boolean rdirection;
    protected Vector<Boolean> item;
    private boolean run=true;
	public Field(int _fieldCode){
		fieldCode = _fieldCode;
		fieldSize = 7;
        Random random = new Random();
        rdirection=direction;
        direction = !direction;
        item = new Vector<>(fieldSize);
	}
	
    public Field(int _fieldCode, Point _position){
		fieldCode = _fieldCode;
		fieldSize = 7;
        Random random = new Random();
        rdirection=direction;
        direction= !direction;
        item = new Vector<>(fieldSize);
	}

    public void run()
    {

        while (run && karakterthread.player.getStatus()) {

                this.moveField(rdirection);
           if (karakterthread.vector.elementAt(0).getClass().getSimpleName().equals("Water") && this==karakterthread.vector.elementAt(0))
            {
                if (!karakterthread.vector.elementAt(0).getDirection())
                {
                    int x=karakterthread.player.getCPosition().getAbsis()+1;
                    if (x>6)
                        x=0;
                    karakterthread.player.setCPosition(x,karakterthread.player.getCPosition().getOrdinat());
                }
                else
                {
                    int x=karakterthread.player.getCPosition().getAbsis()-1;
                    if (x<0)
                        x=6;
                    karakterthread.player.setCPosition(x,karakterthread.player.getCPosition().getOrdinat());
                }

            }

            try {
                sleep(1000);
                System.out.print(karakterthread.player.getCPosition());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stopthread()
    {
        this.run=false;

    }
    public boolean getDirection(){return rdirection;}

    public int getFieldCode(){
        return fieldCode;
    }

	public int getFieldSize() { return fieldSize; }

	public void setFieldSize(int _fieldSize) { fieldSize = _fieldSize; }

    public abstract void generateRandom();

    public void moveField(boolean rdirection){
        if(rdirection) {
            boolean temp = item.remove(0);
            item.add(temp);
        } else {
            boolean temp = item.remove(this.getFieldSize()-1);
            item.add(0, temp);
        }
    }

    public boolean isItem(int index){
        return item.elementAt(index);
    }

    public void setItem(int index, boolean _item) { item.setElementAt(_item, index);}

}


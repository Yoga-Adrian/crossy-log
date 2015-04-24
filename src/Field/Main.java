package Field;

/**
 * Created by Vanji on 4/18/2015.
 */

import Field.Ground;
import Field.Water;

import java.lang.reflect.*;
import java.util.*;

import java.util.Random;

public class Main{
    public static void main (String args[]) {
        Random random = new Random();
        try{
        Ground gr = new Ground();
        Vector<Object> vector=new Vector<>();
        vector.add(new Ground());
        String abc="auuu";
        Class cl=Class.forName("Field.Ground");
        Object retobj = cl.newInstance();
        retobj.getClass();
        System.out.print(retobj.getClass());
}
        catch (Throwable e){}
        // vector.elementAt(0)=Class.forName(gr).newInstance();
        for (int i = 0; i < 12; i++) {
            int GroundWater = random.nextInt(2) + 1;
            if (GroundWater == 2) {
                Water water = new Water();
                for (int j = 0; j < water.getFieldSize(); j++) {
                    if (water.isLog(j))
                        System.out.print("1 ");
                    else
                        System.out.print("0 ");
                }
                System.out.println("(Water)");
            } //GroundWater = 2 means Water
            else {
                Ground ground = new Ground();
                for (int j = 0; j < ground.getFieldSize(); j++) {
                    if (ground.isTree(j))
                        System.out.print("0 ");
                    else
                        System.out.print("1 ");
                }
                System.out.println("(Ground)");
            }
        }
    }
}
package Field;

import Point.Point;

import java.util.Random;
import java.util.Vector;


public class Ground extends Field{
    private Vector<Boolean> hasTree;

    public Ground(){
		super(1);
        hasTree = new Vector<>(fieldSize);
        for(int i=0; i<fieldSize; i++){
            hasTree.add(false);
        }
        this.generateTree();
	}
	
    public Ground(Point P){
		super(1, P);
        hasTree = new Vector<>(fieldSize);
        for(int i=0; i<fieldSize; i++){
            hasTree.add(false);
        }
        this.generateTree();
    }

    public boolean isTree(int index){ return hasTree.elementAt(index); }

    public void setTree(int index, boolean _hasTree){ hasTree.setElementAt(_hasTree, index); }

    public void generateTree(){
        Random random = new Random();
        int numOfTrees = random.nextInt(fieldSize/2) + 1;
        while(numOfTrees!=0){
            int randomPosition = random.nextInt(fieldSize);
            if(!isTree(randomPosition)){
                this.setTree(randomPosition, true);
                numOfTrees--;
            }
        }
    }

    public void moveField(){
        boolean temp = hasTree.remove(0);
        hasTree.add(temp);
    }
}

package Field;

import Point.Point;

import java.util.Random;
import java.util.Vector;


public class Ground extends Field{
    private Vector<Boolean> tree;

    public Ground(){
		super(1);
        tree = new Vector<>(fieldSize);
        for(int i=0; i<fieldSize; i++){
            tree.add(false);
        }
        this.generateTree();
	}
	
    public Ground(Point P){
		super(1, P);
        tree = new Vector<>(fieldSize);
        for(int i=0; i<fieldSize; i++){
            tree.add(false);
        }
        this.generateTree();
        Random random = new Random();
        direction = random.nextInt(1);
    }

    public boolean isTree(int index){ return tree.elementAt(index); }

    public void setTree(int index, boolean _tree){ tree.setElementAt(_tree, index); }

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
        boolean temp = tree.remove(0);
        tree.add(temp);
    }

    @Override
    public String toString() {
        String ret = "";
        for(int i=0; i<tree.size(); i++){
            if(tree.elementAt(i))
                ret += "1 ";
            else
                ret += "0 ";
        }
        return ret;
    }
}

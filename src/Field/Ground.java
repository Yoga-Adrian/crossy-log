package Field;

import Point.Point;

import java.util.Random;


public class Ground extends Field{
    public Ground(){
		super(1);
        for(int i=0; i<fieldSize; i++){
            item.add(false);
        }
        this.generateRandom();
	}

    public Ground(final Ground G){
        super(1);
        for(int i=0; i<G.fieldSize; i++){
            item.add(G.isItem(i));
        }
    }

    public Ground(Point P){
		super(1, P);
        for(int i=0; i<fieldSize; i++){
            item.add(false);
        }
        this.generateRandom();
        Random random = new Random();
        direction = random.nextInt(1);
    }

    public void generateRandom(){
        Random random = new Random();
        int numOfItems = random.nextInt(fieldSize/2) + 1;
        while(numOfItems!=0){
            int randomPosition = random.nextInt(fieldSize);
            if(!isItem(randomPosition)){
                this.setItem(randomPosition, true);
                numOfItems--;
            }
        }
    }

    @Override
    public String toString() {
        String ret = "";
        for(int i=0; i<item.size(); i++){
            if(item.elementAt(i))
                ret += "1 ";
            else
                ret += "0 ";
        }
        return ret;
    }
}

package Char;

import Command.karakterthread;
import Field.Ground;
import Field.Water;
import Point.Point;

import java.awt.event.KeyEvent;
import java.util.Random;


public class Karakter {
	private String Name;
	private Point cPosition;
	private int cDirection;
	private boolean Alive;
	private final int fieldSize = 7;

	public Karakter(){
		Name = "Doge";
		cPosition = new Point();
		cDirection = 0;
		Alive = true;
	}

	public Karakter(String _Name){
		Name = _Name;
		cPosition = new Point();
		Alive = true;
	}

	public Karakter(final Karakter K){
		Name = K.Name;
		cPosition = new Point(K.cPosition);
		Alive = K.Alive;
	}

	public void setKarakter(Karakter _player){
		this.setName(_player.getName());
		this.setStatus(_player.getStatus());
		this.setCPosition(_player.getCPosition());
	}

	public String getName(){
		return Name;
	}

	public void setName(String _Name){
		Name = _Name;
	}

	public Point getCPosition(){
		return cPosition;
	}

	public int getCDirection() {
		return cDirection;
	}

	public boolean getStatus(){
		return Alive;
	}

	public void setCPosition(Point P){
		cPosition.setAbsis(P.getAbsis());
		cPosition.setOrdinat(P.getOrdinat());
	}
	public void setCPosition(int x, int y){
		cPosition.setAbsis(x);
		cPosition.setOrdinat(y);
	}
	public void setCDirection(int _direct){
		cDirection = _direct;
	}

	public void setStatus(boolean _Alive){
		Alive = _Alive;
	}

	public void PrintKarakter(){
		System.out.println(getName());
		System.out.println(getCPosition());
		System.out.println(getCDirection());
		System.out.println(getStatus());
	}

	public void keyReleased(int key){
		switch(key) {
			case KeyEvent.VK_UP:
				karakterthread.vector.elementAt(0).stopthread();
				karakterthread.vector.remove(0);
				Random random = new Random();
				if(random.nextInt(2)+1 == 1){
					Ground ground = new Ground();
					karakterthread.vector.add(ground);
				} else{
					Water water = new Water();
					karakterthread.vector.add(water);
					karakterthread.vector.elementAt(11).start();
				}
				karakterthread.moveMap();
				break;
			case KeyEvent.VK_DOWN:
				break;
			case KeyEvent.VK_RIGHT:
				if(cPosition.getAbsis() == (fieldSize-1)){
					cPosition.setAbsis(0);
				} else {
					cPosition.setAbsis(cPosition.getAbsis()+1);
				}
				break;
			case KeyEvent.VK_LEFT:
				if(cPosition.getAbsis() == 0){
					cPosition.setAbsis(fieldSize - 1);
				} else {
					cPosition.setAbsis(cPosition.getAbsis()-1);
				}
				break;
		}
	}

}

package Char;

import Main.Main;
import Field.Ground;
import Field.Water;
import Point.Point;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * class Karakter
 * Kelas ini merupakan objek dari karakter yang akan digunakan
 * di kelas Main sebagai karakter utama
 */

public class Karakter {
	private String Name;
	private Point cPosition;
	private int cDirection;
	private boolean alive;
	private final int fieldSize = 7;

	/**
	 * Konstruktor Karakter
	 */
	public Karakter(){
		Name = "Doge";
		cPosition = new Point();
		cDirection = 0;
		alive = true;
	}

	/**
	 * Konstruktor Karakter
	 * @param _Name String nama karakter
	 */
	public Karakter(String _Name){
		Name = _Name;
		cPosition = new Point();
		alive = true;
	}

	/**
	 * Konstruktor Karakter
	 * @param K sebuah objek Karakter
	 */
	public Karakter(final Karakter K){
		Name = K.Name;
		cPosition = new Point(K.cPosition);
		alive = K.alive;
	}

	/**
	 * Method setKarakter
	 * Copy seluruh value dari Karakter input ke this
	 * @param _player Karakter lain
	 */
	public void setKarakter(Karakter _player){
		this.setName(_player.getName());
		this.setStatus(_player.getStatus());
		this.setCPosition(_player.getCPosition());
	}

	/**
	 * Method getName
	 * @return Nama karakter
	 */
	public String getName(){
		return Name;
	}

	/**
	 * Method setName
	 * @param _Name Nama baru
	 */
	public void setName(String _Name){
		Name = _Name;
	}

	/**
	 * Method getCPosition
	 * @return posisi karakter
	 */
	public Point getCPosition(){
		return cPosition;
	}

	/**
	 * Method getCDirection
	 * @return arah karakter
	 */
	public int getCDirection() {
		return cDirection;
	}

	/**
	 * Method getStatus
	 * @return status karakter
	 */
	public boolean getStatus(){
		return alive;
	}

	/**
	 * Method setCPosition
	 * @param P posisi baru
	 */
	public void setCPosition(Point P){
		cPosition.setAbsis(P.getAbsis());
		cPosition.setOrdinat(P.getOrdinat());
	}

	/**
	 * Method setPosition
	 * @param x absis baru
	 * @param y ordinat baru
	 */
	public void setCPosition(int x, int y){
		cPosition.setAbsis(x);
		cPosition.setOrdinat(y);
	}

	/**
	 * Method setCDirection
	 * @param _direct arah baru
	 */
	public void setCDirection(int _direct){
		cDirection = _direct;
	}

	/**
	 * Method setStatus
	 * @param _alive status baru karakter
	 */
	public void setStatus(boolean _alive){
		alive = _alive;
	}

	/**
	 * Method printKarakter
	 */
	public void printKarakter(){
		System.out.println(getName());
		System.out.println(getCPosition());
		System.out.println(getCDirection());
		System.out.println(getStatus());
	}

	/**
	 * Method keyReleased
	 * Method ini melakukan
	 * @param key kode keyboard
	 */
	public void keyReleased(int key){
		switch(key) {
			case KeyEvent.VK_UP:
				Main.score+=1;
				Main.vector.elementAt(0).stopThread();
				Main.vector.remove(0);
				Random random = new Random();
				if(random.nextInt(2)+1 == 1){
					Ground ground = new Ground();
					Main.vector.add(ground);
				} else{
					Water water = new Water();
					Main.vector.add(water);
					Main.vector.elementAt(11).start();
				}
				GUI.KarakterGUI.moveMap();
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

package Char;

import Point.Point;

public class Karakter {
    private String Name;
	private Point cPosition;
	private boolean Alive;
	
	public Karakter(){
		Name = "Doge";
		cPosition = new Point();
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
	
	public boolean getStatus(){
		return Alive;	
	}
	
	public void setCPosition(Point P){
		cPosition.setAbsis(P.getAbsis());
		cPosition.setOrdinat(P.getOrdinat());
	}
	
	public void setStatus(boolean _Alive){
		Alive = _Alive;
	}	
	
	public void PrintKarakter(){
		System.out.println(getName());
		System.out.println(getCPosition());
		System.out.println(getStatus());
	}

}

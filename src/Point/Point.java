package Point;

/**
 * class Point
 * merupakan kelas untuk menampung absis dan ordinat
 * serta getter dan setter nya
 */
public class Point {
	private int x;
	private int y;

	/**
	 * Konstruktor
	 */
	public Point(){
		x = 0;
		y = 0;
	}

	/**
	 * Konstruktor berparameter
	 * @param _x absis
	 * @param _y ordinat
	 */
	public Point(int _x, int _y){
		x = _x;
		y = _y;
	}

	/**
	 * Konstruktor berparameter
	 * @param P Point lain
	 */
	public Point(final Point P){
		x = P.x;
		y = P.y;
	}

	/**
	 * Method getAbsis
	 * @return absis
	 */
	public int getAbsis(){
		return x;
	}

	/**
	 * Method getOrdinat
	 * @return ordinat
	 */
	public int getOrdinat(){
		return y;
	}

	/**
	 * Method setAbsis
	 * @param _x absis baru
	 */
	public void setAbsis(int _x){
		this.x = _x;
	}

	/**
	 * Method setOrdinat
	 * @param _y ordinat baru
	 */
	public void setOrdinat(int _y){
		this.y = _y;
	}

	/**
	 * Method setPoint
	 * @param _x absis baru
	 * @param _y ordinat baru
	 */
	public void setPoint(int _x, int _y){
		this.setAbsis(_x);
		this.setOrdinat(_y);
	}

	/**
	 * Method toString
	 * Method ini melakukan Override untuk print ke layar
	 * @return (x,y)
	 */
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
}


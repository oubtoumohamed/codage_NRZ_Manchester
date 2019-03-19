public class Point {
	private float x;
	private float y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	public Point(float x, float y) {
		this.setX( x );
		this.setY( y );
	}	

	// getter & setter X
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	
	// getter & setter Y
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
}

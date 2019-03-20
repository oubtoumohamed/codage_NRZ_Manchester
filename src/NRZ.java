
public class NRZ extends Codage {

	public NRZ() {
	}
	
	public NRZ(String c) {
		this.setCode( c );
	}
	
	public float positionY(char c) {
		return ( c == '0' ) ? -1 : 1;
	}
	public float positionX(float x,char c) {
		return x+1;
	}
	
	public Ligne traceLigne(Ligne l, float x, float y, char c) {
		y = this.positionY( c );
		l.setDebut( new Point(x,y) );
		x = this.positionX( x, c );
		l.setFin( new Point(x,y) );
		
		return l;
	}
	
	public String getTitle() {
		return "Code NZR ( Non Return to Zero )";
	}
}

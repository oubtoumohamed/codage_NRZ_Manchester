
public class Manchester extends Codage {

	public Manchester() {
	}
	
	public Manchester(String c) {
		this.setCode( c );
	}
	
	public float positionY(char c) {
		return ( c == '0' ) ? -1 : 1;
	}
	public float positionX(float x,char c,char nextC) {
		float p = (float) 0.5;
		
		/*if( c == '0' ) 
			p = 1;*/
		
		return x+p;
	}
	
	public Ligne traceLigne(Ligne l, float x, float y, char c) {
		y = this.positionY( c );
		l.setDebut( new Point(x,y) );
		x = this.positionX( x, c ,c);
		l.setFin( new Point(x,y) );
		
		this.addLigne(l);
		l = new Ligne();
		
		y = y * (-1);
		l.setDebut( new Point(x,y) );
		x = this.positionX( x, c ,c);
		l.setFin( new Point(x,y) );
		
		return l;
	}
	
	public String getTitle() {
		return "Code biphasé ( Manchester )";
	}
}